package com.lenovo.way.designdemo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * @author way
 * @data 2017/6/21
 * @description .
 */

public class TextInputActivity extends AppCompatActivity {

    private EditText etName , etEmail , etIntro;
    private TextInputLayout tilName , tilEmail , tilIntro;
    private static final int MAX_COUNT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        initView();

        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (etName.getText().toString().trim().length() == 0) {
                        etName.setError("用户名不能为空");
                        tilName.setError("用户名不能为空");
                    } else {
                        tilName.setError(null);
                    }
                }
            }
        });

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!isValidEmail(etEmail.getText())) {
                        etEmail.setError("邮箱格式不正确");
                        tilEmail.setError("请输入正确的邮箱格式");
                    } else {
                        tilEmail.setError(null);
                    }
                }
            }
        });

        tilIntro.setCounterMaxLength(MAX_COUNT);
        etIntro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etIntro.getText().length() > MAX_COUNT) {
                    tilIntro.setError("字数不可以多于 " + MAX_COUNT);
                } else {
                    tilIntro.setError(null);
                }
            }
        });

    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        tilName = (TextInputLayout) findViewById(R.id.til_username);
        etEmail = (EditText) findViewById(R.id.et_email);
        tilEmail = (TextInputLayout) findViewById(R.id.til_email);
        etIntro = (EditText) findViewById(R.id.et_introduce);
        tilIntro = (TextInputLayout) findViewById(R.id.til_introduce);
    }

    // 判定是不是email格式
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
