package ecarroll.cachcapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;


public class SupportActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        // initialize buttons
        Button btnTwitter = (Button)(findViewById(R.id.btnTwitter));
        Button btnFacebook = (Button)(findViewById(R.id.btnFacebook));
        Button btnDonate = (Button)(findViewById(R.id.btnDonate));
        Button btnEmail = (Button)(findViewById(R.id.btnEmail));

        // define button behavior
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("twitter://user?screen_name=CACPomona"));
                    startActivity(intent);

                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/CACPomona")));
                }
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("fb://profile/101812303303312"));
                    startActivity(intent);

                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/CACPomona")));
                }
            }
        });

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://childrensadvocacyctr.org/donate"));
                startActivity(browserIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://6263316700"));
                startActivity(callIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_support, menu);
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
