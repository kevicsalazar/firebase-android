package com.kevicsalazar.firebaseclean.domain.usecases

import com.kevicsalazar.firebaseclean.domain.model.User
import com.kevicsalazar.firebaseclean.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Singleton
class RegisterUserUseCase @Inject constructor(val rep: UserRepository) {

    fun observable(email: String, password: String) : Single<User> = rep.register(email, password)

}