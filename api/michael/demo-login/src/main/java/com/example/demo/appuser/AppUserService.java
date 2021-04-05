package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
<<<<<<< HEAD
public class AppUserService implements UserDetailsService{
    
	private final static String USER_NOT_FOUND_MSG =
			"user with email %s not found"; 
	
	private final AppUserRepository appUserRepository;
	
	
=======
public class AppUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return appUserRepository.findByEmail(email)
            .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    
    private final static String USER_NOT_FOUND=
    "user with email %s not found";

    @Autowired
    private final AppUserRepository appUserRepository;
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42

	public AppUserService(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}
    


<<<<<<< HEAD

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow((() -> 
				       new UsernameNotFoundException(
						       String.format(USER_NOT_FOUND_MSG, email))));
	}
=======
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42

}
