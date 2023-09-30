//package com.direitoaumclique.backend.services;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.direitoaumclique.backend.domain.Pessoa;
//import com.direitoaumclique.backend.repositories.PessoaRepository;
//import com.direitoaumclique.backend.security.UserSS;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService{
//
//	@Autowired
//	private PessoaRepository pessoaRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<Pessoa> user = pessoaRepository.findByEmail(email);
//		System.out.println("USer" + user.get().getEmail());
//		if (user.isPresent()) {
//			return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getSenha(), user.get().getPerfis());
//		}
//		throw new UsernameNotFoundException(email);
//	}
//
//}
