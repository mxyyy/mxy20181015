package com.bwie.mxy20181015.presenter;

import com.bwie.mxy20181015.ICallBack;
import com.bwie.mxy20181015.bean.LoginBean;
import com.bwie.mxy20181015.model.LoginModel;
import com.bwie.mxy20181015.view.IView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class LoginPresenter {

    private IView iv;
    private LoginModel loginModel;
    public void attach(IView iv){
        this.iv=iv;
        loginModel = new LoginModel();
    }

    public void login(String url,String username, String password){
        url = url.concat("?mobile=").concat(username).concat("&").concat("password=").concat(password);
        Type type = new TypeToken<LoginBean>(){}.getType();
       loginModel.login(url, new ICallBack() {
           @Override
           public void onSuccess(Object obj) {
               iv.success(obj);

           }
           @Override
           public void onFailed(Exception e) {
               iv.failed(e);
           }
       },type);
    }
}
