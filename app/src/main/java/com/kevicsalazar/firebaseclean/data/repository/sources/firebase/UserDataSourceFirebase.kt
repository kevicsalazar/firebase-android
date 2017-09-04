package com.kevicsalazar.firebaseclean.data.repository.sources.firebase


import com.androidhuman.rxfirebase2.auth.rxCreateUserWithEmailAndPassword
import com.androidhuman.rxfirebase2.auth.rxSignInWithEmailAndPassword
import com.androidhuman.rxfirebase2.database.rxSetValue
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Single
import io.reactivex.Observable
import io.reactivex.Completable


/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class UserDataSourceFirebase @Inject constructor(val firebaseAuth: FirebaseAuth, val firebaseDatabase: FirebaseDatabase) {

    /**
     * Allows to register a user
     *
     * @param email
     * @param password
     */
    fun register(email: String, password: String): Single<FirebaseUser> =
            firebaseAuth.rxCreateUserWithEmailAndPassword(email, password)

    /**
     * Allows to login a user
     *
     * @param email
     * @param password
     */
    fun login(email: String, password: String): Single<FirebaseUser> =
            firebaseAuth.rxSignInWithEmailAndPassword(email, password)

    /**
     * Allows to know if the current user already exists or not
     *
     * @return
     */
    fun isLogged(): Observable<Boolean> =
            Observable.defer { Observable.just(firebaseAuth.currentUser != null) }

    /**
     * Allows to logout the current user
     *
     * @return
     */
    fun logout(): Observable<Void> =
            Observable.defer {
                firebaseAuth.signOut()
                Observable.just(null)
            }

    /**
     * Allows to write a user in the database
     *
     * @param uid
     * @param name
     */
    fun writeUser(uid: String, name: String): Completable {
        val ref = firebaseDatabase.reference
                .child("users")
                .child(uid)
        return ref.rxSetValue(name)
    }

}