

package com.kellie.inventorymanager;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout login;
    private TextView signUp_Page;
    TextInputEditText mtextUsername;
    TextInputEditText mtextPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mtextUsername = (TextInputEditText) findViewById(R.id.nameinput);
        mtextPassword = (TextInputEditText) findViewById(R.id.user_password_lg);
        signUp_Page = (TextView) findViewById(R.id.go_to_signup);
        login= (LinearLayout) findViewById(R.id.loginbt);
        db = new DatabaseHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mtextUsername.getText().toString().trim();
                String password = mtextPassword.getText().toString().trim();

                Boolean res = db.checkUser(user,password);
                if (res){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Username or Password doesn't exit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUp_Page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });


    }
}
