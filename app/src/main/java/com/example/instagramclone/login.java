package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class login extends AppCompatActivity {

    private EditText medtloginemail,medtloginpassword;
    private Button mbtnlogin1,mbtnsignup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        mbtnlogin1=findViewById(R.id.btnlogin1);
        mbtnsignup1=findViewById(R.id.btnsignup1);
        medtloginemail=findViewById(R.id.edtloginemail);
        medtloginpassword=findViewById(R.id.edtloginpassword);
        if(ParseUser.getCurrentUser()!=null)
        {
            ParseUser.getCurrentUser().logOut();
        }

        mbtnlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(medtloginemail.getText().toString(),
                        medtloginpassword.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(e==null)
                                {
                                    Toast.makeText(login.this," login is successfully",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(login.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
            });
        }
    });
        mbtnsignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,Signup.class);
                startActivity(intent);
            }
        });
}


}
