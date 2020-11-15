package ht.koute.android.utils

open class Event<out T>(private val data: T) {

    var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            peekContent()
        }
    }

    private fun peekContent() = data

}