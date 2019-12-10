package com.hcy.myproject.databindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import com.hcy.myproject.R
import com.hcy.myproject.databinding.MyDDD
import com.hcy.myproject.lifecycles.MyLifeCycle
import com.hcy.myproject.testViewModel.MyHandler

class DataBindingTestActivity : AppCompatActivity() {
    val address = ObservableArrayList<DBUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityDataBindingTestBinding.inflate(
//            layoutInflater,
//            parent,false
//        )
        val binding = DataBindingUtil.setContentView<MyDDD>(
            this@DataBindingTestActivity,
            R.layout.activity_data_binding_test
        )


        binding.textid = R.string.product_name

        val user = DBUser()
        user.firstName.set("dddds")
        address.add(user)
        //user.setFirstName("hcy20000")
        //binding.imageId=resources.getDrawable(R.mipmap.ic_launcher)
        binding.imgsid = R.mipmap.info_icon_sex
        binding.userList = address
        binding.list = arrayListOf("hcy2020!!", "dddd")
        binding.index = 0
        binding.colorChange = true
        binding.handler = MyHandler(this@DataBindingTestActivity)
        //添加生命周期管理
        lifecycle.addObserver(MyLifeCycle())
        Log.d("当前声明周期",lifecycle.currentState.name)
    }
}
