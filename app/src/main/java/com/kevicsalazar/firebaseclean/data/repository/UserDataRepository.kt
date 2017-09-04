package com.kevicsalazar.firebaseclean.data.repository

import com.kevicsalazar.firebaseclean.data.repository.sources.firebase.UserDataSourceFirebase
import com.kevicsalazar.firebaseclean.domain.model.User
import com.kevicsalazar.firebaseclean.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class UserDataRepository @Inject constructor(val source: UserDataSourceFirebase) : UserRepository {

    override fun register(email: String, password: String): Single<User> =
            source.register(email, password)
                    .map { User(it.uid, it.displayName ?: "No name") }

    override fun login(email: String, password: String): Single<User> =
            source.login(email, password)
                    .map { User(it.uid, it.displayName ?: "No name") }

    override fun isLogged(): Observable<Boolean> = source.isLogged()

    override fun logout(): Observable<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeUser(uid: String, name: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}