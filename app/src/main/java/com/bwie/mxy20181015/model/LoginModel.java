package com.bwie.mxy20181015.model;

import com.bwie.mxy20181015.ICallBack;
import com.bwie.mxy20181015.utils.HttpUtils;

import java.lang.reflect.Type;

public class LoginModel {
    public void login(String url, ICallBack callBack,Type type){
        HttpUtils.getInstance().get(url,callBack,type);

    }
}
