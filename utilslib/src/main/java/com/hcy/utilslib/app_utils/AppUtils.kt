package com.hcy.utilslib.app_utils

import android.content.Context

/**
 *@创建人：hcy
 *@创建时间：2019-10-09
 *@作用描述：Function  双重检查锁单例
 *@email:384317693@qq.com
 **/

class AppUtils private constructor() {
    companion object {
        @Volatile
        private var instance: AppUtils? = null
        fun getInstance(): AppUtils{
            if (instance == null) {
                synchronized(AppUtils::class.java) {
                    if (instance == null) {
                        instance = AppUtils()
                    }
                }
            }
            return instance!!
        }
    }

    //获取包名
    fun getPackageName(context: Context): String {
        return context.packageManager.getPackageInfo(context.packageName, 0).packageName
    }
}