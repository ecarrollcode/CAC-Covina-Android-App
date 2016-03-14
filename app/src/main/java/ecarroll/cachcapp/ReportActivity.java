package ecarroll.cachcapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ReportActivity extends ActionBarActivity {

    // initialize spinner and adapter
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    // arrays of state names and numbers
    String[] numStates = {"Alabama", "Alaska", "Arizona", "Arkansas", "Colorado", "Connecticut",
            "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho",
            "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Massachusetts", "Michigan", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
            "Puerto Rico", "Rhode Island", "South Dakota", "Tennessee", "Texas", "Utah",
            "Vermont", "Virginia", "Washington", "West Virginia", "Wyoming"};

    String[] urlStates = {"Maryland", "Minnesota", "North Carolina", "North Dakota",
            "South Carolina", "Wisconsin"};

    String[] stateNums = {"(334) 242-9500", "(800) 478-4444", "(888) 767-2445", "(800) 482-5964",
            "(844) 264-5437", "(800) 842-2288", "(800) 292-9582", "(202) 671-7233",
            "(800) 962-2873", "(855) 422-4453", "(808) 832-5300", "(855) 552-5437",
            "(800) 252-2873", "(800) 800-5556", "(800) 362-2178", "(800) 922-5330",
            "(800) 752-6200", "(855) 452-5437", "(800) 452-1999", "(800) 942-4357",
            "(800) 222-8000", "(800) 392-3738", "(866) 820-5437", "(800) 652-1999",
            "(800) 992-5757", "(800) 894-5533", "(877) 652-2873", "(800) 797-3260",
            "(800) 342-3720", "(855) 642-4453", "(800) 522-3511", "(855) 503-7233",
            "(800) 932-0313", "(800) 981-8333", "(800) 742-4453", "(877) 244-0864",
            "(877) 237-0004", "(800) 252-5400", "(800) 678-9399", "(800) 649-5285",
            "(800) 552-7096", "(866) 363-4276", "(800) 352-6513"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // set spinner and adapter
        spinner = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.state_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // set default spinner selection to California at position 4
        spinner.setSelection(4);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final Button btnCallOrList = (Button) (findViewById(R.id.btnCallOrList));

                // handle button text
                for (int i = 0; i < urlStates.length; i++) {
                    for (int n = 0; n < stateNums.length; n++) {
                        if (parent.getItemAtPosition(position).equals(urlStates[i])) {
                            btnCallOrList.setText("See Hotline List");
                        } else if (parent.getItemAtPosition(position).equals(numStates[n])) {
                            btnCallOrList.setText(stateNums[n]);
                        } else if (parent.getItemAtPosition(position).equals("California")) {
                            btnCallOrList.setText("Choose A County");
                        }
                    }
                }

                // handle button behavior
                btnCallOrList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (spinner.getSelectedItem().toString().equals("California")) {
                            Intent myIntent = new Intent(view.getContext(), CaliforniaReportActivity.class);
                            startActivityForResult(myIntent, 0);
                        }


                        for (int k = 0; k < numStates.length; k++) {
                            for (int j = 0; j < stateNums.length; j++) {
                                if (spinner.getSelectedItem().toString().equals("Maryland")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://www.dhr.state.md.us/blog/?page_id=4631")));
                                } else if (spinner.getSelectedItem().toString().equals("Minnesota")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://mn.gov/dhs/people-we-serve/children-and-families/services/child-protection/contact-us/index.jsp")));
                                } else if (spinner.getSelectedItem().toString().equals("North Carolina")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://docs.google.com/gview?embedded=true&url=http://www2.ncdhhs.gov/dss/local/docs/directory.pdf")));
                                } else if (spinner.getSelectedItem().toString().equals("North Dakota")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://www.nd.gov/dhs/locations/countysocialserv/index.html")));
                                } else if (spinner.getSelectedItem().toString().equals("South Carolina")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://dss.sc.gov/content/about/counties/index.aspx")));
                                } else if (spinner.getSelectedItem().toString().equals("Wisconsin")) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://dcf.wi.gov/children/CPS/cpswimap.htm?ref=hp")));
                                } else if (spinner.getSelectedItem().toString().equals(numStates[k])) {
                                    String currentNumber = stateNums[j];
                                    //clean number string
                                    currentNumber = currentNumber.replaceAll("[^a-zA-Z0-9]","");
                                    String uri = "tel:" + currentNumber;

                                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));
                                    startActivity(callIntent);
                                }
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
        getMenuInflater().inflate(R.menu.menu_report, menu);
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
