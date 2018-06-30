package in.dbit.byb.PersonalityProfiling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.dbit.byb.R;

public class viewpersonality extends AppCompatActivity {

    private Button big5test, hollandtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpersonality);

        big5test = (Button)findViewById(R.id.bigbtn);
        hollandtest = (Button) findViewById(R.id.hollandbtn);



        big5test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewpersonality.this,Big5.class);
                startActivity(intent);
            }
        });

        hollandtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewpersonality.this,Holland.class);
                startActivity(intent);
            }
        });
    }
}
