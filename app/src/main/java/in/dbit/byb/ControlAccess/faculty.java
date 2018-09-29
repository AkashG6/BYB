package in.dbit.byb.ControlAccess;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.dbit.byb.R;


public class faculty extends Activity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        logout = (Button) findViewById(R.id.logout);
        TextView tv = (TextView) findViewById(R.id.welcome);
        tv.setText("Welcome ," + getIntent().getExtras().getString("username"));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.clear();
                e.commit();

                startActivity(new Intent(faculty.this, loginpage.class));
                finish();   //finish current activity
            }
        });

    }
}