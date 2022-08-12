package com.mherman22.KTMInv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mherman22.KTMInv.security.jsonWebToken.AuthEntryPointJwt;
import com.mherman22.KTMInv.security.jsonWebToken.AuthTokenFilter;
import com.mherman22.KTMInv.security.services.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private AuthEntryPointJwt authEntryPointJwt;
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
	    return new AuthTokenFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    authenticationManagerBuilder.userDetailsServiceImpl(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	  }

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable()
	      .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
	      .antMatchers("/api/test/**").permitAll()
	      .anyRequest().authenticated();
	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
