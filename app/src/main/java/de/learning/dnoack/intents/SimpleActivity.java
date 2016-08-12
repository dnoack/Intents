package de.learning.dnoack.intents;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;


public class SimpleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        ArrayList<ContentValues> data = new ArrayList<ContentValues>();

        //first new number
        ContentValues v1 =new ContentValues();
        v1.put(ContactsContract.Contacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        v1.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "123");
        v1.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);
        data.add(v1);

        //second new number
        ContentValues v2 =new ContentValues();
        v2.put(ContactsContract.Contacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        v2.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "456");
        v2.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);
        data.add(v2);

        Intent in = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);

        in.putExtra("finishActivityOnSaveCompleted", true);
        in.putExtra(ContactsContract.Intents.Insert.NAME, "Max Mustermann");
        in.putExtra(ContactsContract.Intents.Insert.PHONE, "+49 (123) 45 67 89");
        in.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);

        in.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, data);

        startActivity(in);

    }

}
