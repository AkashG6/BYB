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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import in.dbit.byb.R;

public class registration extends AppCompatActivity {
    TextView sign;
    Button sub;
    EditText name;
    EditText username;
    EditText password;
    EditText email;
    TextView who;
    RadioGroup rg;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sub = (Button) findViewById(R.id.submita);
        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pswd);
        email = (EditText) findViewById(R.id.email);
        who = (TextView) findViewById(R.id.whoareyou);
        rg = (RadioGroup) findViewById(R.id.radiog);

        sign = (TextView) findViewById(R.id.sign);
        RequestQueue queue = Volley.newRequestQueue(this);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nm, un, ps, em;
                nm = name.getText().toString();
                un = username.getText().toString();
                ps = password.getText().toString();
                em = email.getText().toString();
                int selectedId = rg.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                String rb=radioButton.getText().toString();
                if(nm!=null && un!=null && ps!=null && em!=null && selectedId!=0)
                {
                    if(rb.equals("Student")) {
                        RequestQueue queue1 = Volley.newRequestQueue(registration.this);
                        String url = "http://bybtest.000webhostapp.com/student.php";

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Toast t=Toast.makeText(getApplicationContext(),"Data Recorded",Toast.LENGTH_SHORT);
                                        t.show();

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast= Toast.makeText(getApplicationContext(),"Unable to connect",Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }) {
                            protected Map<String,String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("nm", nm);
                                params.put("un", un);
                                params.put("ps", ps);
                                params.put("em", em);
                                return params;

                            }
                        };
                        queue1.add(stringRequest);
                        }


                }


                }


            });
        }
    }

