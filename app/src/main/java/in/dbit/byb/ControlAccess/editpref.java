package in.dbit.byb.ControlAccess;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class editpref extends AppCompatActivity {
    EditText hob, area;
    Button save, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpref);
        hob = (EditText) findViewById(R.id.hobby);
        area = (EditText) findViewById(R.id.area);
        save = (Button) findViewById(R.id.save);

        RequestQueue queue = Volley.newRequestQueue(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String hobb = hob.getText().toString();
                final String a = area.getText().toString();
                final String username=getIntent().getExtras().getString("username");
                RequestQueue queue1 = Volley.newRequestQueue(editpref.this);
                String url = "http://bybtest.000webhostapp.com/editpref.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("Successfully saved")) {
                                    Toast.makeText(getApplicationContext(), "Successfully saved", Toast.LENGTH_SHORT).show();
                                }
                                else if(response.equals("Error while saving"))
                                {
                                    Toast.makeText(getApplicationContext(), "Error while saving", Toast.LENGTH_SHORT).show();
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
                        params.put("hobb", hobb);
                        params.put("a", a);
                        params.put("username",username);
                        return params;

                    }
                };
                queue1.add(stringRequest);
            }
        });


            }




    }













