package com.hcy.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hcy.myproject.databinding.ActivityMainBinding
import com.hcy.myproject.testViewModel.MyViewModel
//import com.hcy.utilslib.app_utils.AppUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val uiContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = DataBindingUtil.setContentView<ActivityMainBinding>(
            this@MainActivity,
            R.layout.activity_main
        )
        // bind.tv.text = "hhhh"
        val viewModel = ViewModelProviders.of(this@MainActivity).get(MyViewModel::class.java)
        bind.model = viewModel
        bind.lifecycleOwner = this //相当于数据监听
        //添加观察
//        viewModel.getNum().observe(this, Observer<Int> {
//
//        })


        // bind.model = viewModel
        //viewModel.addNums(1)
        // bind.model = viewModel

        //setContentView(R.layout.activity_main)
//        val string = resources.getString(R.string.product_name)
        GlobalScope.launch(Dispatchers.Main) {
            // tv.text =
            withContext(Dispatchers.Main) {
                for (x in 1..20) {
                    viewModel.addNums(1)
                    delay(1000)
                }
            }


//            repeat(14) {
//                viewModel.num++
//                //delay(20000)
//            }
            //getAppPackName()
        }
//
//        val c = CoroutineScope(Dispatchers.Main)
//        c.launch(Dispatchers.Main) {
//
//        }

        // Log.i("测试>>>>", "hcy29000==${AppUtils.getInstance().getPackageName(this@MainActivity)}")
    }

//    private suspend fun getAppPackName(): String {
//        return withContext(Dispatchers.IO) {
//            tv.text = getAppPackName()
//            //AppUtils.getInstance().getPackageName(this@MainActivity)
//        }
//    }
}
