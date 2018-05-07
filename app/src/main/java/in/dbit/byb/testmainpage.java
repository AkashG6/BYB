package in.dbit.byb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class testmainpage extends AppCompatActivity {

    Button subject_btn,apptitude_btn,soft_btn,sdp_btn,job_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmainpage);

        subject_btn = (Button) findViewById(R.id.subjectbtn);
        apptitude_btn = (Button) findViewById(R.id.aptitudebtn);
        soft_btn = (Button) findViewById(R.id.softskillbtn);
        sdp_btn = (Button) findViewById(R.id.sdpbtn);
        job_btn = (Button) findViewById(R.id.jobbtn);

        subject_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        apptitude_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        soft_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sdp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
