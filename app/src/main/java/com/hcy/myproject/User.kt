package com.hcy.myproject

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 *@创建人：hcy
 *@创建时间：2019-12-06
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class User : BaseObservable() {
    @Bindable
    var name: String = "hcy2019"
        set(value) {
            field = value
            notifyChange()
        }
        get() {
            println("dddd")
            return field
        }


    var age: Int = 27
}