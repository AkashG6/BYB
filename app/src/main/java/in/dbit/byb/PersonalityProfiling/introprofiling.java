package in.dbit.byb.PersonalityProfiling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import in.dbit.byb.R;
import in.dbit.byb.Tests.descriptionpage;
import in.dbit.byb.Tests.reasoning;

public class introprofiling extends AppCompatActivity {

    Button proceedbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introprofiling);

        proceedbtn = (Button)findViewById(R.id.proceed);


        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(introprofiling.this,viewpersonality.class);
                startActivity(intent);
            }
        });
    }
}
