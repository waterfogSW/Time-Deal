package com.waterfogsw.timedeal.common.auth

import com.waterfogsw.timedeal.common.annotation.Auth
import com.waterfogsw.timedeal.user.domain.UserPrincipal
import jakarta.servlet.http.*
import org.springframework.http.HttpStatus
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor

class AuthInterceptor(
    private val httpSession: HttpSession,
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        val authAnnotation = getAuthAnnotation(handler as HandlerMethod) ?: return true
        val allowedRoles = authAnnotation.roles
        val userSession = getUserSession()

        if (userSession == null || !allowedRoles.contains(userSession.role)) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized")
            return false
        }

        return true
    }

    private fun getAuthAnnotation(handler: HandlerMethod) =
        handler.getMethodAnnotation(Auth::class.java)

    private fun getUserSession(): UserPrincipal? =
        httpSession.getAttribute(UserPrincipal.SESSION_NAME) as? UserPrincipal
}
