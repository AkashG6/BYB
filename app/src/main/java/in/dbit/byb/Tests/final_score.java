package in.dbit.byb.Tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class final_score extends AppCompatActivity {

    TextView txt;
    String str = "Aptitude";
    String stuff1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        txt = (TextView) findViewById(R.id.fscr);

        Bundle bundle = getIntent().getExtras();
        final Integer stuff = bundle.getInt("stuff");

        txt.setText("Final Score: " +stuff);

        stuff1 = stuff.toString();

        RequestQueue queue1 = Volley.newRequestQueue(final_score.this);
        String url = "http://bybtest.000webhostapp.com/store_m.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast t = Toast.makeText(getApplicationContext(), "Score Recorded", Toast.LENGTH_SHORT);
                        t.show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT);
                toast.show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("test", str);
                params.put("marks", stuff1);
                return params;

            }
        };
        queue1.add(stringRequest);
    }
}
