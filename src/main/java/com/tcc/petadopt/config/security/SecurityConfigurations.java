//package com.tcc.petadopt.config.security;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableWebSecurity
//@Configuration
//public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private AutenticacaoService autenticacaoService;
	
	//Configuracoes de autenticacao
//	@Override
///	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
//	}
	
	//Configuracoes de autorizacao
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/categorias").permitAll()
//		.antMatchers(HttpMethod.POST, "/categorias").permitAll()
//		.antMatchers(HttpMethod.GET, "/categorias/*").permitAll()
////		.antMatchers("/h2-console").permitAll()
//		.antMatchers("/console/**").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin();
//	}
	
	
	//Configuracoes de recursos estaticos(js, css, imagens, etc.)
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	}
	
//}
