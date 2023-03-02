package com.waterfogsw.timedeal.common.annotation

import com.waterfogsw.timedeal.user.domain.User

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Auth(val roles: Array<User.Role>)
