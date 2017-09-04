package com.kevicsalazar.firebaseclean.domain.repository

import com.kevicsalazar.firebaseclean.domain.model.Device
import io.reactivex.Observable

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface DeviceRepository {

    fun getDevices(): Observable<List<Device>>

    fun searchDevice(deviceId: String): Observable<Device>

}