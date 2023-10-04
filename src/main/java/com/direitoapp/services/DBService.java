package com.direitoapp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.Caso;
import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.enums.Perfil;
import com.direitoapp.domain.enums.Status;
import com.direitoapp.domain.enums.TipoCaso;
import com.direitoapp.repositories.AdvogadoCasoRepository;
import com.direitoapp.repositories.AdvogadoRepository;
import com.direitoapp.repositories.CasoRepository;
import com.direitoapp.repositories.ClienteRepository;

@Service
public class DBService {
	@Autowired
	private AdvogadoRepository advogadoRepository ;
	
	@Autowired
	private AdvogadoCasoRepository advogadoCasoRepository;
	
	@Autowired
	private CasoRepository casoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	@Autowired private BCryptPasswordEncoder encoder;;
	
	public void instanciaDB() {
		
		Advogado adv1 = new Advogado(null, "Valéria", "valeria@mail.com", "13988458710", true,"12345", "11442331", "123-789");
		adv1.addPerfil(Perfil.ADVOGADO);
		
		Cliente cli1 = new Cliente(null, "Matheus", "teste@mail.com", "13988452210", false, "54321", "11442331");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Caso caso1 = new Caso(null, "Titulo", false, "Desqcrição aqui", Status.AGUARDANDO, TipoCaso.TRABALHISTA, cli1, adv1, "sp", "gja");
		AdvogadoCaso advCaso1 = new AdvogadoCaso(caso1, adv1, cli1);
		
		Advogado adv2 = new Advogado(null, "Geleia", "geleia@mail.com", "13988451110", true,"123245", "11442331", "123-119");
		adv1.addPerfil(Perfil.ADVOGADO);
		
		Cliente cli2 = new Cliente(null, "Jao", "jao@mail.com", "13933452210", false, "1244345", "11442331");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Caso caso2 = new Caso(null, "Titulo2", false, "Desqcrição aqui2", Status.AGUARDANDO, TipoCaso.CRIMINAL, cli2, adv2, "São Paulo", "Guarujá");
		AdvogadoCaso advCaso2 = new AdvogadoCaso(caso2, adv2, cli2);
		
		
		
		advogadoRepository.saveAll(Arrays.asList(adv1,adv2));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		casoRepository.saveAll(Arrays.asList(caso1, caso2));
		advogadoCasoRepository.saveAll(Arrays.asList(advCaso1, advCaso2));
	}
}
