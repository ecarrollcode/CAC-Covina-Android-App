package ecarroll.cachcapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.widget.Toast;


public class ShareActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Button btnShareHotline = (Button)(findViewById(R.id.btnShareHotline));
        Button btnShareApp = (Button)(findViewById(R.id.btnShareApp));

        btnShareHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ShareHotlineActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        btnShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareHotlineActivity.message = "Help fight child abuse. " +
                                               "Learn, Report, Support and Share by downloading the Children's Advocacy Center app: " +
                                               "https://play.google.com/store/apps/details?id=ecarroll.cachcapp";
                Intent myIntent = new Intent(view.getContext(), SMSActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
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
