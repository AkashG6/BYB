package in.dbit.byb.ControlAccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import in.dbit.byb.R;
public class loginpage extends AppCompatActivity {
    Button submit;
    Button signup;
    EditText edt1;
    EditText edt2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt1=(EditText) findViewById(R.id.editText);
        edt2=(EditText) findViewById(R.id.editText3);
        tv=(TextView) findViewById(R.id.tv);
        submit=(Button) findViewById(R.id.login);
        signup=(Button) findViewById(R.id.signup);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edt1.getText();
                edt2.getText();



            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginpage.this,registration.class);
                startActivity(intent);
            }
        });
}
}
