package com.example.trainit.data

/**
 * Trieda ktora drzi data o uspesnosti
 *
 * @param T
 * @constructor Create empty Result
 */
sealed class Result<out T : Any> {

    /**
     * Success
     *
     * @param T
     * @property data
     * @constructor Create empty Success
     */
    data class Success<out T : Any>(val data: T) : Result<T>()

    /**
     * Error
     *
     * @property exception
     * @constructor Create empty Error
     */
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}