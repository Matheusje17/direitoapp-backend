package com.direitoapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direitoapp.domain.Advogado;


public interface AdvogadoRepository extends JpaRepository<Advogado, Integer>{
	Optional<Advogado> findByOab(String oab);
}
