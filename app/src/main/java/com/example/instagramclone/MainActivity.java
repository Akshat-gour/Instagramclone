package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.textView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery =ParseQuery.getQuery("Boxer");
                parseQuery.getInBackground("wsdjoZFzoL", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if(object!=null && e==null)
                        {
                            mTextView.setText(object.get("punch_speed")+"");
                        }
                    }
                });
            }
        });

    }
//    public void helloworldtapped(View view){
//        ParseObject boxer =new ParseObject("Boxer");
//        boxer.put("punch_speed",200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e==null)
//                {
//                    Toast.makeText(MainActivity.this
//                            ,"Method is called",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
    public void helloworldtapped(View view)
    {
        ParseObject kickboxing = new ParseObject("Kickboxing");
        kickboxing.put("kickpower",150);
        kickboxing.put("kickspeed",200);
        kickboxing.put("punchspeed",250);
        kickboxing.put("punchpower",300);
        kickboxing.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    Toast.makeText(MainActivity.this,"Method is called",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
