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
    //String language;
    //SharedPreferences languagepref;
    String startedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadLocale();
        SharedPreferences prefs = getSharedPreferences("Settings",Activity.MODE_PRIVATE);
        startedLanguage = prefs.getString("My_Lang","");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //languagepref = getSharedPreferences("language",MODE_PRIVATE);
        //language = languagepref.getString("languageToLoad",Locale.getDefault().getDisplayLanguage());


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



    /*
    private void setLanguageForApp(String languageCode){
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        saveLocale(languageCode);
        }

        private void saveLocale(String languageCode){

            SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
            editor.putString("My_Lang",languageCode);
            editor.commit();
        }
    //load language saved in shared preferences
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLanguageForApp(language);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String oldLanguage = language;
        language = languagepref.getString("languageToLoad",Locale.getDefault().getDisplayLanguage());
        if(!oldLanguage.equals((language))){
            recreate();
        }
    }*/
}
