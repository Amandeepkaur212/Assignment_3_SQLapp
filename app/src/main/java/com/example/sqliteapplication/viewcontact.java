package com.example.sqliteapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import android.widget.ListView;

import android.widget.TextView;

import java.util.ArrayList;

public class viewcontact extends AppCompatActivity {

    ListView listview;
    TextView heading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

            heading = findViewById(R.id.view_heading);
            listview = (ListView) findViewById(R.id.list_view);
            ArrayList<Model> contactsList = getAllContactsList();
        if (contactsList.size() == 0)
            heading.setText("No data!");
        else {
            ContactAdapter contactAdapter = new ContactAdapter(this, contactsList);
            if(listview==null)
                Log.d("Error","NULL");
            listview.setAdapter(contactAdapter);

    }
}

    public ArrayList<Model> getAllContactsList() {
        Cursor res = new DBHelper(this).getdata();
        ArrayList<Model> contactsList = new ArrayList<>();

        while(res.moveToNext()){
            Model contacts = new Model();
            contacts.setName(res.getString(0));
            contacts.setContact(res.getString(1));
            contacts.setDob(res.getString(2));
            contactsList.add(contacts);
        }
        return contactsList;
    }

    }