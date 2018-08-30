package org.chilon.rubics_cube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainPageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPageText = (TextView) findViewById(R.id.main_page_text);
        //mainPageText.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);



    }
}
