package com.tje.sinbaram;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.tje.sinbaram.data.User;
import com.tje.sinbaram.util.ContextUtil;
import com.tje.sinbaram.util.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    public static LoginActivity myActivity;

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.CheckBox autoLoginCheckBox;
    private android.widget.Button loginBtn;
    private android.widget.Button signupBtn;
    private android.widget.Button nosignupLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setValues();
        setupEvents();
        myActivity = this;
    }

    @Override
    public void setupEvents() {
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupActivity.class);
                startActivity(intent);
            }
        });

        nosignupLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder gl = new AlertDialog.Builder(mContext);
                gl.setTitle("비회원 로그인");
                gl.setMessage("회원 가입시 쿠폰 발급 혜택 등을 이용하실 수 있습니다.\n비회원으로 접속하시겠습니까?");
                gl.setPositiveButton("비회원으로 로그인합니다.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                gl.setNegativeButton("취소", null);
                gl.show();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.login(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                User temp = User.getUserFromJsonObject(json.getJSONObject("user"));
                                ContextUtil.login(mContext, temp);
                                Toast.makeText(mContext, temp.getUserName()+" 님 환영합니다!", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(mContext, MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                            else {
                                Toast.makeText(mContext, "아이디 혹은 비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });


            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.nosignupLoginBtn = (Button) findViewById(R.id.nosignupLoginBtn);
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.autoLoginCheckBox = (CheckBox) findViewById(R.id.autoLoginCheckBox);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
