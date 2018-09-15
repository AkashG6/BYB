package in.dbit.byb.PersonalityProfiling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.dbit.byb.R;

public class HollandJobs extends AppCompatActivity {

    ListView jobs_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holland_jobs);

        jobs_list = (ListView) findViewById(R.id.jobs_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(HollandJobs.this, android.R.layout.simple_list_item_1);
        jobs_list.setAdapter(arrayAdapter);

        Bundle extras = getIntent().getExtras();
        String HollandCode = extras.getString("Code");

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray job_array = obj.getJSONArray("jobs");

            String[] job_name = new String[job_array.length()];
            String[] job_code = new String[job_array.length()];

            for (int i = 0; i < job_array.length(); i++) {
                JSONObject job_object = job_array.getJSONObject(i);
//              Log.d("Details-->", jo_inside.getString("name"));
                String name = job_object.getString("name");
                String code = job_object.getString("code");

                job_name[i] = name;
                job_code[i] = code;
            }

            for(int i=0; i<job_array.length(); i++) {
                if(job_code[i].equals(HollandCode)) {
                    arrayAdapter.add(job_name[i]);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = HollandJobs.this.getAssets().open("holland-jobs.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
