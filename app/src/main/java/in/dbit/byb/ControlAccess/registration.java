package in.dbit.byb.ControlAccess;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import in.dbit.byb.R;
public class registration extends AppCompatActivity {
    TextView sign;
    Button sub;
    EditText name;
    EditText username;
    EditText password;
    EditText email;
    TextView who;
    RadioButton std;
    RadioButton fac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sub=(Button)findViewById(R.id.submita);
        name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.pswd);
        email=(EditText)findViewById(R.id.email);
        who=(TextView) findViewById(R.id.whoareyou);
        fac=(RadioButton)findViewById(R.id.faculty);
        std=(RadioButton)findViewById(R.id.student);
        sign=(TextView)findViewById(R.id.sign);

}
}
