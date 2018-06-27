package in.dbit.byb.PersonalityProfiling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.wajahatkarim3.easyflipview.EasyFlipView;
import in.dbit.byb.R;

public class Holland extends AppCompatActivity {

    private TextView quest1, quest2;
    private EasyFlipView flipView;
    private Button dislike, sdislike, neutral, slike, like;

    private int count = 0;
    int Re,I,A,S,E,C;

    private HollandQuest question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holland);

        quest1 = (TextView) findViewById(R.id.quest1);
        quest2 = (TextView) findViewById(R.id.quest2);
        flipView = (EasyFlipView) findViewById(R.id.flip_view);
        dislike = (Button) findViewById(R.id.dislike);
        sdislike = (Button) findViewById(R.id.sdislike);
        neutral = (Button) findViewById(R.id.neutral);
        slike = (Button) findViewById(R.id.slike);
        like = (Button) findViewById(R.id.like);

        question = new HollandQuest();

        quest1.setText(question.hollandQuest[count]);

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(1);
                flipView.flipTheView();
                changeQuest();
            }
        });

        sdislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(2);
                flipView.flipTheView();
                changeQuest();
            }
        });

        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(3);
                flipView.flipTheView();
                changeQuest();
            }
        });

        slike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(4);
                flipView.flipTheView();
                changeQuest();
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(5);
                flipView.flipTheView();
                changeQuest();
            }
        });

    }

    public void storeScore(int ans){
        if(count%6==0)
            Re+=ans;

        else if(count%6==1)
            I+=ans;

        else if(count%6==2)
            A+=ans;

        else if(count%6==3)
            S+=ans;

        else if(count%6==4)
            E+=ans;

        else
            C+=ans;
    }

    public void changeQuest(){
        count++;

        if(count<48){
            if(flipView.isBackSide())
                quest2.setText(question.hollandQuest[count]);

            else if(flipView.isFrontSide())
                quest1.setText(question.hollandQuest[count]);
        }

        else{
            calculateResult();
        }

    }

    public  void calculateResult(){
        Re/= 8;
        I/= 8;
        A/= 8;
        S/= 8;
        E/= 8;
        C/= 8;

        if(flipView.isBackSide())
            quest2.setText("R="+Re+",I="+I+",A="+A+",S="+S+",E="+E+",C"+C);

        else if(flipView.isFrontSide())
            quest1.setText("R="+Re+",I="+I+",A="+A+",S="+S+",E="+E+",C"+C);
    }

}