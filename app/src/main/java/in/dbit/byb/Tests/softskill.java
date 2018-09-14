package in.dbit.byb.Tests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import in.dbit.byb.R;

public class softskill extends AppCompatActivity implements View.OnClickListener {

    CardView communicatecard,leadershipcard,timemanagecard,stressmanagecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softskill);

        communicatecard = (CardView) findViewById(R.id.commmunicatebtn);
        leadershipcard = (CardView) findViewById(R.id.leaderbtn);
        timemanagecard = (CardView) findViewById(R.id.timebtn);
        stressmanagecard = (CardView) findViewById(R.id.stressbtn);


        //Add on click to the card of softskills
        communicatecard.setOnClickListener(this);
        leadershipcard.setOnClickListener(this);
        timemanagecard.setOnClickListener(this);
        stressmanagecard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.commmunicatebtn: i = new Intent(this,communication.class);startActivity(i); break;
            case R.id.leaderbtn: i = new Intent(this,leadership.class);startActivity(i); break;
            case R.id.timebtn: i = new Intent(this,timemanagement.class);startActivity(i); break;
            case R.id.stressbtn: i = new Intent(this,stressmanagement.class);startActivity(i); break;
            default:break;
        }
    }
}
