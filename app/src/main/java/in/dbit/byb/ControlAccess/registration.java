package in.dbit.byb.ControlAccess;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.Connection;

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
                String rb = radioButton.getText().toString();

                if (!nm.equals("") && !un.equals("") && !ps.equals("") && !em.equals("") && selectedId != 0) {
                    if (rb.equals("Student")) {
                        RequestQueue queue1 = Volley.newRequestQueue(registration.this);
                        String url = "http://bybtest.000webhostapp.com/student.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if(response.equals("Should not contain special characters"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Username should not contain special characters",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Values in fields must be at least 6 in length"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Values in fields must be at least 6 in length",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Invalid email format"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Incorrect email format",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Successfully Signed In"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                                            //startActivity(new Intent(getApplicationContext(), loginpage.class));
                                            Intent intent = new Intent(registration.this,loginpage.class);
                                            //putExtra("name",nm);
                                            //intent.putExtra("email",em);
                                            startActivity(intent);
                                        }
                                        else if(response.equals("Username exist"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Username exists",Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                               Toast.makeText(getApplicationContext(),"Error response",Toast.LENGTH_SHORT).show();
                            }

                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("nm", nm);
                                params.put("un", un);
                                params.put("ps", ps);
                                params.put("em", em);
                                return params;

                            }
                        };
                        queue1.add(stringRequest);


                    } else {
                        RequestQueue queue2 = Volley.newRequestQueue(registration.this);
                        String url = "http://bybtest.000webhostapp.com/faculty.php";

                        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if(response.equals("Should not contain special characters"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Username should not contain special characters.",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Values in fields must be at least 6 in length"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Values in fields must be at least 6 in length",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Invalid email format"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Invalid email format",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(response.equals("Successfully Signed In"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), loginpage.class));
                                        }
                                        else if(response.equals("Username exist"))
                                        {
                                            Toast.makeText(getApplicationContext(),"Username exists",Toast.LENGTH_SHORT).show();
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
                                params.put("nm", nm);
                                params.put("un", un);
                                params.put("ps", ps);
                                params.put("em", em);
                                return params;

                            }
                        };
                        queue2.add(stringRequest1);

                    }


                } else if (nm.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                } else if (un.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show();

                }
                else if(ps.isEmpty())
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                else if(em.isEmpty())
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                else if(selectedId == 0)
                    Toast.makeText(getApplicationContext(), "Please Select either faculty or student", Toast.LENGTH_SHORT).show();
                else if(nm.equals("")&&un.equals("")&&ps.equals("") && em.equals(""))
                    Toast.makeText(getApplicationContext(), "Incomplete credentials", Toast.LENGTH_SHORT).show();

            }

            ;
        });
    }
}