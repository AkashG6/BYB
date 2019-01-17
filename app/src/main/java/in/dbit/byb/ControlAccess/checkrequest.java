package in.dbit.byb.ControlAccess;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
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

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.dbit.byb.R;
    public class checkrequest extends Activity {
        ListView stud;
        private static final String JSON_URL ="http://bybtest.000webhostapp.com/listofstudents.php";
        List<studlist> studList;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_checkrequest);
            stud = (ListView) findViewById(R.id.listView);
            studList=new ArrayList<>();
            loadstudlist();

        }
        private void loadstudlist() {
            //getting the progressbar
            final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

            //making the progressbar visible
            progressBar.setVisibility(View.VISIBLE);
            //creating a request queue
            RequestQueue requestQueue = Volley.newRequestQueue(checkrequest.this);

            //creating a string request to send request to the url
            StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //hiding the progressbar after completion
                            progressBar.setVisibility(View.INVISIBLE);


                            try {
                                //getting the whole json object from the response
                                JSONObject obj = new JSONObject(response);

                                //we have the array named hero inside the object
                                //so here we are getting that json array
                                JSONArray studArray = obj.getJSONArray("uname");

                                //now looping through all the elements of the json array
                                if(studArray!=null) {
                                    for (int i = 0; i < studArray.length(); i++) {
                                        //getting the json object of the particular index inside the array
                                        JSONObject studObject = studArray.getJSONObject(i);

                                        //creating a hero object and giving them the values from json object
                                        studlist stud1 = new studlist(studObject.getString("uname"));

                                        //adding the hero to herolist
                                        studList.add(stud1);
                                    }
                                }
                                //creating custom adapter object
                                ListViewAdapter adapter = new ListViewAdapter(studList, getApplicationContext());

                                //adding the adapter to listview
                                stud.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //displaying the error in toast if occurrs
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("username",getIntent().getExtras().getString("username"));
                    return params;

                }
            };


            //adding the string request to request queue
            requestQueue.add(stringRequest);
        }
    }
