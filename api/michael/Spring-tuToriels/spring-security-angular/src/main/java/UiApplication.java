

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableZuulProxy
public class UiApplication {

  public static void main(String[] args) {
    SpringApplication.run(UiApplication.class, args);
  }

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@Configuration
	
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/home", "/login").permitAll()
					.anyRequest().authenticated().and().csrf()
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		}
		@RequestMapping("/token")
		public Map<String,String> token(HttpSession session) {
		  return Collections.singletonMap("token", session.getId());
		}
	  
	}
}