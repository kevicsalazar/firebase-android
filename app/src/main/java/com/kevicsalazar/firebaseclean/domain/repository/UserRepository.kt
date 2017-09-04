package com.kevicsalazar.firebaseclean.domain.repository

import com.kevicsalazar.firebaseclean.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface UserRepository {

    fun register(email: String, password: String) : Single<User>

    fun login(email: String, password: String) : Single<User>

    fun isLogged(): Observable<Boolean>

    fun logout(): Observable<Void>

    fun writeUser(uid: String, name: String): Completable

}