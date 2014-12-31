package com.rhemnet.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.rhemnet.R;
import com.rhemnet.util.FontUtils;
import com.rhemnet.util.HttpUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFont();
        initLoginButton();
        initRegisterButton();
    }

    private void initRegisterButton() {
        findViewById(R.id.layout_no_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegistrationActivity();
            }
        });
    }

    private void initFont() {
        TextView textView = (TextView) findViewById(R.id.edit_username);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.edit_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_forgot_password);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);

        textView = (TextView) findViewById(R.id.text_no_account);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_no_account);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, false);

        textView = (TextView) findViewById(R.id.text_create_account);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        FontUtils.applyFont(this, textView, FontUtils.HELVETICA_NORMAL, true);
    }

    private void showRegistrationActivity() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void initLoginButton() {
        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHomeActivity();
                finish();
            }
        });
    }

    private void showHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
