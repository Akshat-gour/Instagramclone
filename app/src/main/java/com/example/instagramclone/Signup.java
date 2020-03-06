package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private EditText medtemail,medtname,medtpassword;
    private Button mbtnsignup,mbtnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("Sign Up");
        medtemail=findViewById(R.id.edtemail);
        medtname=findViewById(R.id.edtname);
        medtpassword=findViewById(R.id.edtpassword);
        medtpassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && keyCode==KeyEvent.ACTION_DOWN){
                    onClick(mbtnsignup);
                }
                return false;
            }
        });
        mbtnsignup=findViewById(R.id.btnsignup);
        mbtnlogin=findViewById(R.id.btnlogin);
        if(ParseUser.getCurrentUser()!=null)
        {
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View v) {
        switch (R.id.bottom){
            case R.id.btnsignup:
                if (medtemail.getText().toString().equals("")
                        || medtname.getText().toString().equals("") ||
                        medtpassword.getText().toString().equals("")) {
                    Toast.makeText(Signup.this, "Email,UserName,Password Required!!", Toast.LENGTH_SHORT).show();
                } else {
                    final ParseUser mUser = new ParseUser();
                    mUser.setEmail(medtemail.getText().toString());
                    mUser.setUsername(medtname.getText().toString());
                    mUser.setPassword(medtpassword.getText().toString());

                    final ProgressDialog progressDialog = new ProgressDialog(Signup.this);
                    progressDialog.setMessage("Signing Up");
                    progressDialog.show();

                    mUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(Signup.this, "is SignUp successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
                }
                break;
            case R.id.btnlogin:
                Intent mintent=new Intent(Signup.this,login.class);
                startActivity(mintent);
                break;
        }
    }

    public void gridtapped(View view){
    try {
        InputMethodManager inputMethodManager=(InputMethodManager)  getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }
}
