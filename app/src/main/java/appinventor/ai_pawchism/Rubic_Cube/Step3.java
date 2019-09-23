package appinventor.ai_pawchism.Rubic_Cube;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import java.util.Locale;

public class Step3 extends AppCompatActivity {
    String startedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadLocale();
        SharedPreferences prefs = getSharedPreferences("Settings",Activity.MODE_PRIVATE);
        startedLanguage = prefs.getString("My_Lang","");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        PublisherAdView publisherAdView = (PublisherAdView) findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        publisherAdView.loadAd(adRequest);

        Button homeButton = (Button) findViewById(R.id.step3_to_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,MainActivity.class));
            }
        });

        Button step1 = (Button) findViewById(R.id.step4_to_step1_button);
        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Step1.class));
            }
        });

        Button step2 = (Button) findViewById(R.id.step4_to_step2_button);
        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Step2.class));
            }
        });

        Button step3 = (Button) findViewById(R.id.step4_to_step3_button);
        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Step3.class));
            }
        });

        Button step4 = (Button) findViewById(R.id.step4_to_step4_button);
        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Step4.class));
            }
        });

        Button step5 = (Button) findViewById(R.id.step4_to_step5_button);
        step5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Step5.class));
            }
        });

        ImageView settingsImage = (ImageView) findViewById(R.id.step1_settings_imageview);
        settingsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Step3.this,Settings.class));
            }
        });
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        if(!language.equals(startedLanguage)){ //check weather language is changed
            recreate();
            startedLanguage = language;
        }
    }
}
