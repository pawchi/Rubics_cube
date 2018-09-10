package org.chilon.rubics_cube;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class SelectLanguage extends AppCompatActivity {

    RadioGroup languageRadioGroup;
    RadioButton radioButton;
    String radioButtonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        languageRadioGroup = (RadioGroup) findViewById(R.id.language_radioGroup);
        Button languageOkButton = (Button) findViewById(R.id.button_language_ok);
        Button languageCancelButton = (Button) findViewById(R.id.button_language_cancel);

        //Set screen in %: (int)(width*.9) = 90%
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.7),(int)(height*.7));

        languageCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        languageOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //preparingDataToSend();
                finish();
            }
        });

    }

    public void rbSelLanguageOnClick(View view){

        int languageCheckRadioGroup = languageRadioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(languageCheckRadioGroup);

        radioButtonResult = radioButton.getText().toString();
    }

    /*
    public void preparingDataToSend(){
        Intent intent = new Intent();
        intent.putExtra("language",radioButtonResult);
        setResult(RESULT_OK,intent);
    }
    */

    private void  updateViews(String languageCode){

    }

}
