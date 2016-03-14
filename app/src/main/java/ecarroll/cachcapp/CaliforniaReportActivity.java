package ecarroll.cachcapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class CaliforniaReportActivity extends ActionBarActivity {

    // initialize spinner and adapter
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    // arrays for storing couty names and their respective numbers
    String[] counties = {"Alameda","Alpine","Amador","Butte","Calaveras","Colusa","Contra Costa",
                         "Del Norte","El Dorado","Fresno","Glenn","Humboldt","Imperial","Inyo",
                         "Kern","Kings","Lake","Lassen","Los Angeles","Madera","Marin","Mariposa",
                         "Mendocino","Merced","Modoc","Mono","Monterey","Napa","Nevada","Orange",
                         "Placer","Plumas","Riverside","Sacramento","San Benito","San Bernadino",
                         "San Diego","San Francisco","San Joaquin","San Luis Obispo","San Mateo",
                         "Santa Barbara","Santa Clara","Santa Cruz","Shasta","Sierra","Siskiyou",
                         "Solano","Sonoma","Stanislaus","Sutter","Tehema","Trinity","Tulare",
                         "Tuolumne","Ventura","Yolo","Yuba"};

    String[] countyNums = {"(510) 259-1800","(530) 694-2235","(209) 223-6550","(800) 400-0902",
                           "(209) 754-6452","(530) 458-0280","(877) 881-1116","(707) 464-3191",
                           "(530) 642-7100","(559) 255-8320","(530) 934-6520","(707) 445-6180",
                           "(760) 337-7750","(760) 872-1727","(661) 631-6011","(559) 582-2352",
                           "(707) 262-0235","(530) 251-8277","(800) 540-4000","(559) 675-7829",
                           "(415) 499-7153","(209) 966-7000","(866) 236-0368","(209) 385-3104",
                           "(530) 233-6602","(760) 932-7755","(831) 755-4661","(707) 253-4262",
                           "(530) 273-4291","(714) 940-1000","(916) 872-6549","(800) 242-3338",
                           "(800) 442-4918","(916) 875-5437","(831) 636-4190","(909) 384-9233",
                           "(858) 560-2191","(415) 558-2650","(209) 468-1333","(805) 781-5437",
                           "(650) 595-7922","(800) 367-0166","(408) 299-2071","(831) 454-2273",
                           "(530) 225-5144","(530) 289-3720","(530) 841-4200","(800) 544-8696",
                           "(707) 565-4304","(209) 558-3665","(530) 822-7227","(530) 527-1911",
                           "(530) 623-1314","(559) 730-2677","(209) 533-5717","(805) 654-3200",
                           "(530) 669-2345","(530) 749-6288"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_california_report);

        // set spinner and adapter
        spinner = (Spinner) findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(this, R.array.county_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // set default to Los Angeles county
        spinner.setSelection(18);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final Button btnCaliforniaCall = (Button) (findViewById(R.id.btnCaliforniaCall));

                //handle button text
                for (int i = 0; i < counties.length; i++) {
                    if (parent.getItemAtPosition(position).equals(counties[i])) {
                        btnCaliforniaCall.setText(countyNums[i]);
                    }
                }

                //handle button behavior
                btnCaliforniaCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int n = 0; n < counties.length; n++) {
                            if (spinner.getSelectedItem().toString().equals(counties[n])) {
                                String currentNumber = countyNums[n];
                                //clean number string
                                currentNumber = currentNumber.replaceAll("[^a-zA-Z0-9]","");
                                String uri = "tel:" + currentNumber;

                                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));
                                startActivity(callIntent);
                            }
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_california_report, menu);
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
