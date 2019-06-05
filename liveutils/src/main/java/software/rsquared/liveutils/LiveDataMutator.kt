package software.rsquared.liveutils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataMutator {
	fun <T> LiveData<T>.post(value: T?) {
		if (this is MutableLiveData<T>) {
			this.postValue(value)
		}
	}

	fun <T> LiveData<T>.set(value: T?) {
		if (this is MutableLiveData<T>) {
			this.value = value
		}
	}

	fun <T> LiveData<T>.call() {
		when (this) {
			is LiveEvent<T> -> this.call()
			is MutableLiveData<T> -> this.value = null
		}
	}

	fun <T> LiveData<T>.asMediator(): MediatorLiveData<T>? {
		return when (this) {
			is MediatorLiveData<T> -> this
			else -> null
		}
	}

	fun <T> LiveData<T>.asMutable(): MutableLiveData<T>? {
		return when (this) {
			is MutableLiveData<T> -> this
			else -> null
		}
	}

	fun <T> LiveData<T>.asEvent(): LiveEvent<T>? {
		return when (this) {
			is LiveEvent<T> -> this
			else -> null
		}
	}
}
