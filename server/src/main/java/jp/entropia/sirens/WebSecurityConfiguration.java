package jp.entropia.sirens;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.
            jdbcAuthentication()
            .dataSource(dataSource);
        // TODO passwordEncoder()でbcrypt使うように設定する
    }
    
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers(
    			"/", "/index.html", "/fonts/**", "/images/**", "/styles/**", "/scripts/**", "/views/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().anyRequest().authenticated();
    	http
    	    .csrf().disable()
    	    .httpBasic().disable()
    	    .logout().logoutUrl("/hoge")
        .and()
	        .apply(new SpringSocialConfigurer().postLoginUrl("/nowloading"))
	    .and()
	        .exceptionHandling().defaultAuthenticationEntryPointFor(
                    ajaxAuthenticationEntryPoint(),
                    ajaxRequestMatcher()
                );
    }
    
    @Bean
    public AuthenticationEntryPoint ajaxAuthenticationEntryPoint() {
	    return new AuthenticationEntryPoint() {
	        @Override
	        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
	        	// preflightリクエストは未認証でも401を返さない
	            if("OPTIONS".equals(request.getMethod()) == false) {
	            	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            }
	        }
	    };
    }
    
    @Bean
    public RequestMatcher ajaxRequestMatcher() {
        return new RequestHeaderRequestMatcher("X-Requested-With", "XMLHttpRequest");
    }

    @Bean
    public RequestMatcher logoutRequestMatcher() {
        return new AntPathRequestMatcher("/logout");
    }
    
    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new SimpleSocialUsersDetailService(userDetailsService());
    }

}
