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

//    LocalDB db;
//    Button viewdb;
//    TextView qid, quest;

    EasyFlipView flipView;
    Button sdagree, dagree, dknow, agree, sagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_home);

        //db = new LocalDB(this);
//        viewdb = (Button) findViewById(R.id.viewdb);
//        qid = (TextView) findViewById(R.id.qid);
//        quest = (TextView) findViewById(R.id.quest);

//        viewdb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Cursor result = db.getData();
//                result.moveToFirst();
//
//                String id = result.getString(0);
//                String question = result.getString(1);
//
//                qid.setText("ID:"+id);
//                quest.setText("Question:"+question);
//            }
//        });

        flipView = (EasyFlipView) findViewById(R.id.flip_view);

        sdagree = (Button) findViewById(R.id.sdagree);
        dagree = (Button) findViewById(R.id.dagree);
        dknow = (Button) findViewById(R.id.dknow);
        agree = (Button) findViewById(R.id.agree);
        sagree = (Button) findViewById(R.id.sagree);

        sdagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
            }
        });

        dagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
            }
        });

        dknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
            }
        });

        sagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipView.flipTheView();
            }
        });

    }

}
