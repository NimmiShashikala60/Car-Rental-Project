package lk.ijse.spring.config;


import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.AdminInformationController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AdminInformationController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
}