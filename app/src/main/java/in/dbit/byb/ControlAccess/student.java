package in.dbit.byb.ControlAccess;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.dbit.byb.R;


public class student extends Activity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        logout=(Button)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.clear();
                e.commit();

                startActivity(new Intent(student.this,loginpage.class));
                finish();   //finish current activity
            }
        });
    }
}