package br.ifrn.edu.livraria.conf;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;





/**
 * 
 * Essa classe serve para configurar o Spring Security
 * 
 * Essa @configuration serve para avisar ao spring Boot que essa classe é de
 * configuração;
 * 
 * @author Jeferson
 *
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/distribution/**",  "/StarAdmin/**", "/h2/**", "/admin").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/entrar").permitAll()
				.successForwardUrl("/index").and().logout().permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/entrar");
		
		http.csrf().disable();
	
	}
	
	
	/*@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/
	
	@Autowired
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password(passwordEncoder().encode("user1")).roles("USER")
          .and()
          .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }
	

		
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
