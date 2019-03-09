package software.rsquared.liveutils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author rSquared.software
 */
class ObserverAwareLiveData<T> : MutableLiveData<T>() {

	private val hasObserversLiveData = MutableLiveData<Boolean>().apply { value = false }
	val hasObservers: LiveData<Boolean> = hasObserversLiveData

	@MainThread
	override fun observeForever(observer: Observer<in T>) {
		super.observeForever(observer)
		hasObserversLiveData.value = true
	}

	@MainThread
	override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
		super.observe(owner, observer)
		hasObserversLiveData.value = true
	}

	@MainThread
	override fun removeObserver(observer: Observer<in T>) {
		super.removeObserver(observer)
		hasObserversLiveData.value = hasObservers()
	}

	@MainThread
	override fun removeObservers(owner: LifecycleOwner) {
		super.removeObservers(owner)
		hasObserversLiveData.value = hasObservers()
	}

}