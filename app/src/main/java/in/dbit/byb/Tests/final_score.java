package in.dbit.byb.Tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import in.dbit.byb.R;

public class final_score extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        txt = (TextView) findViewById(R.id.fscr);

        Bundle bundle = getIntent().getExtras();
        Integer stuff = bundle.getInt("stuff");

        txt.setText("Final Score: " +stuff);
    }
}
