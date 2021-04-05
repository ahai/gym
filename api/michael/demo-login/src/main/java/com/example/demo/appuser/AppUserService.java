package com.example.demo.appuser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
public class AppUserService implements UserDetailsService{
    
	private final static String USER_NOT_FOUND_MSG =
			"user with email %s not found"; 
	
	private final AppUserRepository appUserRepository;
	
	

	public AppUserService(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow((() -> 
				       new UsernameNotFoundException(
						       String.format(USER_NOT_FOUND_MSG, email))));
	}

}
