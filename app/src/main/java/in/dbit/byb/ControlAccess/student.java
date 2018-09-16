package in.dbit.byb.ControlAccess;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import in.dbit.byb.R;

public class student extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        t = (TextView) findViewById(R.id.textView6);
        t.setText("WELCOME!! YOU ARE LOGGED IN AS STUDENT");

    }
}
