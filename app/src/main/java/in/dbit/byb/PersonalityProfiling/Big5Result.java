package in.dbit.byb.PersonalityProfiling;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import in.dbit.byb.R;

public class Big5Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big5_result);

        Bundle extras = getIntent().getExtras();
        int O = extras.getInt("O");
        int C = extras.getInt("C");
        int E = extras.getInt("E");
        int A = extras.getInt("A");
        int N = extras.getInt("N");

        BarChart chart = (BarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, O));
        entries.add(new BarEntry(1f, C));
        entries.add(new BarEntry(2f, E));
        entries.add(new BarEntry(3f, A));
        entries.add(new BarEntry(4f, N));

        BarDataSet dataset = new BarDataSet(entries, "Big5 Test Result");

        String[] values = new String[]{"O","C","E","A","N"};

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

        int color = ContextCompat.getColor(Big5Result.this, R.color.colorPrimary);
        dataset.setColor(color);
    }
}
