package com.direitoapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.direitoapp.domain.Caso;
import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.enums.TipoCaso;


public interface CasoRepository extends JpaRepository<Caso, Integer>{
	Optional<List<Caso>> findByCliente(Cliente cliente);
	
	@Query("SELECT c FROM Caso c WHERE c.tipoCaso = :tipoCaso AND c.estado = :estado AND c.cidade = :cidade")
	Optional<List<Caso>> findByTipoERegiao(@Param("tipoCaso")TipoCaso tipoCaso, @Param("estado") String estado, @Param("cidade") String cidade);
}
