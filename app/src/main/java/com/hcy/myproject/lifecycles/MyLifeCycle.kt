package com.hcy.myproject.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 *@创建人：hcy
 *@创建时间：2019-12-10
 *@作用描述：Function  生命周期管理
 *@email:384317693@qq.com
 **/
class MyLifeCycle : LifecycleObserver {
    private val TAG = "MyLifeCycle>>>"
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(TAG, "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG, "onDestroy")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {

        Log.d(TAG, "onAny")
    }

    fun getCurrentLife() {

    }
}