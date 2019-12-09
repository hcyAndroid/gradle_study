package com.hcy.myproject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @创建人：hcy
 * @创建时间：2019-12-06
 * @作用描述：Function
 * @email:384317693@qq.com
 **/
public class Things extends BaseObservable {
    @Bindable
    public String name;

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }
}
