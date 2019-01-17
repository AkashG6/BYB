package in.dbit.byb.ControlAccess;

import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String PREFS_NAME = "LoginPrefs";

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
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);


        you=(TextView)findViewById(R.id.youare);
        RequestQueue queue = Volley.newRequestQueue(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = edt1.getText().toString();
                str2 = edt2.getText().toString();
                int selectId = rg.getCheckedRadioButtonId();
                r = (RadioButton) findViewById(selectId);
                final String rbutton = r.getText().toString();
                if (str1 != null && str2 != null) {
                    if (rbutton.equals("Student")) {
                        RequestQueue queue1 = Volley.newRequestQueue(loginpage.this);
                        String url = "http://bybtest.000webhostapp.com/login.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response.equals("Login")) {
                                            Toast.makeText(getApplicationContext(), "Logged In Successfully", Toast.LENGTH_SHORT).show();
                                            Intent intent= new Intent(loginpage.this,student.class);
                                            intent.putExtra("username",str1);
                                            startActivity(intent);
                                        } else if (response.equals("invalid")) {
                                            Toast.makeText(getApplicationContext(), "Invalid Login!!Please try again!!", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Error response", Toast.LENGTH_SHORT).show();
                            }

                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("str1", str1);
                                params.put("str2", str2);
                                return params;

                            }
                        };
                        queue1.add(stringRequest);


                    } else if(rbutton.equals("Faculty")) {
                        RequestQueue queue2 = Volley.newRequestQueue(loginpage.this);
                        String url = "http://bybtest.000webhostapp.com/loginfaculty.php";

                        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response.equals("Login")) {
                                            Toast.makeText(getApplicationContext(), "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                            Intent intent= new Intent(loginpage.this,faculty.class);
                                            intent.putExtra("username",edt1.getText().toString());
                                            startActivity(intent);
                                        } else if (response.equals("invalid")) {
                                            Toast.makeText(getApplicationContext(), "Invalid Login!!Please try again", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Error Response", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("str1", str1);
                                params.put("str2", str2);

                                return params;

                            }
                        };
                        queue2.add(stringRequest1);

                    }

                }


            }
        });
                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(loginpage.this, registration.class);
                        startActivity(intent);
                    }
                });
    }

}











