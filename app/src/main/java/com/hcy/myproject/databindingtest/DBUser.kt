package com.hcy.myproject.databindingtest

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableField

/**
 *@创建人：hcy
 *@创建时间：2019-12-09
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class DBUser {
    var tag = "hcy00000"



    var firstName = ObservableField<String>()

    val lastName = ObservableField<String>()
    val age = ObservableField<Int>()
    val money = ObservableDouble()

    fun setFirstName(value: String) {
        firstName.set(value)
    }

    fun getFirstNames(): String {
        return firstName.get() ?: ""
    }
}