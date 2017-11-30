package com.tje.sinbaram;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends BaseActivity {

    private android.widget.EditText userIdEdt;
    private android.widget.Button idDuplChkBtn;
    private android.widget.EditText userNameEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText pwChkEdt;
    private android.widget.EditText phoneNumEdt;
    private android.widget.Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.pwChkEdt = (EditText) findViewById(R.id.pwChkEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.userNameEdt = (EditText) findViewById(R.id.userNameEdt);
        this.idDuplChkBtn = (Button) findViewById(R.id.idDuplChkBtn);
        this.userIdEdt = (EditText) findViewById(R.id.userIdEdt);
    }
}
