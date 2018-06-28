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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import in.dbit.byb.R;

public class addschedule extends AppCompatActivity {

    TextView task,due;
    CalendarView calender;
    Integer day, month,year;
    Integer valid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addschedule);

        task = (EditText) findViewById(R.id.editText2);
        due = (TextView) findViewById(R.id.textView1);
        calender = (CalendarView)findViewById(R.id.calendarView);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
//        Date date = (Date) Calendar.getInstance().getTime();

        java.util.Date uDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(uDate.getTime());

        String sDate = format.format(sqlDate);//31-12-9999
        final int mYear = c.get(Calendar.YEAR);//9999
        int mMonth1 = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);

        final int mMonth = mMonth1 + 1;//12

//        due.setText(mDay+" "+mMonth+" "+mYear);

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
                        Toast.makeText(addschedule.this, "Please enter valid deadline!!", Toast.LENGTH_LONG).show();
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

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://bybtest.000webhostapp.com/createSchedule.php";
        final String task_s = task.getText().toString();
        if (task_s.equals(""))
        {
            Toast.makeText(addschedule.this, "Enter a task name!!", Toast.LENGTH_LONG).show();
            return;
        }
        if (valid == 1)
        {
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                            Intent intent = new Intent(addschedule.this,manageschedule.class);
                            startActivity(intent);
                            Toast.makeText(addschedule.this, "Schedule Created!", Toast.LENGTH_LONG).show();


                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response", String.valueOf(error));
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("task", task_s);
                    params.put("day",  String.valueOf(day));
                    params.put("month",  String.valueOf(month));
                    params.put("year",  String.valueOf(year));

                    return params;
                }
            };
            queue.add(postRequest);
        }
        else{
            Toast.makeText(addschedule.this, "Please enter valid deadline!!", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
