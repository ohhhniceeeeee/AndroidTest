package com.example.jetpacktest

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner


class MyObserver(val lifecycle: Lifecycle) : DefaultLifecycleObserver {
    private val MyObserverTag = "MyObserver"

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(MyObserverTag, "ActivityCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(MyObserverTag, "ActivityStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(MyObserverTag, "ActivityStop")
    }


}