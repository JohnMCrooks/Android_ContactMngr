package com.crooks.contactsandroid;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

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
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String contact = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        Contact c = new Contact(contact, phone);
        contacts.add(c);
        nameField.setText("");
        phoneField.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact contactItem = contacts.getItem(position);
        contacts.remove(contactItem);
        Toast.makeText(this, "Contact Deleted forever", Toast.LENGTH_SHORT).show();
        return true;
    }
}
