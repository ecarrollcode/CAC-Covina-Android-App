package ecarroll.cachcapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;


public class SMSActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final EditText editMessage = (EditText) findViewById(R.id.editMessage);

        editMessage.setText(ShareHotlineActivity.message);

        Button btnSendSMS = (Button)(findViewById(R.id.btnSendSMS));

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage();
            }
        });

    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");

        final EditText editPhoneNum = (EditText) findViewById(R.id.editPhoneNum);

        String phoneNo = editPhoneNum.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, ShareHotlineActivity.message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
