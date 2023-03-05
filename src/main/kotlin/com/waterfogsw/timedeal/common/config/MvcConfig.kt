package com.waterfogsw.timedeal.common.config

import com.waterfogsw.timedeal.common.auth.AuthInterceptor
import com.waterfogsw.timedeal.common.auth.UserPrincipalArgumentResolver
import com.waterfogsw.timedeal.common.converter.StringToLocalDateTimeConverter
import jakarta.servlet.http.HttpSession
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig(
    private val httpSession: HttpSession,
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authInterceptor())
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(userPrincipalArgumentResolver())
    }

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(StringToLocalDateTimeConverter())
    }

    @Bean
    fun userPrincipalArgumentResolver() = UserPrincipalArgumentResolver(httpSession)

    @Bean
    fun authInterceptor() = AuthInterceptor(httpSession)
}
