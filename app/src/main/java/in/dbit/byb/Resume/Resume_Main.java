package in.dbit.byb.Resume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import in.dbit.byb.R;

public class Resume_Main extends AppCompatActivity {
CardView btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_main);
        btn1=findViewById(R.id.createresumebtn);
        btn2 = findViewById(R.id.generateresumebtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resume_Main.this, Resume_Edit.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resume_Main.this, Resume_Generate.class);
                startActivity(intent);
            }
        });
    }

}
