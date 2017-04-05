package com.rh.udcs.web.configs;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author hongzheng.liu
 */
@Configuration
@PropertySource({"${comConfig.file:classpath:configs/config.properties}",
		"${comConfig.file:classpath:configs/dbs.properties}",
		"${amqConfig.file:classpath:configs/amq_config.properties}"})
public class LocaleConfig extends WebMvcConfigurerAdapter implements EnvironmentAware {
	private Environment env;

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	@Bean(name = "localeResolver")
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName(env.getProperty("spring.locale.cookieName", "me.locale"));
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		final LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("locale");
		registry.addInterceptor(localeChangeInterceptor);
	}

}
