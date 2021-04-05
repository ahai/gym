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
public class AppUser implements UserDetails{

		
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			
    )
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	
	private Long id;  
	private String name;
    private String username;
    private String email;
	private String password;
	
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
	}

	@Override
	public String getPassword() {
		return this.password;
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
		return enabled;
	}
    
}
