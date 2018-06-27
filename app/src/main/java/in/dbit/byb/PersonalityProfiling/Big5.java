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

    private int[] score = new int[50];
    private int count = 0;

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
                score[count] = 1;
                flipView.flipTheView();
                changeQuest();
            }
        });

        dagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score[count] = 2;
                flipView.flipTheView();
                changeQuest();
            }
        });

        dknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score[count] = 3;
                flipView.flipTheView();
                changeQuest();
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score[count] = 4;
                flipView.flipTheView();
                changeQuest();
            }
        });

        sagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score[count] = 5;
                flipView.flipTheView();
                changeQuest();
            }
        });

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
        int O,C,E,A,N;

        E = 20 + score[0]-score[5]+score[10]-score[15]+score[20]-score[25]+score[30]-score[35]+score[40]-score[45];
        A = 14 - score[1]-score[6]+score[11]-score[16]+score[21]-score[26]+score[31]-score[36]+score[41]-score[46];
        C = 14 + score[2]-score[7]+score[12]-score[17]+score[22]-score[27]+score[32]-score[37]+score[42]-score[47];
        N = 38 - score[3]-score[8]+score[13]-score[18]+score[23]-score[28]+score[33]-score[38]+score[43]-score[48];
        O = 8 + score[4]-score[9]+score[14]-score[19]+score[24]-score[29]+score[34]-score[39]+score[44]-score[49];

        if(flipView.isBackSide())
            quest2.setText("O="+O+",C="+C+",E="+E+",A="+A+",N="+N);

        else if(flipView.isFrontSide())
            quest1.setText("O="+O+",C="+C+",E="+E+",A="+A+",N="+N);

    }

}