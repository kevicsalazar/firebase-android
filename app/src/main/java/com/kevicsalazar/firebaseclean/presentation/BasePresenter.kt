package com.kevicsalazar.firebaseclean.presentation

import io.reactivex.disposables.CompositeDisposable
import java.io.IOException

/**
 * Created by Kevin Salazar
 */
abstract class BasePresenter {

    val cd = CompositeDisposable()

    /**
     * Detach View
     */
    fun detachView() {
        cd.dispose()
    }

    /**
     * Custom Message Handler
     */
    fun Throwable.message(): String {
        printStackTrace()
        return when (this) {
            is IOException     -> "No se ha podido conectar con el servidor. Comprueba tu conexión a Internet y vuelve a intentarlo."
            else               -> "Ha ocurrido un error"
        }
    }

}
