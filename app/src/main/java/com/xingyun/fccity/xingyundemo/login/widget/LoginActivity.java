package com.xingyun.fccity.xingyundemo.login.widget;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xingyun.fccity.xingyundemo.R;
import com.xingyun.fccity.xingyundemo.utils.SharedPreferencesUtil;
import com.xingyun.fccity.xingyundemo.view.MyClearEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fccity on 16/7/12.
 */

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.quicklogin_user_edittext)
    MyClearEditText quickloginUserEdittext;
    @Bind(R.id.quicklogin_message_edittext)
    MyClearEditText quickloginMessageEdittext;
    @Bind(R.id.quicklogin_message_btn)
    TextView quickloginMessageBtn;
    @Bind(R.id.quicklogin_btn)
    TextView quickloginBtn;
    @Bind(R.id.login_back_iv)
    ImageView loginBackIv;

    private TextWatcher loginTextWatcher;
    private TimeCount time;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        time = new TimeCount(10000, 1000);
        loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (quickloginUserEdittext.getText().toString().length() < 11 || TextUtils.isEmpty(quickloginMessageEdittext.getText().toString()))
                    quickloginBtn.setEnabled(false);
                else
                    quickloginBtn.setEnabled(true);

                if (quickloginUserEdittext.getText().toString().length() < 11) {
                    quickloginMessageBtn.setEnabled(false);
                } else {
                    quickloginMessageBtn.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        quickloginUserEdittext.addTextChangedListener(loginTextWatcher);
        quickloginMessageEdittext.addTextChangedListener(loginTextWatcher);
    }

    @OnClick({R.id.quicklogin_message_btn, R.id.quicklogin_btn, R.id.login_back_iv})
    public void onClick(View view) {
        phone = quickloginUserEdittext.getText().toString();
        switch (view.getId()) {
            case R.id.quicklogin_message_btn:
                if (!isMobileNUM(phone)) {
                    Toast.makeText(LoginActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                } else {
                    time.start();
                }
                break;
            case R.id.quicklogin_btn:
                if (!isMobileNUM(phone)) {
                    Toast.makeText(LoginActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferencesUtil.saveData(LoginActivity.this, "isLogin", true);
                    finish();
                }
                break;
            case R.id.login_back_iv:
                finish();
                break;
        }
    }

    /**
     * 验证码发送计时器
     */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            quickloginMessageBtn.setText("发送验证码");
            quickloginMessageBtn.setClickable(true);
            quickloginMessageBtn.setEnabled(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            quickloginMessageBtn.setClickable(false);
            quickloginMessageBtn.setText(millisUntilFinished / 1000 + "秒");
        }
    }

    /**
     * 是否是合法的手机号
     *
     * @return
     */
    public static boolean isMobileNUM(String mobiles) {
        Pattern p = Pattern.compile("^((17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
