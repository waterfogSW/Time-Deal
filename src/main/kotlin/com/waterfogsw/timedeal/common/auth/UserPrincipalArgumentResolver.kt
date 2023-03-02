package com.waterfogsw.timedeal.common.auth

import com.waterfogsw.timedeal.common.annotation.Principal
import com.waterfogsw.timedeal.user.domain.UserPrincipal
import jakarta.servlet.http.HttpSession
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

class UserPrincipalArgumentResolver(
    private val httpSession: HttpSession,
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean =
        parameter.getParameterAnnotation(Principal::class.java) != null &&
            parameter.parameterType.isAssignableFrom(UserPrincipal::class.java)

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): Any {
        val userPrincipal = httpSession.getAttribute(UserPrincipal.SESSION_NAME) as UserPrincipal
        println(userPrincipal)
        return userPrincipal
    }
}
