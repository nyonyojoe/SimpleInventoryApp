
package com.kellie.inventorymanager;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    TextView login_page;
    TextInputEditText userName;
    TextInputEditText password1;
    TextInputEditText password2;
    LinearLayout signupbt;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db = new DatabaseHelper(this);
        userName =(TextInputEditText) findViewById(R.id.user_name_su);
        login_page = (TextView) findViewById(R.id.login_page);
        password1 =(TextInputEditText) findViewById(R.id.user_password_su);
        password2 =(TextInputEditText) findViewById(R.id.user_password2_su);
        signupbt = (LinearLayout) findViewById(R.id.signupbt);


        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString().trim();
                String pwd = password1.getText().toString().trim();
                String cnfpwd = password2.getText().toString().trim();

                if (pwd.equals(cnfpwd)){
                    long val = db.addUser(user,pwd);
                    if (val> 0 ){
                        Toast.makeText(SignupActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                    }

                }
                else {
                    Toast.makeText(SignupActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}