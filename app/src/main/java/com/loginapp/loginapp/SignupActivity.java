package com.loginapp.loginapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loginapp.loginapp.db.LoginDatasource;
import com.loginapp.loginapp.model.Registration;

public class SignupActivity extends AppCompatActivity {

    LoginDatasource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        datasource = new LoginDatasource(this);
        datasource.open();

        final Button submit = (Button) findViewById(R.id.submit);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText mobile = (EditText) findViewById(R.id.mobile);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = email.getText().toString();
                String passwd = password.getText().toString();
                String mobNum = mobile.getText().toString();

                boolean isValid = true;

                if( emailId == null || emailId.isEmpty()){
                    isValid = false;
                    Toast.makeText(SignupActivity.this," Enter email ID to proceed",Toast.LENGTH_LONG).show();
                }
                if( passwd == null || passwd.isEmpty()){
                    isValid = false;
                    Toast.makeText(SignupActivity.this," Enter email ID to proceed",Toast.LENGTH_LONG).show();
                }
                if( mobNum == null || mobNum.isEmpty()){
                    isValid = false;
                    Toast.makeText(SignupActivity.this," Enter email ID to proceed",Toast.LENGTH_LONG).show();
                }


                if(isValid){
                    Registration registration = new Registration();
                    registration.setEmail(emailId);
                    registration.setPassword(passwd);
                    registration.setMobile(mobNum);

                    registration = datasource.create(registration);
                    if(registration.getRegId()!= -1){
                        Toast.makeText(SignupActivity.this,"Registration Successful !",Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                        mobile.setText("");
                    }else{
                        Toast.makeText(SignupActivity.this,"There was an error during Signup !",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


}
