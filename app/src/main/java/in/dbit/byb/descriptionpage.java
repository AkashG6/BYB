package in.dbit.byb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class descriptionpage extends AppCompatActivity {

    Button testap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptionpage);
        testap = (Button) findViewById(R.id.testapt);



        testap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(descriptionpage.this,reasoning.class);
                startActivity(intent);
            }
        });

    }
}
