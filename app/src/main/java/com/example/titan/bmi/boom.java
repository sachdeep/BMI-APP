package com.example.titan.bmi;

/**
 * Created by titan on 29-05-2016.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.TextView;
import android.view.WindowManager;
import android.support.v7.app.ActionBarActivity;

public class boom extends AppCompatActivity {

        private TextView tv1,tv2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewbmi);



         tv1=(TextView) findViewById(R.id.tv1);
         tv2=(TextView) findViewById(R.id.tv2);


        Bundle bun = getIntent().getExtras();
        double value = bun.getDouble("val");


        String str = String.valueOf(value);
        tv1.setText("your bmi is"+str);
        if(value<19)
            tv2.setText("you are thin");
        else if (value>25)
            tv2.setText("you are obese");
        else
            tv2.setText("you are healthy");


    }



}
