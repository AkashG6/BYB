package in.dbit.byb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileHome extends AppCompatActivity {

    LocalDB db;
    Button viewdb;
    TextView qid, quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_home);

        db = new LocalDB(this);
        viewdb = (Button) findViewById(R.id.viewdb);
        qid = (TextView) findViewById(R.id.qid);
        quest = (TextView) findViewById(R.id.quest);

        viewdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor result = db.getData();
                result.moveToFirst();

                String id = result.getString(0);
                String question = result.getString(1);

                qid.setText("ID:"+id);
                quest.setText("Question:"+question);
            }
        });
    }

}
