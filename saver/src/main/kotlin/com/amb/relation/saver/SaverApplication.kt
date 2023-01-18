package com.amb.relation.saver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.CommonsRequestLoggingFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import simplenlg.framework.NLGElement
import simplenlg.framework.NLGFactory
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser


@SpringBootApplication
class SaverApplication {

    @Bean
    fun requestLoggingFilter(): CommonsRequestLoggingFilter? {
        val loggingFilter = CommonsRequestLoggingFilter()
        loggingFilter.setIncludeClientInfo(true)
        loggingFilter.setIncludeQueryString(true)
        loggingFilter.setIncludePayload(true)
        loggingFilter.setMaxPayloadLength(64000)
        return loggingFilter
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/*").allowedOrigins("http://localhost:4200")
            }
        }
    }
}

fun main(args: Array<String>) {
	runApplication<SaverApplication>(*args)
}


