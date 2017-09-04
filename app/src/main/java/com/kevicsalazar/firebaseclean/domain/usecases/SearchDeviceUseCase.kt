package com.kevicsalazar.firebaseclean.domain.usecases

import com.kevicsalazar.firebaseclean.domain.model.Device
import com.kevicsalazar.firebaseclean.domain.repository.DeviceRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class SearchDeviceUseCase @Inject constructor(val rep: DeviceRepository) {

    fun observable(deviceId: String): Observable<Device> = rep.searchDevice(deviceId)

}