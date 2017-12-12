package com.tje.sinbaram;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tje.sinbaram.util.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends BaseActivity {

    boolean isIdDupl = false;

    private android.widget.EditText idEdt;
    private android.widget.Button idDuplChkBtn;
    private android.widget.EditText nameEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText pwChkEdt;
    private android.widget.EditText phoneEdt;
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

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        타이핑이 되는 매 순간 마다, 중복 검사를 통과 못한값으로 변경
                isIdDupl = true;
                Log.d("아이디값변경", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        idDuplChkBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                중복 여부? => 서버에다가 물어보면 돌아오는 응답으로 체크.
//
////                버튼이 눌리면, 실제로 서버에 중복 확인 요청
//                ServerUtil.check_dupl_id(mContext, idEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
//                    @Override
//                    public void onResponse(JSONObject json) {
////                        응답에 포함된 json을 분석
////                        json 내부에서, 중복 여부를 파악.
////                        파악된 중복 여부에 따라 중복확인 후처리 작업 진행
//
////                        JSON 파싱해서, isIdDupl을 상황에 맞는 값으로 세팅.
//
//
//                        try {
//                            isIdDupl = json.getBoolean("result");
//
//
//                            if (isIdDupl) {
////                    아이디가 중복된 상황.
////                    아이디가 중복되었다면,
////                    중복 확인 (제목), 이미 사용중인 아이디입니다. (메세지)
////                    확인 버튼만 있는 경고창 띄워주기.
//
//                                AlertDialog.Builder myBuilder = new AlertDialog.Builder(mContext);
//                                myBuilder.setTitle("중복 확인");
//                                myBuilder.setMessage("이미 사용중인 아이디입니다.");
//                                myBuilder.setPositiveButton("확인", null);
//                                myBuilder.show();
//
//
//                            }
//                            else {
////                    아이디가 중복되지 않는 상황.
//
////                    아이디가 중복되지 않으면,
////                    사용해도 좋은 아이디 입니다. Toast
//
//                                Toast.makeText(mContext, "사용해도 좋은 아이디입니다.", Toast.LENGTH_SHORT).show();
//
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                });
//
//
//
//            }
//        });

        idDuplChkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "사용 가능합니다.", Toast.LENGTH_SHORT).show();
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                현재 코드는 무조건 학생 목록으로 넘어감.

//                1. 중복확인을 통과 해야함

//                isIdDupl을 이 곳에서도 받아와야 한다.
//                 => isIdDupl을 멤버변수화 한다.


//                2. 입력칸 중에 빈 칸이 없어야.
//                 => 위에서부터 하나하나 검사하다가, 빈칸을 발견하면
//                    해당 칸이 비어있음을 경고창으로 알려주기.
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("가입 실패");
                builder.setPositiveButton("확인", null);

                if (idEdt.getText().toString().equals("")) {

                    builder.setMessage("아이디가 입력되지 않았습니다.");
                    builder.show();
                    return;
                }
                else if (nameEdt.getText().toString().equals("")) {
                    builder.setMessage("이름이 입력되지 않았습니다.");
                    builder.show();
                    return;
                }
                else if (pwEdt.getText().toString().equals("")) {
                    builder.setMessage("비밀번호가 입력되지 않았습니다.");
                    builder.show();
                    return;
                }
                else if (phoneEdt.getText().toString().equals("")) {
                    builder.setMessage("핸드폰 번호가 입력되지 않았습니다.");
                    builder.show();
                    return;
                }

//                3. 중복확인을 통과한 이후에, 아이디를 수정했다면 다시 중복확인을 받아야하도록.

//                setupEvents 내부에 실행

//                4. 서버에 실제로 가입 요청

                ServerUtil.sign_up(mContext, idEdt.getText().toString(),
                        pwEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        phoneEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                Toast.makeText(mContext, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });

//                5. 가입요청의 응답을 보고, 가입 승인이 났으면 로그인 처리
//                 => 프로필 사진 경로 X : tempURL 이라고 프사 경로 지정.
//                6. 로그인처리가 완료되면, 학생 목록 화면으로 이동.

            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.pwChkEdt = (EditText) findViewById(R.id.pwChkEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.idDuplChkBtn = (Button) findViewById(R.id.idDuplChkBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
