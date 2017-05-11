package com.prolink.loundry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Lenovo on 28-May-16.
 */
public class ForgotPasswordActivity extends AppCompatActivity {
    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        tvBack=(TextView)findViewById(R.id.btnBack);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intentLogin);
            }
        });
    }
}
