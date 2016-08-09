package de.learning.dnoack.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;


public class SimpleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        Intent in = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);

        in.putExtra("finishActivityOnSaveCompleted", true);
        in.putExtra(ContactsContract.Intents.Insert.NAME, "Max Mustermann");
        in.putExtra(ContactsContract.Intents.Insert.PHONE, "+49 (123) 45 67 89");
        in.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        startActivity(in);

    }

}
