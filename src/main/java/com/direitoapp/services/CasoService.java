package com.direitoapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.Caso;
import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.dtos.CasoDTO;
import com.direitoapp.domain.enums.Status;
import com.direitoapp.domain.enums.TipoCaso;
import com.direitoapp.repositories.AdvogadoCasoRepository;
import com.direitoapp.repositories.CasoRepository;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;



@Service
public class CasoService {
	
	@Autowired
	private CasoRepository casoRepository;
		
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AdvogadoCasoRepository advogadoCasoRepository;
	
	public Caso findById(Integer id) {
		Optional<Caso> caso = casoRepository.findById(id);
		return caso.orElseThrow(() -> new ObjectNotFoundException("Caso não encontrado: " + id));
	}

	public List<Caso> findAll() {
		return casoRepository.findAll();
	}

	public Caso create(@Valid CasoDTO casoDTO) {
		Cliente cli = clienteService.findById(casoDTO.getClienteId());
		casoDTO.setEstado(cli.getEstado());
		casoDTO.setCidade(cli.getCidade());
		casoDTO.setStatus(Status.AGUARDANDO_ADVOGADOS.getDescricao());
		return casoRepository.save(newCaso(casoDTO));
	}
	

	public Caso update(Integer id, @Valid CasoDTO casoDTO) {
		
		casoDTO.setId(id);
		Caso casoOld = findById(id);
		casoOld = newCaso(casoDTO);
		
		return casoRepository.save(casoOld);
	}
	
	
	public List<Caso> findByCliente(Integer id) {
		Cliente cli = clienteService.findById(id);
		Optional<List<Caso>> casos = casoRepository.findByCliente(cli);
		
		List<Caso> casosList = casos.get();
		return casosList;
	}
	
	public List<Caso> findByTipoERegiao(String tipoCaso, String estado, String cidade) {
		Optional<List<Caso>> casos = casoRepository.findByTipoERegiao(TipoCaso.toEnum(tipoCaso), estado, cidade);
		return casos.get();
	}
	
	
	private Caso newCaso(CasoDTO casoDTO) {
		Cliente cliente = clienteService.findById(casoDTO.getClienteId());
		
		Caso caso = new Caso();
		
		if (casoDTO.getId() != null) {
			caso.setId(casoDTO.getId());
		}
		
		caso.setCliente(cliente);
		caso.setTitulo(casoDTO.getTitulo());
		caso.setDescricao(casoDTO.getDescricao());
		caso.setIsUrgente(casoDTO.getIsUrgente());
		caso.setStatus(Status.toEnum(casoDTO.getStatus()));
		caso.setTipoCaso(TipoCaso.toEnum(casoDTO.getTipoCaso()));
		caso.setCidade(casoDTO.getCidade());
		caso.setEstado(casoDTO.getEstado());
		
		return caso;
	}

	public void delete(Integer id) {
		Caso caso = findById(id);
		List<AdvogadoCaso> advCasoList = new ArrayList<>();
		if(caso.getAdvogadoCaso().size() > 0) {
			for (AdvogadoCaso advCaso : caso.getAdvogadoCaso()) {
				advCaso.setStatus(Status.REMOVIDO.getCodigo());
				advCasoList.add(advCaso);
			}
			advogadoCasoRepository.saveAll(advCasoList);
		}

		casoRepository.deleteById(id);
		
	}



}
