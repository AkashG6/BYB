package in.dbit.byb.ControlAccess;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class mentordetails extends AppCompatActivity {
    TextView tv, uname, femail;
    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentordetails);
        tv = (TextView) findViewById(R.id.mentordetails);
        uname = (TextView) findViewById(R.id.mentoruname);
        femail = (TextView) findViewById(R.id.mentoremail);
        tv.setText("Name: " + getIntent().getExtras().getString("name"));
        //uname.setText("Username: "+getIntent().getExtras().getString("username"));
        //femail.setText("Email: "+getIntent().getExtras().getString("email"));
        Intent intent = getIntent();
        final String[] username = intent.getStringArrayExtra("username");
        String[] email = intent.getStringArrayExtra("email");
        final int i = intent.getExtras().getInt("position");
        uname.setText("Username: " + username[i]);
        femail.setText("Email: " + email[i]);
        request = (Button) findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue1 = Volley.newRequestQueue(mentordetails.this);
                String url = "http://bybtest.000webhostapp.com/checkdefvalue.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                /*if (response.equals("hiYou cannot send request to this faculty")){
                                    request.setClickable(false);
                                    request.setText("You cannot send request to this faculty");
                                }

                                else if (response.equals("hiRequest successfully sent")) {
                                    //RequestQueue queue2=Volley.newRequestQueue(mentordetails.this);
                                    //String url2="http://bybtest.000webhostapp.com/sendrequest.php";
                                    //StringRequest stringRequest1 = new StringRequest()
                                    Toast.makeText(getApplicationContext(), "Request sent successfully", Toast.LENGTH_SHORT).show();
                                    request.setClickable(false);
                                    request.setText("You have already sent the request");
                                    */
                                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
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
                        params.put("user", username[i]);
                        params.put("stud_user",getIntent().getExtras().getString("stud_user"));
                        return params;

                    }
                };
                queue1.add(stringRequest);
            }
        });
    }
}


