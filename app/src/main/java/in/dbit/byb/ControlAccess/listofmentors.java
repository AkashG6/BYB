package in.dbit.byb.ControlAccess;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import in.dbit.byb.R;

public class listofmentors extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofmentorsmain);

        listView = (ListView) findViewById(R.id.listView);

            class GetJSON extends AsyncTask<Void, Void, String> {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }


                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    try {
                        loadIntoListView(s);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        URL url = new URL("http://bybtest.000webhostapp.com/listoffaculty.php");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String json;
                        while ((json = bufferedReader.readLine()) != null) {
                            sb.append(json + "\n");
                        }
                        return sb.toString().trim();
                    } catch (Exception e) {
                        return null;
                    }
                }
            }
            GetJSON getJSON = new GetJSON();
            getJSON.execute();
        }

        private void loadIntoListView(String json) throws JSONException {
            JSONArray jsonArray = new JSONArray(json);
            String[] faculty = new String[jsonArray.length()];
            final String[] facultyuser=new String[jsonArray.length()];
            final String[] facultyemail=new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                faculty[i] = obj.getString("name");
                facultyuser[i]=obj.getString("username");
                facultyemail[i]=obj.getString("email");

            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, faculty);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String name2 = (String) adapterView.getItemAtPosition(i);
                    //String username=(String) adapterView.getItemAtPosition(i);
                    //String email=(String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(listofmentors.this, mentordetails.class);
                    intent.putExtra("name",name2);
                    intent.putExtra("username",facultyuser);
                    intent.putExtra("email",facultyemail);
                    intent.putExtra("position",i);
                    intent.putExtra("stud_user",getIntent().getExtras().getString("stud_user"));
                    startActivity(intent);
                }
            });
        }

        /*AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name2 = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(listofmentors.this, mentordetails.class);
                intent.putExtra("name",name2);
                startActivity(intent);
            }

        };*/
    }



