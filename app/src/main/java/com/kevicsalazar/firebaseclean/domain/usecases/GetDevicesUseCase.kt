package com.kevicsalazar.firebaseclean.domain.usecases

import com.kevicsalazar.firebaseclean.domain.model.Device
import com.kevicsalazar.firebaseclean.domain.repository.DeviceRepository
import com.kevicsalazar.firebaseclean.domain.repository.UserRepository
import io.reactivex.Observable
import org.jetbrains.anko.AnkoException
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class GetDevicesUseCase @Inject constructor(val rep: DeviceRepository) {

    fun observable(): Observable<List<Device>> = rep.getDevices()

}