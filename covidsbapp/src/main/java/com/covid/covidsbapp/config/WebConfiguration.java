package com.covid.covidsbapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//The WebConfiguration class you provided
// is a custom configuration class that enables CORS (Cross-Origin Resource Sharing)
/*CORS is a mechanism that allows browsers to make requests to a domain other than
the one that served the web page. This is important for situations where your
frontend (UI) and backend (API) are hosted on different domains or ports
(e.g., your UI might be on localhost:5500 and the API on localhost:8080).
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}