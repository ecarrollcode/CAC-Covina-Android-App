package ecarroll.cachcapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ShareHotlineActivity extends ActionBarActivity {

    // initialize spinner and adapter
    Spinner spinner2;
    ArrayAdapter<CharSequence> adapter2;

    public static String message;

    // arrays of state names and numbers
    String[] numStates = {"Alabama", "Alaska", "Arizona", "Arkansas", "Colorado", "Connecticut",
            "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho",
            "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Massachusetts", "Michigan", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
            "Puerto Rico", "Rhode Island", "South Dakota", "Tennessee", "Texas", "Utah",
            "Vermont", "Virginia", "Washington", "West Virginia", "Wyoming"};

    String[] urlStates = {"California", "Maryland", "Minnesota", "North Carolina", "North Dakota",
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
        setContentView(R.layout.activity_share_hotline);

        // set spinner and adapter
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.state_names, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        // set default spinner selection to California at position 4
        spinner2.setSelection(4);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // button for sending sms
                final Button btnSendSMS = (Button) (findViewById(R.id.btnSendSMS));

                // handle button text
                for (int i = 0; i < urlStates.length; i++) {
                    for (int n = 0; n < stateNums.length; n++) {
                        if (parent.getItemAtPosition(position).equals(urlStates[i])) {
                            btnSendSMS.setText("Send Hotline List");
                        } else if (parent.getItemAtPosition(position).equals(numStates[n])) {
                            btnSendSMS.setText("Send Hotline");
                        } else if (parent.getItemAtPosition(position).equals("California")) {
                            btnSendSMS.setText("Choose A County");
                        }
                    }
                }

                // handle button behavior
                btnSendSMS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int k = 0; k < numStates.length; k++) {
                            for (int j = 0; j < stateNums.length; j++) {

                                /*
                                stupid, seemingly unsolvable error when changing message variable outside of conditionals;
                                somehow, putting it inside the conditionals made it work
                                */

                                if (spinner2.getSelectedItem().toString().equals("Maryland")) {
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                    message += "Maryland: http://www.dhr.state.md.us/blog/?page_id=4631";
                                } else if (spinner2.getSelectedItem().toString().equals("Minnesota")) {
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                    message += "Minnesota: http://mn.gov/dhs/people-we-serve/children-and-families/services/child-protection/contact-us/index.jsp";
                                } else if (spinner2.getSelectedItem().toString().equals("North Carolina")) {
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                    message += "North Carolina: http://docs.google.com/gview?embedded=true&url=http://www2.ncdhhs.gov/dss/local/docs/directory.pdf";
                                } else if (spinner2.getSelectedItem().toString().equals("North Dakota")) {
                                    message += "North Dakota: http://www.nd.gov/dhs/locations/countysocialserv/index.html";
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                } else if (spinner2.getSelectedItem().toString().equals("South Carolina")) {
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                    message += "South Carolina: https://dss.sc.gov/content/about/counties/index.aspx";
                                } else if (spinner2.getSelectedItem().toString().equals("Wisconsin")) {
                                    message = "Follow this link for a list of hotlines to report child abuse in the state of ";
                                    message += "Wisconsin: http://dcf.wi.gov/children/CPS/cpswimap.htm?ref=hp";
                                } else if (spinner2.getSelectedItem().toString().equals("District of Columbia")) {
                                    message = "Call this number to report child abuse in the Disctrict of Columbia: (202) 671-7233";
                                } else if (spinner2.getSelectedItem().toString().equals("Puerto Rico")) {
                                    message = "Call this number to report child abuse in Puerto Rico: (800) 981-8333";
                                } else if (spinner2.getSelectedItem().toString().equals(numStates[k])) {
                                    message = "Call this number to report child abuse in the state of " + numStates[k] + ": " + stateNums[k];
                                }
                            }
                        }

                        if (spinner2.getSelectedItem().toString().equals("California")) {
                            Intent myIntent = new Intent(view.getContext(), CaliforniaShareHotlineActivity.class);
                            startActivityForResult(myIntent, 0);
                        } else {
                            Intent myIntent = new Intent(view.getContext(), SMSActivity.class);
                            startActivityForResult(myIntent, 0);
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
        getMenuInflater().inflate(R.menu.menu_share_hotline, menu);
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
