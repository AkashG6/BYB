package in.dbit.byb.Tests;

import android.content.Intent;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.dbit.byb.R;

public class goalEvaluation extends AppCompatActivity {

    private void exec(String res) {
//        Toast.makeText(goalEvaluation.this, String.valueOf(res.length()), Toast.LENGTH_LONG).show();
        try {

            JSONArray jsonArray = new JSONArray(res);
//
            final LinearLayout lm = (LinearLayout) findViewById(R.id.outer);

            // create the layout params that will be used to define how your
            // button will be displayed
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,70,0,0);

            CardView.LayoutParams cmargins = new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            cmargins.setMargins(35, 35, 35, 35);

            Calendar c = Calendar.getInstance();
            Integer year = c.get(Calendar.YEAR);
            Integer month = c.get(Calendar.MONTH)+1;
            Integer day = c.get(Calendar.DAY_OF_MONTH);

            for(int j=0; j<jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);

                String stask = jsonObject.getString("task");
                Integer dday = jsonObject.getInt("deadline_day");
                Integer dmonth = jsonObject.getInt("deadline_month");
                Integer dyear = jsonObject.getInt("deadline_year");
                final Integer revives = jsonObject.getInt("revives_left");
                final Integer tid = jsonObject.getInt("task_id");

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date date1 = sdf.parse(dmonth + "/" + dday + "/" + dyear);
                Date date2 = sdf.parse(month + "/" + day + "/" + year);


                if (date1.before(date2)) {

                    // Create LinearLayout
                    CardView cv = new CardView(this);
                    cv.setLayoutParams(cmargins);

                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.setPadding(40, 40, 40, 40);

                    // Create TextView
                    TextView task1 = new TextView(this);
                    task1.setTextSize(18);
                    task1.setText("Task: " + stask);
                    ll.addView(task1);

                    // Create TextView
                    TextView deadline = new TextView(this);
                    deadline.setTextSize(18);
                    deadline.setText("Deadline:" + dday + "/" + dmonth + "/" + dyear);
                    ll.addView(deadline);

                    // Create TextView
                    TextView revives1 = new TextView(this);
                    revives1.setTextSize(18);
                    revives1.setText("Revives Left:" + revives);
                    ll.addView(revives1);

                    // Create Submit Button
                    final Button btn = new Button(this);
                    // Give button an ID
                    btn.setId(j + 1);
                    btn.setText("Revive");
                    // set the layoutParams on the button
                    btn.setLayoutParams(params);

                    final int index = j;
                    // Set click listener for button
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

//                            Log.i("TAG", "index :" + index);
//                            Toast.makeText(getApplicationContext(),"Clicked Button Index :" + index,Toast.LENGTH_LONG).show();
                            if(revives != 0) {
                                Intent intent = new Intent(goalEvaluation.this, reviveTask.class);
                                String message1 = Integer.toString(tid);
                                String message2 = Integer.toString(revives);
                                intent.putExtra("key1", message1);
                                intent.putExtra("key2", message2);
                                Log.i("Value", "Value : " + message1 + "" + message2);
                                startActivity(intent);
                                Toast.makeText(goalEvaluation.this, "Enter New Deadline", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(goalEvaluation.this,"Cannot Revive Task",Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    //Add button to LinearLayout
                    ll.addView(btn);
                    cv.addView(ll);
                    //Add button to LinearLayout defined in XML
                    lm.addView(cv);

                }
            }

        } catch (JSONException | ParseException e) {
            Toast.makeText(goalEvaluation.this, String.valueOf("ERROR!!! "+e), Toast.LENGTH_LONG).show();
            Log.e("MYAPP", "unexpected JSON exception", e);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_evaluation);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://bybtest.000webhostapp.com/getManageSchedule.php";

        StringRequest strreq = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
//                        Toast.makeText(goalEvaluation.this, "Success", Toast.LENGTH_SHORT).show();
                        exec(Response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Toast.makeText(goalEvaluation.this, String.valueOf(e), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
        queue.add(strreq);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_goal_evaluation);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://bybtest.000webhostapp.com/getManageSchedule.php";

        StringRequest strreq = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
//                        Toast.makeText(goalEvaluation.this, "Success", Toast.LENGTH_SHORT).show();
                        exec(Response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Toast.makeText(goalEvaluation.this, String.valueOf(e), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
        queue.add(strreq);
    }
}
