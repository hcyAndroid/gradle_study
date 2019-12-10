package com.hcy.myproject.databindingtest

import android.widget.ImageView
import androidx.databinding.BindingAdapter


/**
 * @创建人：hcy
 * @创建时间：2019-12-09
 * @作用描述：Function
 * @email:384317693@qq.com
 */
class MyBindAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["xxx:image","xxx:placeholder", "xxx:error"], requireAll = false)
        fun bindImage(view: ImageView, resId: Int,resId2: Int,resId3: Int) {
            view.setImageResource(resId)
        }
    }
}
//object MyBindAdapter {
//    @JvmStatic
//    @BindingAdapter("app:image")
//    fun bindImage(view: ImageView, resId: Int) {
//        view.setImageResource(resId)
//    }
//}

