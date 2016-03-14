package ecarroll.cachcapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize buttons
        Button btnLearn = (Button)(findViewById(R.id.btnLearn));
        Button btnServices = (Button)(findViewById(R.id.btnServices));
        Button btnSupport = (Button)(findViewById(R.id.btnSupport));
        Button btnReport = (Button)(findViewById(R.id.btnReport));
        Button btnShare = (Button)(findViewById(R.id.btnShare));

        // define behavior for each button
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("youtube://www.youtube.com/user/ChildrensAdvocacyCenter"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/channel/UCyLMpGZaNlrtdBnwp4kGSCQ"));
                    startActivity(browserIntent);
                }
            }
        });

        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://childrensadvocacyctr.org/services"));
                startActivity(browserIntent);
            }
        });

        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SupportActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ReportActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ShareActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
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
