package in.dbit.byb.PersonalityProfiling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.dbit.byb.MainActivity;
import in.dbit.byb.R;

public class ProfileHome extends AppCompatActivity {

    private Button big5,holland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_home);

        big5 = (Button) findViewById(R.id.big5);
        holland = (Button) findViewById(R.id.holland);

        big5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileHome.this,Big5.class);
                startActivity(intent);
            }
        });

        holland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileHome.this,Holland.class);
                startActivity(intent);
            }
        });
    }
}
