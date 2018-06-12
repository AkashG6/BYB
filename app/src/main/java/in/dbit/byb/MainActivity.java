package in.dbit.byb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.dbit.byb.PersonalityProfiling.ProfileHome;

public class MainActivity extends AppCompatActivity {

    Button profile_btn;
    Button test_btn;
    Button resume_btn;
    Button access_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile_btn = (Button) findViewById(R.id.profile_btn);
        test_btn = (Button) findViewById(R.id.test_btn);
        resume_btn = (Button) findViewById(R.id.resume_btn);
        access_btn = (Button) findViewById(R.id.access_btn);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileHome.class);
                startActivity(intent);
            }
        });

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,testmainpage.class);
                startActivity(intent);
            }
        });

        resume_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        access_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
