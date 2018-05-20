package in.dbit.byb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import org.w3c.dom.Text;

public class ProfileHome extends AppCompatActivity {

    private LocalDB db;
    private TextView quest1, quest2;
    private Cursor result;

    private EasyFlipView flipView;
    private Button sdagree, dagree, dknow, agree, sagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_home);

        db = new LocalDB(this);
        quest1 = (TextView) findViewById(R.id.quest1);
        quest2 = (TextView) findViewById(R.id.quest2);

        flipView = (EasyFlipView) findViewById(R.id.flip_view);

        sdagree = (Button) findViewById(R.id.sdagree);
        dagree = (Button) findViewById(R.id.dagree);
        dknow = (Button) findViewById(R.id.dknow);
        agree = (Button) findViewById(R.id.agree);
        sagree = (Button) findViewById(R.id.sagree);

        result = db.getData();
        result.moveToFirst();

        String question = result.getString(1);

        quest1.setText(question);

        sdagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
                changeQuest();
            }
        });

        dagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
                changeQuest();
            }
        });

        dknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
                changeQuest();
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
                changeQuest();
            }
        });

        sagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
                changeQuest();
            }
        });

    }

    public void changeQuest(){
        result.moveToNext();
        String question = result.getString(1);

        if(flipView.isBackSide())
            quest2.setText(question);

        else if(flipView.isFrontSide())
            quest1.setText(question);

    }

}
