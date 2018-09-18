package in.dbit.byb.Tests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import in.dbit.byb.R;

public class reasoning extends AppCompatActivity {

//    private ques_Lib mQuestionLibrary = new ques_Lib();

    public TextView mScoreView;
    public TextView mQuestionView;
    public Button mButtonChoice1;
    public Button mButtonChoice2;
    public Button mButtonChoice3;
    public Button mButtonChoice4;

    public String mAnswer;
    public int mScore = 0;
    public int mQuestionNumber = 0;
//    String mQuestions [];
//    String mChoices [][];
//    String mCorrectAnswers[];

//    public void exec(String res) throws JSONException {
//        JSONArray jsonArray = new JSONArray(res);
//
//        for (int j = 0; j < jsonArray.length(); j++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(j);
//
//            Integer no = jsonObject.getInt("No");
//            mQuestions[j] = jsonObject.getString("Question");
//            mChoices[j][0] = jsonObject.getString("Opt1");
//            mChoices[j][1] = jsonObject.getString("Opt2");
//            mChoices[j][2] = jsonObject.getString("Opt3");
//            mChoices[j][3] = jsonObject.getString("Opt4");
//            mCorrectAnswers[j] = jsonObject.getString("Answer");
//        }
//
//    }

    private String mQuestions [] = {
            "Which part of the plant holds it in the soil?",
            "This part of the plant absorbs energy from the sun.",
            "This part of the plant attracts bees, butterflies and hummingbirds.",
            "The _______ holds the plant upright."

    };


    private String mChoices [][] = {
            {"Roots", "Stem", "Flower", "Leaves"},
            {"Fruit", "Leaves", "Seeds", "Roots"},
            {"Bark", "Flower", "Roots", "Stem"},
            {"Flower", "Leaves", "Stem", "Roots"}
    };



    private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasoning);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://bybtest.000webhostapp.com/ques_apti.php";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //
//                        Toast.makeText(reasoning.this, "Success", Toast.LENGTH_LONG).show();
//                        Log.d("Response is: ", response);
//                        try {
//                            exec(response);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                mQuestionView.setText("That didn't work!");
//            }
//        });

//        queue.add(stringRequest);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(reasoning.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(reasoning.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(reasoning.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(reasoning.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(reasoning.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(reasoning.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Butoon3


        //Start of Butoon Listener for Button4
        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice4.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(reasoning.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(reasoning.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button4

    }

    private void updateQuestion(){
        mQuestionView.setText(getQuestion(mQuestionNumber));
        mButtonChoice1.setText(getChoice1(mQuestionNumber));
        mButtonChoice2.setText(getChoice2(mQuestionNumber));
        mButtonChoice3.setText(getChoice3(mQuestionNumber));
        mButtonChoice4.setText(getChoice4(mQuestionNumber));

        mAnswer = getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;

        if (mQuestionNumber >= mQuestions.length){
            Intent i = new Intent(reasoning.this, final_score.class);
            Bundle bundle = new Bundle();
            bundle.putInt("stuff", mScore);
            bundle.putString("typ", "Aptitude_Reasoning");
            i.putExtras(bundle);
            startActivity(i);
        }
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
