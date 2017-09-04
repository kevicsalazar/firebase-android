package com.kevicsalazar.firebaseclean.data.mapper


import com.google.firebase.database.DataSnapshot
import com.kevicsalazar.firebaseclean.domain.model.Device

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object DeviceMapper {

    fun transform(dataSnapshot: DataSnapshot): List<Device> {
        return dataSnapshot.children
                .mapNotNull { it.getValue(Device::class.java) }
    }

}