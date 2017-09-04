package com.kevicsalazar.firebaseclean.data

import com.kevicsalazar.firebaseclean.data.repository.*
import com.kevicsalazar.firebaseclean.data.repository.sources.FirebaseModule
import com.kevicsalazar.firebaseclean.domain.repository.*
import dagger.Binds
import dagger.Module

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(includes = arrayOf(FirebaseModule::class))
abstract class DataModule {

    @Binds abstract fun bindUserRepository(repository: UserDataRepository): UserRepository

    @Binds abstract fun bindDeviceRepository(repository: DeviceDataRepository): DeviceRepository

}