package com.hcy.utilslib.base

import android.app.Application

/**
 *@创建人：hcy
 *@创建时间：2019-11-25
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {

    }
}