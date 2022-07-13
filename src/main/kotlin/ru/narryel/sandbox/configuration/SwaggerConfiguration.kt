package ru.narryel.sandbox.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfiguration {

    @Bean
    fun springShopOpenAPI() = OpenAPI()
        .info(
            Info().apply {
                title("sandbox")
                description("Spring sandbox application")
                version("v0.0.1")
                license(License().name("Apache 2.0").url("http://springdoc.org"))
            })
}