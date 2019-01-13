package pl.piomin.services.config

import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.TagsSorter
import springfox.documentation.swagger.web.OperationsSorter
import springfox.documentation.swagger.web.DocExpansion
import springfox.documentation.swagger.web.ModelRendering
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("1.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
    }

    @Bean
    fun uiConfig(): UiConfiguration {
        return UiConfiguration(java.lang.Boolean.TRUE, java.lang.Boolean.FALSE, 1, 1, ModelRendering.MODEL, java.lang.Boolean.FALSE, DocExpansion.LIST, java.lang.Boolean.FALSE, null, OperationsSorter.ALPHA, java.lang.Boolean.FALSE, TagsSorter.ALPHA, UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, null)
    }

    private fun apiInfo(version: String): ApiInfo {
        return ApiInfoBuilder()
                .title("API - Person Service")
                .description("Persons Management")
                .version(version)
                .build()
    }

}