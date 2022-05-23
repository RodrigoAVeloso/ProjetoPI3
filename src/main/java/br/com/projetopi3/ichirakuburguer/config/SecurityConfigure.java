package br.com.projetopi3.ichirakuburguer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	 public static PasswordEncoder plainPasswordEncoder() {
	        return new PasswordEncoder() {

	            @Override
	            public String encode(CharSequence cs) {
	                return cs.toString();
	            }

	            @Override
	            public boolean matches(CharSequence cs, String hashSenha) {
	                return hashSenha
	                        != null && hashSenha.equals(cs.toString());
	            }
	        };
	    }

	    public static PasswordEncoder bcryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return plainPasswordEncoder();
	    }
	
		/*
		 * @Bean private static BCryptPasswordEncoder encoder() {return new
		 * BCryptPasswordEncoder();}
		 */
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll()
		;
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .anyRequest().authenticated() .and() .httpBasic()
	 * .and() .logout() .and() .csrf().disable(); }
	 */

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.userDetailsService(customUserDetailService).passwordEncoder(new
	 * BCryptPasswordEncoder()); }
	 */

	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("rodrigo").password(encoder().encode("654123")).authorities("USER")
	 * .and()
	 * .withUser("admin").password(encoder().encode("654123")).authorities("USER",
	 * "ADMIN");
	 * 
	 * }
	 */
	 
}
