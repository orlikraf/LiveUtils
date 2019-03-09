package software.rsquared.liveutils

import androidx.annotation.MainThread
import androidx.lifecycle.*

/**
 * @author Rafal Orlik
 */
class ObserverAwareMediatorLiveData<T> : MediatorLiveData<T>() {

	private val hasObserversLiveData = MutableLiveData<Boolean>().apply { value = false }
	val hasObservers: LiveData<Boolean> = hasObserversLiveData

	@MainThread
	override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
		super.observe(owner, observer)
		hasObserversLiveData.postValue(true)
	}

	@MainThread
	override fun observeForever(observer: Observer<in T>) {
		super.observeForever(observer)
		hasObserversLiveData.postValue(true)
	}

	@MainThread
	override fun removeObservers(owner: LifecycleOwner) {
		super.removeObservers(owner)
		hasObserversLiveData.postValue(hasObservers())
	}

	@MainThread
	override fun removeObserver(observer: Observer<in T>) {
		super.removeObserver(observer)
		hasObserversLiveData.postValue(hasObservers())
	}

}