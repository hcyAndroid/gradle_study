package com.hcy.utilslib

/**
 *@创建人：hcy
 *@创建时间：2019-10-09
 *@作用描述：Function  双重检查锁单例
 *@email:384317693@qq.com
 **/

class Single private constructor() {

    fun getInstance(): Single? {
        if (instance == null) {
            synchronized(Single::class.java) {
                if (instance == null) {
                    instance = Single()
                }
            }
        }
        return instance
    }

    companion object {
        @Volatile
        private var instance: Single? = null
    }
}