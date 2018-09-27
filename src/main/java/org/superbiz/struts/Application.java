package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new FilterDispatcher());
        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("actionPackages", "com.lq");

        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new ActionContextCleanUp());
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new PageFilter());
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }
}
