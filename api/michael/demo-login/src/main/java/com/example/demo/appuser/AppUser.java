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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
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
    public AppUser(String name, String username, String email, com.example.demo.appuser.AppUserRole appUserRole, Boolean locked,
			Boolean enabled, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		AppUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}

	private String name;
    private String username;
    private String email;
	private String password;
	@Enumerated(EnumType.STRING)
    private AppUserRole AppUserRole;
    private Boolean locked;
    private Boolean enabled;


    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
         new SimpleGrantedAuthority(AppUserRole.name());
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
