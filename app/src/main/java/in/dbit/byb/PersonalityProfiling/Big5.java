package in.dbit.byb.PersonalityProfiling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.wajahatkarim3.easyflipview.EasyFlipView;
import in.dbit.byb.R;

public class Big5 extends AppCompatActivity {

    private TextView quest1, quest2;
    private EasyFlipView flipView;
    private Button sdagree, dagree, dknow, agree, sagree;

    private int count = 0;
    private int O,C,E,A,N,mul=-1;

    private Big5Quest question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big5);

        quest1 = (TextView) findViewById(R.id.quest1);
        quest2 = (TextView) findViewById(R.id.quest2);
        flipView = (EasyFlipView) findViewById(R.id.flip_view);
        sdagree = (Button) findViewById(R.id.sdagree);
        dagree = (Button) findViewById(R.id.dagree);
        dknow = (Button) findViewById(R.id.dknow);
        agree = (Button) findViewById(R.id.agree);
        sagree = (Button) findViewById(R.id.sagree);

        question = new Big5Quest();

        quest1.setText(question.big5Quest[count]);

        sdagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(1);
                flipView.flipTheView();
                changeQuest();
            }
        });

        dagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(2);
                flipView.flipTheView();
                changeQuest();
            }
        });

        dknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(3);
                flipView.flipTheView();
                changeQuest();
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(4);
                flipView.flipTheView();
                changeQuest();
            }
        });

        sagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeScore(5);
                flipView.flipTheView();
                changeQuest();
            }
        });

    }

    public void storeScore(int ans){
        if(mul==1)
            mul=-1;
        else
            mul=1;

        if(count%5==0)
            E+=ans*mul;

        else if(count%5==1)
            A+=ans*mul;

        else if(count%5==2)
            C+=ans*mul;

        else if(count%5==3)
            N+=ans*mul;

        else
            O+=ans*mul;
    }

    public void changeQuest(){
        count++;

        if(count<50){
            if(flipView.isBackSide())
                quest2.setText(question.big5Quest[count]);

            else if(flipView.isFrontSide())
                quest1.setText(question.big5Quest[count]);
        }

        else{
            calculateResult();
        }

    }

    public  void calculateResult(){

        E = 20 + E;
        A = 14 - A;
        C = 14 + C;
        N = 38 - N;
        O = 8 + O;

        if(flipView.isBackSide())
            quest2.setText("O="+O+",C="+C+",E="+E+",A="+A+",N="+N);

        else if(flipView.isFrontSide())
            quest1.setText("O="+O+",C="+C+",E="+E+",A="+A+",N="+N);
    }

}