package com.kevicsalazar.firebaseclean.domain.usecases

import com.kevicsalazar.firebaseclean.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class StatusUserUseCase @Inject constructor(val rep: UserRepository) {

    fun isLogged(): Observable<Boolean> = rep.isLogged()

}