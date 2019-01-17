package in.dbit.byb.ControlAccess;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import in.dbit.byb.R;


public class student extends Activity {
    Button logout;
    Button edit, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        logout = (Button) findViewById(R.id.logout);
        edit = (Button) findViewById(R.id.edit);
        submit = (Button) findViewById(R.id.submit);
        TextView tv = (TextView) findViewById(R.id.welcome);
        final String str1 = getIntent().getExtras().getString("username");
        tv.setText("Welcome ," + getIntent().getExtras().getString("username"));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.clear();
                e.commit();

                startActivity(new Intent(student.this, loginpage.class));
                finish();   //finish current activity
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student.this, editpref.class);
                intent.putExtra("username", str1);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student.this, listofmentors.class);
                intent.putExtra("stud_user",getIntent().getExtras().getString("username"));
                startActivity(intent);


            }
        });
    }
}