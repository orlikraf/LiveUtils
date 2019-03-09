# LiveUtils
Library with helpful LiveData.
Based on Androidx artifacts.
Writen in Kotlin.

## Gradle Dependency (jitpack.io)

project level _build.gradle_
```Gradle
allprojects {
    repositories {
        ...
	maven { url 'https://jitpack.io' }
    }
}
```

app _build.gradle_
```Gradle
dependencies {
    implementation 'com.github.rSquared-software:live-utils:x.x.x'
}
```

[![](https://jitpack.io/v/rSquared-software/live-utils.svg)](https://jitpack.io/#rSquared-software/live-utils)

## What's inside?

* LiveEvent - This is just SingleLiveEvent from one of google samples renamed 
* PresetLiveData - Simple LiveData that only have one value passed on it's creation.
* ObserverAwareLiveData - Exposes  a LiveData _hasObservers_ that just notifies when this LiveData is observered by anything or not.
* ObserverAwareMediatorLiveData - Same as above but extends MediatorLiveData. 
