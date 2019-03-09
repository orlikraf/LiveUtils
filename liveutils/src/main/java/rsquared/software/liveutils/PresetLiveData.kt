package rsquared.software.liveutils

import androidx.lifecycle.LiveData

/**
 * Simplified LiveData that won't mutate. Good as an absent LiveData value
 * @author rSquared.software
 */
class PresetLiveData<T : Any?> private constructor(initValue: T? = null) : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(initValue)
    }

    companion object {
        @JvmStatic
        fun <T> create(initValue: T? = null): LiveData<T> = PresetLiveData(initValue)
    }
}