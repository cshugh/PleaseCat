package com.ssafy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2	//스웨거 환경설정
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("PleaseCat-controller") //서비스할 project 이름이나 Domain이름
				.apiInfo(info()) //스웨거 화면에 표시할 설명 정보
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.controller")) //서비스할 애들.
				.paths(PathSelectors.ant("/api/**")) //경로 잡아주기 . ant로 pattern처리 phone으로 들어오는 모든것
				.build(); //빌드패턴 : 객체 생성할때 .을 통해서 다양한 설정을 해주고나서 마지막에 build로 마무리함
		
		
	}
	private ApiInfo info() {
		return new ApiInfoBuilder().title("고양이를 부탁캣")
				.description("PleaseCat API Reference for Developers")
				.license("PLEASE CAT MANAGEMENT 2020")
				.version("1.0")
				.build();
	}
	
	
}
