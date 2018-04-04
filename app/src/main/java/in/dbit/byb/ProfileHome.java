package in.dbit.byb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileHome extends AppCompatActivity {

    LocalDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_home);

        db = new LocalDB(this);
    }
}
