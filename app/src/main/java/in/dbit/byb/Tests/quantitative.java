package in.dbit.byb.Tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.dbit.byb.R;

public class quantitative extends AppCompatActivity {

    TextView question;
    Button option1, option2, option3, option4, btnclear, btnconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantitative);

        question = findViewById(R.id.questext);
        option1 = findViewById(R.id.opt1);
        option2 = findViewById(R.id.opt2);
        option3 = findViewById(R.id.opt3);
        option4 = findViewById(R.id.opt4);
        btnclear = findViewById(R.id.btnclear);
        btnconfirm = findViewById(R.id.btnconfirm);
    }

    // onClick function for option buttons
    public void optionClick(View v) {

    }

    // onClick function for clear button
    public void clearClick(View v) {

    }

    // onClick function for confirm button
    public void confirmClick(View v) {

    }
}
