package me.chenhai.demo;

import me.chenhai.demo.activiti.modeler.JsonpCallbackFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan({"org.activiti.rest.diagram", "me.chenhai.demo"})
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.activiti.spring.boot.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
//@EnableAsync
public class SpringBootWithActivitiModelerApplication extends SpringBootServletInitializer {

	//war包，发布到外部tomcat，继承SpringBootServletInitializer，重写configure()方法，修改pom.xml
	/*
	*	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<!-- provided 表明该包只在编译和测试的时候使用，去除默认的springboot内置tomcat -->
			<scope>provided</scope>
		</dependency>
	*
	* */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
//        return super.configure(builder);
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithActivitiModelerApplication.class, args);
	}

	@Bean
	public JsonpCallbackFilter filter(){
		return new JsonpCallbackFilter();
	}

}
