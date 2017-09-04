package com.kevicsalazar.firebaseclean.data.repository.sources.firebase


import com.androidhuman.rxfirebase2.database.dataChanges
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class DeviceDataSourceFirebase @Inject constructor(val firebaseAuth: FirebaseAuth, val firebaseDatabase: FirebaseDatabase) {

    fun getDevices(): Observable<DataSnapshot> {
        val ref = firebaseDatabase.reference
                .child("devices")
        return ref.dataChanges()
    }

}