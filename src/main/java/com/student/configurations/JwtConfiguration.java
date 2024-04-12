package com.student.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.student.exception.JwtAuthExceEntryPoint;
import com.student.filters.JwtPreFilter;
import com.student.userdetails.ProjectUserDetails;

@Configuration
@EnableWebSecurity
public class JwtConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthExceEntryPoint exceptionAuthExceEntryPoint;
	
	@Autowired
	private ProjectUserDetails projectUserDetails;
	
	@Autowired
	private JwtPreFilter jwtPreFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(projectUserDetails);
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
				.cors(c->c.disable()) .csrf(cr->cr.disable()) 
				.authorizeHttpRequests(auth->auth.antMatchers("/auth/**").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()) 
				.exceptionHandling(ex->ex.authenticationEntryPoint(exceptionAuthExceEntryPoint)) 
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		httpSecurity.addFilterBefore(jwtPreFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	

	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}

}
