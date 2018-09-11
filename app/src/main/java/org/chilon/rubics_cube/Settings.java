package org.chilon.rubics_cube;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setLanguageForApp("pl");
        loadLocale();
        setContentView(R.layout.activity_settings);

        LinearLayout linLay = (LinearLayout) findViewById(R.id.main_setup_lin_layout);
        linLay.setAlpha((float) 0.8);

        TextView rateUs = (TextView) findViewById(R.id.settings_rate_us);

        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=appinventor.ai_pawchism.Rubic_Cube")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=appinventor.ai_pawchism.Rubic_Cube")));
                }
            }
        });

        TextView selectLanguage = (TextView) findViewById(R.id.settings_change_language);
        selectLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this,SelectLanguage.class));
            }
        });

        TextView selectPolish = (TextView) findViewById(R.id.settings_test_pol);
        selectPolish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguageForApp("");
            }
        });

        TextView selectEnglish = (TextView) findViewById(R.id.settings_test_ang);
        selectEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguageForApp("en");
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        recreate();
    }

    private void setLanguageForApp(String languageCode){
        Locale locale = new Locale(languageCode);

        /*
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        res.updateConfiguration(conf,dm);
        Intent refresh = new Intent(this,Settings.class);
        startActivity(refresh);
        finish();
        */



        /*
        if(languageCode.equals("")){
            locale = Locale.getDefault();
        } else {
            locale = new Locale(languageCode);
        }*/

        Locale.setDefault(locale);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        configuration.setLocale(locale);
        //configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        //recreate();

        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",languageCode);
        editor.apply();



        }

        /* The some as:
        Intent refresh = getIntent();
        finish();
        startActivity(refresh);*/

    //load language saved in shared preferences
    public void loadLocale(){

        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLanguageForApp(language);
    }
}
