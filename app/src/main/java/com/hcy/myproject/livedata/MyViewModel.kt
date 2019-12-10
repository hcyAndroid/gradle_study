package com.hcy.myproject.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *@创建人：hcy
 *@创建时间：2019-12-10
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class MyViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}