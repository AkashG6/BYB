package in.dbit.byb.Tests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import in.dbit.byb.R;

public class manageschedule extends AppCompatActivity {

    private void exec(String res){
        Toast.makeText(manageschedule.this, res, Toast.LENGTH_LONG).show();
        JSONObject obj;
        try {
            obj = new JSONObject(res);
            Toast.makeText(manageschedule.this, String.valueOf(obj.length()), Toast.LENGTH_LONG).show();
            Toast.makeText(manageschedule.this, "In TRY", Toast.LENGTH_LONG).show();


        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }



        final LinearLayout lm = (LinearLayout) findViewById(R.id.outer);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,70,0,0);

        CardView.LayoutParams cmargins = new CardView.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cmargins.setMargins(35, 35, 35, 35);
        for(int j=0;j<=4;j++)
        {
            // Create LinearLayout
            CardView cv = new CardView(this);
            cv.setLayoutParams(cmargins);

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setPadding(40,40, 40,40);


            // Create TextView
            TextView task = new TextView(this);
            task.setTextSize(18);
            task.setText("Task: "+j);
            ll.addView(task);

            // Create TextView
            TextView deadline = new TextView(this);
            deadline.setTextSize(18);
            deadline.setText("Deadline:"+j);
            ll.addView(deadline);

            // Create TextView
            TextView revives = new TextView(this);
            revives.setTextSize(18);
            revives.setText("Revives Left:"+j);
            ll.addView(revives);

            // Create Button
            final Button btn = new Button(this);
            // Give button an ID
            btn.setId(j+1);
            btn.setText("Submit for completion");
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Log.i("TAG", "index :" + index);

                    Toast.makeText(getApplicationContext(),
                            "Clicked Button Index :" + index,
                            Toast.LENGTH_LONG).show();
                }
            });

            //Add button to LinearLayout
            ll.addView(btn);
            cv.addView(ll);
            //Add button to LinearLayout defined in XML
            lm.addView(cv);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manageschedule);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://bybtest.000webhostapp.com/getManageSchedule.php";
        StringRequest strreq = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
//                        Toast.makeText(manageschedule.this, "Success", Toast.LENGTH_SHORT).show();
                        exec(Response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Toast.makeText(manageschedule.this, String.valueOf(e), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
        queue.add(strreq);




        //Create four

    }



}
