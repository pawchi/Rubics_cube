package org.chilon.rubics_cube;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLanguageForApp("pl");
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
                setLanguageForApp("pl");
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

    private void setLanguageForApp(String languageCode){
        Locale locale;

        if(languageCode.equals("pl")){
            locale = Locale.getDefault();
        }
        else {
            locale = new Locale(languageCode);
        }

        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
}
