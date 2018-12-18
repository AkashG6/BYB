package in.dbit.byb.Resume;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.dbit.byb.R;

public class Resume_Edit extends AppCompatActivity {

    EditText personal_name;
    EditText personal_label;
    EditText personal_email;
    EditText personal_phone;
    EditText personal_website;
    EditText personal_summary;
    EditText personal_address;
    EditText personal_postalcode;
    EditText personal_city;
    EditText personal_country;
    EditText personal_region;

    EditText profile_network;
    EditText profile_username;
    EditText profile_url;

    EditText work_company;
    EditText work_position;
    EditText work_website;
    EditText work_sdate;
    EditText work_edate;
    EditText work_summary;
    EditText work_highlight;

    EditText volunteer_organisation;
    EditText volunteer_position;
    EditText volunteer_website;
    EditText volunteer_sdate;
    EditText volunteer_edate;
    EditText volunteer_summary;
    EditText volunteer_highlight;

    EditText education_institute;
    EditText education_area;
    EditText education_sdate;
    EditText education_edate;
    EditText education_gpa;
    EditText education_courses;
    EditText education_study;

    EditText award_title;
    EditText award_date;
    EditText award_awarder;
    EditText award_summary;

    EditText publication_name;
    EditText publication_publisher;
    EditText publication_date;
    EditText publication_website;
    EditText publication_summary;

    EditText skill_name;
    EditText skill_level;
    EditText skill_keyword;

    EditText language_name;
    EditText language_level;

    EditText interest_name;
    EditText interest_keyword;

    EditText reference_name;
    EditText reference_reference;

    Button save;
    Button discard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_edit);
        personal_name = findViewById(R.id.personal_name);
        personal_label = findViewById(R.id.personal_label);
        personal_email = findViewById(R.id.personal_email);
        personal_phone = findViewById(R.id.personal_phone);
        personal_website = findViewById(R.id.personal_website);
        personal_summary = findViewById(R.id.personal_summary);
        personal_address = findViewById(R.id.personal_address);
        personal_postalcode = findViewById(R.id.personal_postalcode);
        personal_city = findViewById(R.id.personal_city);
        personal_country = findViewById(R.id.personal_country);
        personal_region = findViewById(R.id.personal_region);

        profile_network = findViewById(R.id.profile_network);
        profile_username = findViewById(R.id.profile_username);
        profile_url = findViewById(R.id.profile_url);

        work_company = findViewById(R.id.work_company);
        work_position = findViewById(R.id.work_position);
        work_website = findViewById(R.id.work_website);
        work_sdate = findViewById(R.id.work_sdate);
        work_edate = findViewById(R.id.work_edate);
        work_summary = findViewById(R.id.work_summary);
        work_highlight = findViewById(R.id.work_highlight);

        volunteer_organisation = findViewById(R.id.volunteer_organisation);
        volunteer_position = findViewById(R.id.volunteer_position);
        volunteer_website = findViewById(R.id.volunteer_website);
        volunteer_sdate = findViewById(R.id.volunteer_sdate);
        volunteer_edate = findViewById(R.id.volunteer_edate);
        volunteer_summary = findViewById(R.id.volunteer_summary);
        volunteer_highlight = findViewById(R.id.volunteer_highlight);

        education_institute = findViewById(R.id.education_institute);
        education_area = findViewById(R.id.education_area);
        education_sdate = findViewById(R.id.education__sdate);
        education_edate = findViewById(R.id.education_edate);
        education_gpa = findViewById(R.id.education_gpa);
        education_courses = findViewById(R.id.education_courses);
        education_study = findViewById(R.id.education_study);

        award_title = findViewById(R.id.award_title);
        award_date = findViewById(R.id.award_date);
        award_awarder = findViewById(R.id.award_awarder);
        award_summary = findViewById(R.id.award_summary);

        publication_name = findViewById(R.id.publication_name);
        publication_publisher = findViewById(R.id.publication_publisher);
        publication_date = findViewById(R.id.publication_date);
        publication_website = findViewById(R.id.publication_website);
        publication_summary = findViewById(R.id.publication_summary);

        skill_name = findViewById(R.id.skill_name);
        skill_level = findViewById(R.id.skill_level);
        skill_keyword = findViewById(R.id.skill_keyword);

        language_name = findViewById(R.id.language_name);
        language_level = findViewById(R.id.language_level);

        interest_name = findViewById(R.id.interest_name);
        interest_keyword = findViewById(R.id.interest_keyword);

        reference_name = findViewById(R.id.reference_name);
        reference_reference = findViewById(R.id.reference_reference);

        save = findViewById(R.id.save);
        discard = findViewById(R.id.discard);

        SharedPreferences sp = getSharedPreferences("Resume", MODE_PRIVATE);

        personal_name.setText(sp.getString("personal_name", ""));
        personal_label.setText(sp.getString("personal_label", ""));
        personal_email.setText(sp.getString("personal_email", ""));
        personal_phone.setText(sp.getString("personal_phone", ""));
        personal_website.setText(sp.getString("personal_website", ""));
        personal_summary.setText(sp.getString("personal_summary", ""));
        personal_address.setText(sp.getString("personal_address", ""));
        personal_postalcode.setText(sp.getString("personal_postalcode", ""));
        personal_city.setText(sp.getString("personal_city", ""));
        personal_country.setText(sp.getString("personal_country", ""));
        personal_region.setText(sp.getString("personal_region", ""));

        profile_network.setText(sp.getString("profile_network", ""));
        profile_username.setText(sp.getString("profile_username", ""));
        profile_url.setText(sp.getString("profile_url", ""));

        work_company.setText(sp.getString("work_company", ""));
        work_position.setText(sp.getString("work_position", ""));
        work_website.setText(sp.getString("work_website", ""));
        work_sdate.setText(sp.getString("work_sdate", ""));
        work_edate.setText(sp.getString("work_edate", ""));
        work_summary.setText(sp.getString("work_summary", ""));
        work_highlight.setText(sp.getString("work_highlight", ""));

        volunteer_organisation.setText(sp.getString("volunteer_organisation", ""));
        volunteer_position.setText(sp.getString("volunteer_position", ""));
        volunteer_website.setText(sp.getString("volunteer_website", ""));
        volunteer_sdate.setText(sp.getString("volunteer_sdate", ""));
        volunteer_edate.setText(sp.getString("volunteer_edate", ""));
        volunteer_summary.setText(sp.getString("volunteer_summary", ""));
        volunteer_highlight.setText(sp.getString("volunteer_highlight", ""));

        education_institute.setText(sp.getString("education_institute", ""));
        education_area.setText(sp.getString("education_area", ""));
        education_sdate.setText(sp.getString("education_sdate", ""));
        education_edate.setText(sp.getString("education_edate", ""));
        education_gpa.setText(sp.getString("education_gpa", ""));
        education_courses.setText(sp.getString("education_courses", ""));
        education_study.setText(sp.getString("education_study", ""));

        award_title.setText(sp.getString("award_title", ""));
        award_date.setText(sp.getString("award_date", ""));
        award_awarder.setText(sp.getString("award_awarder", ""));
        award_summary.setText(sp.getString("award_summary", ""));

        publication_name.setText(sp.getString("publication_name", ""));
        ;
        publication_publisher.setText(sp.getString("publication_publisher", ""));
        publication_date.setText(sp.getString("publication_date", ""));
        publication_website.setText(sp.getString("publication_website", ""));
        publication_summary.setText(sp.getString("publication_summary", ""));

        skill_name.setText(sp.getString("skill_name", ""));
        skill_level.setText(sp.getString("skill_level", ""));
        skill_keyword.setText(sp.getString("skill_keyword", ""));

        language_name.setText(sp.getString("language_name", ""));
        language_level.setText(sp.getString("language_level", ""));

        interest_name.setText(sp.getString("interest_name", ""));
        interest_keyword.setText(sp.getString("interest_keyword", ""));

        reference_name.setText(sp.getString("reference_name", ""));
        reference_reference.setText(sp.getString("reference_reference", ""));


        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Resume_Edit.this, "Resume Saved!",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Resume_Edit.this, Resume_Main.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("Resume", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("personal_name", personal_name.getText().toString());
                editor.putString("personal_label", personal_label.getText().toString());
                editor.putString("personal_email", personal_email.getText().toString());
                editor.putString("personal_phone", personal_phone.getText().toString());
                editor.putString("personal_website", personal_website.getText().toString());
                editor.putString("personal_summary", personal_summary.getText().toString());
                editor.putString("personal_address", personal_address.getText().toString());
                editor.putString("personal_postalcode", personal_postalcode.getText().toString());
                editor.putString("personal_city", personal_city.getText().toString());
                editor.putString("personal_country", personal_country.getText().toString());
                editor.putString("personal_region", personal_region.getText().toString());
                editor.putString("profile_network", profile_network.getText().toString());
                editor.putString("profile_username", profile_username.getText().toString());
                editor.putString("profile_url", profile_url.getText().toString());
                editor.putString("work_company", work_company.getText().toString());
                editor.putString("work_position", work_position.getText().toString());
                editor.putString("work_website", work_website.getText().toString());
                editor.putString("work_sdate", work_sdate.getText().toString());
                editor.putString("work_edate", work_edate.getText().toString());
                editor.putString("work_summary", work_summary.getText().toString());
                editor.putString("work_highlight", work_highlight.getText().toString());
                editor.putString("volunteer_organisation", volunteer_organisation.getText().toString());
                editor.putString("volunteer_position", volunteer_position.getText().toString());
                editor.putString("volunteer_website", volunteer_website.getText().toString());
                editor.putString("volunteer_sdate", volunteer_sdate.getText().toString());
                editor.putString("volunteer_edate", volunteer_edate.getText().toString());
                editor.putString("volunteer_summary", volunteer_summary.getText().toString());
                editor.putString("volunteer_highlight", volunteer_highlight.getText().toString());
                editor.putString("education_institute", education_institute.getText().toString());
                editor.putString("education_area", education_area.getText().toString());
                editor.putString("education_sdate", education_sdate.getText().toString());
                editor.putString("education_edate", education_edate.getText().toString());
                editor.putString("education_gpa", education_gpa.getText().toString());
                editor.putString("education_courses", education_courses.getText().toString());
                editor.putString("education_study", education_study.getText().toString());
                editor.putString("award_title", award_title.getText().toString());
                editor.putString("award_date", award_date.getText().toString());
                editor.putString("award_awarder", award_awarder.getText().toString());
                editor.putString("award_summary", award_summary.getText().toString());
                editor.putString("publication_name", publication_name.getText().toString());
                editor.putString("publication_publisher", publication_publisher.getText().toString());
                editor.putString("publication_date", publication_date.getText().toString());
                editor.putString("publication_website", publication_website.getText().toString());
                editor.putString("publication_summary", publication_summary.getText().toString());
                editor.putString("skill_name", skill_name.getText().toString());
                editor.putString("skill_level", skill_level.getText().toString());
                editor.putString("skill_keyword", skill_keyword.getText().toString());
                editor.putString("language_name", language_name.getText().toString());
                editor.putString("language_level", language_level.getText().toString());
                editor.putString("interest_name", interest_name.getText().toString());
                editor.putString("interest_keyword", interest_keyword.getText().toString());
                editor.putString("reference_name", reference_name.getText().toString());
                editor.putString("reference_reference", reference_reference.getText().toString());

                editor.apply();

                Toast.makeText(Resume_Edit.this, "Resume Saved!",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Resume_Edit.this, Resume_Main.class);
                startActivity(intent);
            }
        });
    }
}
