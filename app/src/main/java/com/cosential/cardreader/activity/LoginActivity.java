package com.cosential.cardreader.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.cosential.cardreader.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    ImageButton btnRemember;

    Boolean bRemember = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRemember = (ImageButton) findViewById(R.id.checkBox);
        btnRemember.setOnClickListener(this);

        Button btnLogin = (Button) findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:

                break;
            case R.id.checkBox:
                updateRememberStatus();
                break;
        }
    }

    ////////////////////////////////

    public void updateRememberStatus() {
        bRemember = !bRemember;
        if (bRemember) {
            btnRemember.setImageResource(R.drawable.ic_check_on);
        }
        else {
            btnRemember.setImageResource(R.drawable.ic_check_off);
        }
    }

    ////////////////////////////////
}
