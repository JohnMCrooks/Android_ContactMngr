package com.crooks.contactsandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.name;
import static android.R.attr.text;

public class DisplayContact extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<Contact> contact;

    TextView textView3;
    String name1;
    String phone;
    TextView textView;
    Button callButton;
    Button textButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        callButton = (Button) findViewById(R.id.callButton);
        textButton = (Button) findViewById(R.id.textButton);

        callButton.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name1 = extras.getString("name");
            phone = extras.getString("phone");
        }
        textView.setText(name1);
        textView3.setText(phone);

    }

    //Found the Action_Dial usage Via Android https://developer.android.com
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String temp ="tel:" + phone;
        intent.setData(Uri.parse(temp));

        startActivity(intent);
    }
}
