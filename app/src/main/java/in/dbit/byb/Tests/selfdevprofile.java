package in.dbit.byb.Tests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import in.dbit.byb.R;

public class selfdevprofile extends AppCompatActivity implements View.OnClickListener {

    CardView addcard,managecard,goalcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfdevprofile);
        addcard = (CardView) findViewById(R.id.addschedulebtn);
        managecard = (CardView) findViewById(R.id.managebtn);
        goalcard = (CardView) findViewById(R.id.goalbtn);


        //click
        addcard.setOnClickListener(this);
        managecard.setOnClickListener(this);
        goalcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.addschedulebtn: i= new Intent(this,addschedule.class);startActivity(i);break;
            case R.id.managebtn: i= new Intent(this,manageschedule.class);startActivity(i);break;
            case R.id.goalbtn: i= new Intent(this,goalEvaluation.class);startActivity(i);break;
            default:break;
        }
    }
}
