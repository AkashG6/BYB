package in.dbit.byb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class descriptionpage extends AppCompatActivity {

    Button testap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptionpage);
        testap = (Button) findViewById(R.id.testapt)

    }
}
