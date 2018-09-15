package in.dbit.byb.Tests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import in.dbit.byb.R;

public class reviveTask extends AppCompatActivity {

    TextView task,due;
    CalendarView calender;
    Integer day, month, year;
    Integer valid = 0;
    Integer tid, revives, dday, dmonth, dyear;
    Integer id, rev;

    public void exec(String res) {

        try {

            Calendar c = Calendar.getInstance();
            Integer year = c.get(Calendar.YEAR);
            Integer month = c.get(Calendar.MONTH)+1;
            Integer day = c.get(Calendar.DAY_OF_MONTH);

            JSONArray jsonArray = new JSONArray(res);

            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);

                Integer t_id = jsonObject.getInt("task_id");
                Integer d_day = jsonObject.getInt("deadline_day");
                Integer d_month = jsonObject.getInt("deadline_month");
                Integer d_year = jsonObject.getInt("deadline_year");
                Integer revives_l = jsonObject.getInt("revives_left");

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date date1 = sdf.parse(d_month + "/" + d_day + "/" + d_year);
                Date date2 = sdf.parse(month + "/" + day + "/" + year);

                if(id == t_id) {
                    tid = t_id;
                    dday = d_day;
                    dmonth = d_month;
                    dyear = d_year;
                    if (rev == 2) {
                        revives = 1;
                    } else if (rev == 1) {
                        revives = 0;
                    }
                    break;
                }

            }

        }catch (JSONException | ParseException e) {
            Toast.makeText(reviveTask.this, String.valueOf("ERROR!!! "+e), Toast.LENGTH_LONG).show();
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revivetask);

        task = (EditText) findViewById(R.id.editText2);
        due = (TextView) findViewById(R.id.textView1);
        calender = (CalendarView)findViewById(R.id.calendarView);

        String message1 = getIntent().getExtras().getString("key1");
        String message2 = getIntent().getExtras().getString("key2");
        id = Integer.valueOf(message1);
        rev = Integer.valueOf(message2);
        Log.i("Value","Value : "+id + "" + rev);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        java.util.Date uDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(uDate.getTime());

        String sDate = format.format(sqlDate);//31-12-9999
        final int mYear = c.get(Calendar.YEAR);//9999
        int mMonth1 = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);

        final int mMonth = mMonth1 + 1;//12

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year1, int month1,
                                            int dayOfMonth) {
                // TODO Auto-generated method stub
                day = dayOfMonth;
                month = (month1 + 1);
                year = year1;
                String dayDifference= "";
                String message ="";
                try {
                    //Dates to compare
                    String CurrentDate=  ""+mMonth+"/"+mDay+"/"+mYear;
                    String FinalDate=  ""+month+"/"+day+"/"+year;

                    Date date1;
                    Date date2;

                    SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

                    //Setting dates
                    date1 = dates.parse(CurrentDate);
                    date2 = dates.parse(FinalDate);

                    //Comparing dates
                    long difference = date2.getTime()-date1.getTime() ;
                    long differenceDates = difference / (24 * 60 * 60 * 1000);

                    //Convert long to String
                    dayDifference = Long.toString(differenceDates);

                    String pass = "";
                    due.setText(pass);

                    if (differenceDates>365){
                        message = "less than " + differenceDates/365  + " year";
                        if (differenceDates/365>1){
                            message = message+"s";
                        }
                        valid = 1;
                    }
                    else if (differenceDates>30) {
                        message = "less than " + differenceDates/30 + " month";
                        if (differenceDates/30>1){
                            message = message+"s";
                        }
                        valid = 1;
                    }
                    else if (differenceDates>7){
                        message = "less than " + differenceDates/7 + " week";
                        if (differenceDates/7>1){
                            message = message+"s";
                        }
                        valid = 1;
                    }
                    else if (differenceDates>1){
                        message = differenceDates + " day";
                        if (differenceDates>1){
                            message = message+"s";
                        }
                        valid = 1;
                    }
                    else
                    {
                        valid = 0;
                        Toast.makeText(reviveTask.this, "Please enter valid deadline!!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    Log.e("HERE","HERE: " + dayDifference);
                }
                catch (Exception exception) {
                    Log.e("DIDN'T WORK", "exception " + exception);
                }

                String pass = "Deadline will be due in "+ message;
                due.setText(pass);

            }
        });

    }

    public void createSchedule(View v) // view is data type , v is object name
    {
        RequestQueue queue1 = Volley.newRequestQueue(this);
        String url1 = "http://bybtest.000webhostapp.com/reviveTask2.php";
        StringRequest strreq = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
                        Toast.makeText(reviveTask.this, "Success", Toast.LENGTH_LONG).show();
                        Log.d("Response", Response);
                        exec(Response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Toast.makeText(reviveTask.this, String.valueOf(e), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
        queue1.add(strreq);

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "http://bybtest.000webhostapp.com/reviveTask1.php";
            if (valid == 1) {
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                                Intent intent = new Intent(reviveTask.this, manageschedule.class);
                                startActivity(intent);
                                Toast.makeText(reviveTask.this, "Schedule Created!", Toast.LENGTH_LONG).show();


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("tid", String.valueOf(tid));
                        params.put("day", String.valueOf(day));
                        params.put("month", String.valueOf(month));
                        params.put("year", String.valueOf(year));
                        params.put("revives", String.valueOf(revives));
                        return params;
                    }
                };
                queue.add(postRequest);

            } else {
                Toast.makeText(reviveTask.this, "Please enter valid deadline!!", Toast.LENGTH_LONG).show();
            }
    }
}
