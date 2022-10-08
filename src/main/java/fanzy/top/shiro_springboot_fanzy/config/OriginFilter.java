/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-10-08 21:54
 **/
package fanzy.top.shiro_springboot_fanzy.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
@Configuration
public class OriginFilter {
	@SuppressWarnings("unchecked")
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
		corsConfiguration.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
		corsConfiguration.setAllowedMethods(Collections.singletonList(CorsConfiguration.ALL));
		corsConfiguration.addExposedHeader("Authorization");
		source.registerCorsConfiguration("/**", corsConfiguration);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}

