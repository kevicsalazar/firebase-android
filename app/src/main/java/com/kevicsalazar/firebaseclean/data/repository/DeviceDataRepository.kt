package com.kevicsalazar.firebaseclean.data.repository

import com.kevicsalazar.firebaseclean.data.mapper.DeviceMapper
import com.kevicsalazar.firebaseclean.data.repository.sources.firebase.DeviceDataSourceFirebase
import com.kevicsalazar.firebaseclean.domain.model.Device
import com.kevicsalazar.firebaseclean.domain.repository.DeviceRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class DeviceDataRepository @Inject constructor(val source: DeviceDataSourceFirebase) : DeviceRepository {

    override fun getDevices(): Observable<List<Device>> =
            source.getDevices().map { DeviceMapper.transform(it) }

    override fun searchDevice(deviceId: String): Observable<Device> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}