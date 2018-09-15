package in.dbit.byb.ControlAccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import in.dbit.byb.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class loginpage extends AppCompatActivity {
    Button submit;
    Button signup;
    EditText edt1;
    EditText edt2;
    TextView tv;
    RadioGroup rg;
    RadioButton r;
    TextView you;
    public String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt1=(EditText) findViewById(R.id.editText);
        edt2=(EditText) findViewById(R.id.editText3);
        tv=(TextView) findViewById(R.id.tv);
        submit=(Button) findViewById(R.id.login);
        signup=(Button) findViewById(R.id.signup);
        rg=(RadioGroup)findViewById(R.id.rg);

        you=(TextView)findViewById(R.id.youare);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                  str1 = edt1.getText().toString();
                  str2 = edt2.getText().toString();
                int selectId = rg.getCheckedRadioButtonId();
                r = (RadioButton) findViewById(selectId);
                String rbutton = r.getText().toString();
                if (rbutton.equals("Student")) {
                    Intent intent = new Intent(loginpage.this, dbcon.class);
                    startActivity(intent);
                } else if(rbutton.equals("Faculty")){
                    Intent intent = new Intent(loginpage.this, faculty.class);
                    startActivity(intent);
                }
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
