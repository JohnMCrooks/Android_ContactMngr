package com.crooks.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.name;
import static android.R.attr.text;

public class DisplayContact extends AppCompatActivity {

    ArrayAdapter<Contact> contact;

    TextView textView3;
    String name;
    String phone;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            phone = extras.getString("phone");
        }
        textView.setText(name);
        textView3.setText(phone);

    }
}
