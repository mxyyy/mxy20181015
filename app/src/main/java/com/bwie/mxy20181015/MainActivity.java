package com.bwie.mxy20181015;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.mxy20181015.bean.LoginBean;
import com.bwie.mxy20181015.presenter.LoginPresenter;
import com.bwie.mxy20181015.view.IView;

public class MainActivity extends AppCompatActivity implements IView<LoginBean>, View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
        
        setListener();
    }

    private void setListener() {
        btnLogin.setOnClickListener(this);
    }

    private void initData() {
        presenter = new LoginPresenter();
        presenter.attach(this);
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void success(LoginBean loginBean) {
        if (loginBean !=null){
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            }
        }



    @Override
    public void failed(Exception e) {
        Toast.makeText(this,"网络异常"+e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                presenter.login("https://www.zhaoapi.cn/user/login",username,password);
                break;
        }
    }
}
