package com.example.demo.appuser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
<<<<<<< HEAD

public interface AppUserRepository
        extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
    
}
=======
public interface AppUserRepository extends JpaRepository<AppUser, Long> {


    Optional <AppUser> findByEmail(String email);
	
	
	

}
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42
