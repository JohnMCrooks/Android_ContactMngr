package com.crooks.contactsandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ArrayAdapter<Contact> contacts;

    Button addButton;
    EditText nameField;
    EditText phoneField;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        addButton = (Button) findViewById(R.id.addButton);
        nameField = (EditText) findViewById(R.id.nameField);
        phoneField = (EditText) findViewById(R.id.phoneField);

        contacts = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);


        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);   //Long click to delete contact
        listView.setOnItemClickListener(this);       //short click to view contact Details
    }

    @Override
    public void onClick(View v) {


        String contact = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        if (phone.length()!= 10){
            //TODO add validation
        }
        Contact c = new Contact(contact, phone);
        contacts.add(c);
        nameField.setText("");
        phoneField.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        new AlertDialog.Builder(this)           // Confirmation Box via http://stackoverflow.com/questions/2257963/how-to-show-a-dialog-to-confirm-that-the-user-wishes-to-exit-an-android-activity
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Delete Contact?")
                .setMessage("Are you sure you want to delete this contact?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contact contactItem = contacts.getItem( position);
                        contacts.remove(contactItem);
                    }
                })
                .setNegativeButton("No", null)
                .show();

        return true;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Contact test = (Contact) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, DisplayContact.class);
        intent.putExtra("name", (String) test.getName());
        intent.putExtra("phone",(String) test.getPhone());
        startActivity(intent);
    }
}
