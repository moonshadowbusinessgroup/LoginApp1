package com.loginapp.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loginapp.loginapp.db.LoginDatasource;

public class MainActivity extends AppCompatActivity {

    LoginDatasource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        datasource = new LoginDatasource(this);
        datasource.open();

        final EditText username = (EditText) findViewById(R.id.email);
        final EditText pwd = (EditText) findViewById(R.id.password);
        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupact = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(signupact);
            }
        });

        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loggedIn = datasource.checkLogin(username.getText().toString(),pwd.getText().toString());
                if(loggedIn) {
                    Intent loginact = new Intent(MainActivity.this, WelcomeActivity.class);
                    loginact.putExtra("user",username.getText().toString());
                    startActivity(loginact);
                }else{
                    Toast.makeText(MainActivity.this,"Invalid username or password, Please sign up !",Toast.LENGTH_LONG).show();
                    Intent signupact1 = new Intent(MainActivity.this,SignupActivity.class);
                    startActivity(signupact1);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
