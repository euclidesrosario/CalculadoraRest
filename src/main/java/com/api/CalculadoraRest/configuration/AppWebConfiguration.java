package com.api.CalculadoraRest.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppWebConfiguration {

	public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }
}
