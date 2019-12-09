package com.hcy.myproject.testViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *@创建人：hcy
 *@创建时间：2019-12-06
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class MyViewModel : ViewModel() {
    private var num: MutableLiveData<Int> = MutableLiveData(1)
    fun getNum(): MutableLiveData<Int> {
        return num
    }

    fun addNums(n: Int) {
        num.value = num.value?.plus(n)
    }

    fun getNums(): String {
        return "${num.value}"
    }
}