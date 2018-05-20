package in.dbit.byb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class jobinterview extends AppCompatActivity implements View.OnClickListener {

    CardView hrcard,gkcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobinterview);

        hrcard = (CardView) findViewById(R.id.hrbtn);
        gkcard = (CardView) findViewById(R.id.gkbtn);

        //click

        hrcard.setOnClickListener(this);
        gkcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.hrbtn: i = new Intent(this,HRInterviewquestion.class);startActivity(i);break;
            case R.id.gkbtn: i = new Intent(this,gkquestions.class); startActivity(i);break;
            default:break;
        }
    }
}
