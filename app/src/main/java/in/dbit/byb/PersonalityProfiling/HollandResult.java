package in.dbit.byb.PersonalityProfiling;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.dbit.byb.R;

public class HollandResult extends AppCompatActivity {

    private Button view_jobs;
    private String HollandCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holland_result);

        view_jobs = (Button) findViewById(R.id.view_jobs);

        Bundle extras = getIntent().getExtras();
        int Re = extras.getInt("Re");
        int I = extras.getInt("I");
        int A = extras.getInt("A");
        int S = extras.getInt("S");
        int E = extras.getInt("E");
        int C = extras.getInt("C");

        BarChart chart = (BarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, Re));
        entries.add(new BarEntry(1f, I));
        entries.add(new BarEntry(2f, A));
        entries.add(new BarEntry(3f, S));
        entries.add(new BarEntry(4f, E));
        entries.add(new BarEntry(5f, C));

        BarDataSet dataset = new BarDataSet(entries, "Holland Test Result");

        String[] values = new String[]{"R","I","A","S","E","C"};

        BarData data = new BarData(dataset);
        chart.setData(data);
        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(values));
        xAxis.setDrawGridLines(false);
        chart.getDescription().setEnabled(false);

        chart.animateY(1500);

        int color = ContextCompat.getColor(HollandResult.this, R.color.colorPrimary);
        dataset.setColor(color);

        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("R", Re);
        scores.put("I", I);
        scores.put("A", A);
        scores.put("S", S);
        scores.put("E", E);
        scores.put("C", C);

        for(int i=0; i<3; i++) {
            int max = 0;
            String maxTrait = "";
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                if(value>max) {
                    max = value;
                    maxTrait = key;
                }
            }

            HollandCode+=maxTrait;
            scores.remove(maxTrait);
        }

        Toast.makeText(HollandResult.this, HollandCode, Toast.LENGTH_LONG).show();

        view_jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HollandResult.this,HollandJobs.class);
                intent.putExtra("Code",HollandCode);
                startActivity(intent);
            }
        });
    }
}
