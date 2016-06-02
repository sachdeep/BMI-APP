package com.example.titan.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.Button;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.text.TextUtils;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    private EditText et1,et2;
    RadioButton rb1,rb2,rb3,rb4;
    double ht,wt;
    public static double bmi;
    String str1,str2;
    Button bt1;
    MainActivity ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);


         rb1 = (RadioButton) findViewById(R.id.rb1);
         rb2 = (RadioButton) findViewById(R.id.rb2);
         rb3 = (RadioButton) findViewById(R.id.rb3);
         rb4 = (RadioButton) findViewById(R.id.rb4);


         bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);




    }












    public void onClick(View view) {

        str1 = et1.getText().toString();


        if(et1 == null || TextUtils.isEmpty(str1)|| et1.getText().toString()=="") {

            wt = 0.0;

        } else {

            wt = Double.parseDouble(str1);

        }
        str2 = et2.getText().toString();


        if(et2 == null || TextUtils.isEmpty(str2)) {

            ht = 0.0;

        } else {

            ht = Double.parseDouble(str2);

        }



        if (rb1.isChecked()) {
            wt = wt * 0.45;
        } else if (rb2.isChecked()) {
            wt = wt * 1;
        }


        if (rb3.isChecked()) {
            ht = ht * 0.01;
        } else if (rb4.isChecked()) {
            ht = ht * 2.54 * 0.01;
        }




        bmi=wt/(ht*ht);
        Intent go = new Intent(MainActivity.this, boom.class);


        Bundle data = new Bundle();
        data.putDouble("val", bmi);

        go.putExtras(data);


        startActivity(go);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}