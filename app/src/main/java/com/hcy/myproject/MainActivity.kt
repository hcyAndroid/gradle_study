package com.hcy.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hcy.utilslib.app_utils.AppUtils
import com.hcy.utilslib.date_utils.DateUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = AppUtils.getInstance().getPackageName(this@MainActivity)
        Log.i("测试>>>>", "hcy29000==${AppUtils.getInstance().getPackageName(this@MainActivity)}")
    }
}
