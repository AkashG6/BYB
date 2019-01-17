package in.dbit.byb.Resume;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import in.dbit.byb.R;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Resume_Generate extends AppCompatActivity {
    private Socket mSocket;
    private Emitter.Listener onGenerated = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    try {
                        String url = (String) args[0];
                        Toast.makeText(Resume_Generate.this, "Resume URL: " + url,
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        return;
                    }

                }
            });
        }
    };

    {
        try {
            mSocket = IO.socket("http://192.168.31.230:3000");
        } catch (URISyntaxException e) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_generate);
        mSocket.on("generated", onGenerated);
        mSocket.connect();
        SharedPreferences sp = getSharedPreferences("Resume", MODE_PRIVATE);
        try {
            JSONObject resumeJSON = new JSONObject();

            JSONObject basics = new JSONObject();
            JSONObject location = new JSONObject();

            JSONArray arr_profiles = new JSONArray();

            JSONArray arr_work = new JSONArray();
            JSONArray arr_volunteer = new JSONArray();
            JSONArray arr_education = new JSONArray();
            JSONArray arr_awards = new JSONArray();
            JSONArray arr_publication = new JSONArray();
            JSONArray arr_skills = new JSONArray();
            JSONArray arr_langugages = new JSONArray();
            JSONArray arr_interests = new JSONArray();
            JSONArray arr_references = new JSONArray();


            basics.put("name", sp.getString("personal_name", ""));
            basics.put("label", sp.getString("personal_label", ""));
            basics.put("picture", sp.getString("personal_picture", ""));
            basics.put("email", sp.getString("personal_email", ""));
            basics.put("phone", sp.getString("personal_phone", ""));
            basics.put("website", sp.getString("personal_website", ""));
            basics.put("summary", sp.getString("personal_summary", ""));

            location.put("address", sp.getString("personal_address", ""));
            location.put("postalCode", sp.getString("personal_postalcode", ""));
            location.put("city", sp.getString("personal_city", ""));
            location.put("countryCode", sp.getString("personal_country", ""));
            location.put("region", sp.getString("personal_region", ""));

            basics.put("location", location);
            for (int i = 1; i <= sp.getInt("no_of_profile", 1); i++) {
                JSONObject profiles = new JSONObject();
                profiles.put("network", sp.getString("profile_network", ""));
                profiles.put("username", sp.getString("profile_username", ""));
                profiles.put("url", sp.getString("profile_url", ""));
                arr_profiles.put(profiles);
            }

            basics.put("profiles", arr_profiles);

            for (int i = 1; i <= sp.getInt("no_of_work", 1); i++) {
                JSONObject work = new JSONObject();
                work.put("company", sp.getString("work_company", ""));
                work.put("position", sp.getString("work_position", ""));
                work.put("website", sp.getString("work_website", ""));
                work.put("startDate", sp.getString("work_sdate", ""));
                work.put("endDate", sp.getString("work_edate", ""));
                work.put("summary", sp.getString("work_summary", ""));
                work.put("highlights", sp.getString("work_highlight", ""));
                arr_work.put(work);
            }

            for (int i = 1; i <= sp.getInt("no_of_volunteer", 1); i++) {
                JSONObject volunteer = new JSONObject();
                volunteer.put("organization", sp.getString("volunteer_organisation", ""));
                volunteer.put("position", sp.getString("volunteer_position", ""));
                volunteer.put("website", sp.getString("volunteer_website", ""));
                volunteer.put("startDate", sp.getString("volunteer_sdate", ""));
                volunteer.put("endDate", sp.getString("volunteer_edate", ""));
                volunteer.put("summary", sp.getString("volunteer_summary", ""));
                volunteer.put("highlights", sp.getString("volunteer_highlight", ""));
                arr_volunteer.put(volunteer);
            }

            for (int i = 1; i <= sp.getInt("no_of_education", 1); i++) {
                JSONObject education = new JSONObject();
                education.put("institution", sp.getString("education_institute", ""));
                education.put("area", sp.getString("education_area", ""));
                education.put("studyType", sp.getString("education_study", ""));
                education.put("startDate", sp.getString("education_sdate", ""));
                education.put("endDate", sp.getString("education_edate", ""));
                education.put("gpa", sp.getString("education_gpa", ""));
                education.put("courses", sp.getString("education_courses", ""));
                arr_education.put(education);
            }

            for (int i = 1; i <= sp.getInt("no_of_awards", 1); i++) {
                JSONObject awards = new JSONObject();
                awards.put("title", sp.getString("award_title", ""));
                awards.put("date", sp.getString("award_date", ""));
                awards.put("awarder", sp.getString("award_awarder", ""));
                awards.put("summary", sp.getString("award_summary", ""));
                arr_awards.put(awards);
            }

            for (int i = 1; i <= sp.getInt("no_of_publications", 1); i++) {
                JSONObject publications = new JSONObject();
                publications.put("name", sp.getString("publication_name", ""));
                publications.put("publisher", sp.getString("publication_publisher", ""));
                publications.put("releaseDate", sp.getString("publication_date", ""));
                publications.put("website", sp.getString("publication_website", ""));
                publications.put("summary", sp.getString("publication_summary", ""));
                arr_publication.put(publications);
            }

            for (int i = 1; i <= sp.getInt("no_of_skills", 1); i++) {
                JSONObject skills = new JSONObject();
                skills.put("name", sp.getString("skill_name", ""));
                skills.put("level", sp.getString("skill_level", ""));
                arr_skills.put(skills);
            }
            JSONArray arr_skills_keywords = new JSONArray();
            for (int i = 1; i <= sp.getInt("no_of_skills_keyword", 1); i++) {
                JSONObject keyword = new JSONObject();
                keyword.put("keywords", sp.getString("skill_keyword", ""));
                arr_skills_keywords.put(keyword);
            }
            arr_skills.put(arr_skills_keywords);

            for (int i = 1; i <= sp.getInt("no_of_langugage", 1); i++) {
                JSONObject languages = new JSONObject();
                languages.put("language", sp.getString("langugage_name", ""));
                languages.put("fluency", sp.getString("langugage_level", ""));
                arr_langugages.put(languages);
            }


            for (int i = 1; i <= sp.getInt("no_of_interests", 1); i++) {
                JSONObject interests = new JSONObject();
                interests.put("name", sp.getString("interest_name", ""));
                arr_interests.put(interests);
            }
            JSONArray arr_interests_keywords = new JSONArray();
            for (int i = 1; i <= sp.getInt("no_of_interests_keyword", 1); i++) {
                JSONObject keyword = new JSONObject();
                keyword.put("keywords", sp.getString("interest_keyword", ""));
                arr_interests_keywords.put(keyword);
            }
            arr_interests.put(arr_interests_keywords);


            for (int i = 1; i <= sp.getInt("no_of_references", 1); i++) {
                JSONObject references = new JSONObject();
                references.put("name", sp.getString("reference_name", ""));
                references.put("reference", sp.getString("reference_reference", ""));
                arr_references.put(references);
            }

            resumeJSON.put("basics", basics);
            resumeJSON.put("work", arr_work);
            resumeJSON.put("volunteer", arr_volunteer);
            resumeJSON.put("education", arr_education);
            resumeJSON.put("awards", arr_awards);
            resumeJSON.put("publications", arr_publication);
            //resumeJSON.put("skills",arr_skills);
            resumeJSON.put("languages", arr_langugages);
            //resumeJSON.put("interests",arr_interests);
            resumeJSON.put("references", arr_references);
            System.out.println(resumeJSON.toString());

            mSocket.emit("generate", resumeJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
        mSocket.off("generate", onGenerated);
    }
}
