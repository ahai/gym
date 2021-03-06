package com.example.demo.appuser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode
@NoArgsConstructor
@Entity

<<<<<<< HEAD
		
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			
    )
=======
public class AppUser implements UserDetails {
	
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42
	
	@Id
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize=1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"

	)
<<<<<<< HEAD
	
	private Long id;  
=======

	private Long id;
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42
	private String name;
	private String username;
	private String email;
	private String password;
<<<<<<< HEAD
	
	@Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    public AppUser(String name, String username, String email, AppUserRole appUserRole, Boolean locked,
			Boolean enabled, String password) {
		
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.appUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
         new SimpleGrantedAuthority(appUserRole.name());
		return Collections.singletonList(authority);
=======

	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked;
	private Boolean enabled;
	

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority authority = 
			new SimpleGrantedAuthority(appUserRole.name());
		
		return Collections.singleton(authority);
>>>>>>> cb6eda40e85a8c2b5a31f62b7db489abd604ff42
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public AppUser(String name, 
	String username, String email, String password, AppUserRole appUserRole, Boolean locked,
			Boolean enabled) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.appUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}

}
