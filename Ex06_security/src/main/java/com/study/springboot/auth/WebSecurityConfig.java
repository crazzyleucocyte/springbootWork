package com.study.springboot.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//csrf는사이트간 이동을 할떄 누군가 값을 바꿔서 바꾼 값을 다른 사이트에 전달 할 수 있는데
		//이거를 토큰을 발행해서 막아줄수 있는데 우리는 너무 복잡해서 disabled했다.
		//cors는 resources에 관한것
			http.csrf((csrf) -> csrf.disable())
				.cors((cors) -> cors.disable())
				.authorizeHttpRequests(request -> request
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/css/**","/js/**","/img/**").permitAll()
						.requestMatchers("/guest/**").permitAll()
						//hasAnyRole에 지정한 항목의 계정들만 멤버에 들어올스 있다는 뜻
						.requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
						//hasRole은 하나의 항목만 허용할때
						.requestMatchers("/admin/**").hasRole("ADMIN")
						// .anyRequest().authenticated() :
   		                // 위 리소스를 설정 후 그외 나머지 리소스들은 무조건 인증을 완료해야 접근이 가능하다는 의미.
						.anyRequest().authenticated()
				);
			//기본 페이지를 보여준다는 뜻
			http.formLogin((formLogin) -> formLogin.permitAll());
			http.logout((logout) -> logout.permitAll());
		return http.build();
	}
	
	//db에 넣지 않고 메모리에 저장할때 쓰는 내용
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				//아래에 만들어준 패스워드 암호화를 써서 encode에 쓴 암호를 암호화한다는 뜻
				.password(passwordEncoder().encode("1234"))
				//계정들의 접속 권한을 관리하기 위한 범주
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
				//만든 계정을 메모리에 넣겠다는 뜻
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	//내가 입력한 비번이 다른사람이 쓰는 비번이랑 똑같아도 쓸 수 있는 이유는 그 비번 뒤에 랜덤한 숫자나 문자같은게 붙어서 암호화 되기 때문
	//패스워드 암호화
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	
	
}
