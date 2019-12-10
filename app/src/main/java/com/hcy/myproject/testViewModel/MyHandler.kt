package com.hcy.myproject.testViewModel

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.hcy.myproject.databindingtest.DBUser

/**
 *@创建人：hcy
 *@创建时间：2019-12-09
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class MyHandler(var context: Context) {
    fun onClickTest(view: View) {
        Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show()
        //Log.i("dataBinding====",)
    }

    //注册了点击事件并且可以回调一些参数过来
    fun buttonClick(view:View,index: Int, list: List<String>,users:List<DBUser>) {
       // users[index].setFirstName("我改了")
        users[index].firstName.set("jcu")
        Toast.makeText(context, "点击了${users[index].firstName.get()}", Toast.LENGTH_SHORT).show()
    }
}