package com.direitoapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.Caso;

public interface AdvogadoCasoRepository extends JpaRepository<AdvogadoCaso, Integer>{
	Optional<List<AdvogadoCaso>>  findByCaso(Caso caso);
	Optional<List<AdvogadoCaso>> findByAdvogadoAtendimento(Advogado advogadoAtendimento);
	
	@Query("SELECT c FROM AdvogadoCaso c WHERE c.caso = :caso AND c.advogadoAtendimento = :advogadoAtendimento")
	Optional<AdvogadoCaso> findByCasoEAdvogado(@Param("caso")Caso caso, @Param("advogadoAtendimento") Advogado advogadoAtendimento);

} 