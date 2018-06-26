package in.dbit.byb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Switch;

public class apptitude extends AppCompatActivity implements View.OnClickListener {

    CardView reasoningcard,quantcard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apptitude);
        reasoningcard = (CardView) findViewById(R.id.reasoningbtn);
        quantcard = (CardView) findViewById(R.id.quantitativebtn);



        //click

        reasoningcard.setOnClickListener(this);
        quantcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.reasoningbtn: i = new Intent(this,descriptionpage.class);startActivity(i); break;
            case R.id.quantitativebtn: i = new Intent(this,quantitative.class);startActivity(i); break;
            default:break;

        }
    }
}
