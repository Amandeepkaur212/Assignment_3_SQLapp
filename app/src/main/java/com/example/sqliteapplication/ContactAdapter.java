package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import android.widget.TextView;


import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Model> {

    private ArrayList<Model> contacts;

    public ContactAdapter(Context context, ArrayList<Model> contacts) {
        super(context, R.layout.row);
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }


    @Override
    public View getView(int position, View newview, ViewGroup  parent) {

        Model contactModel = contacts.get(position);

            newview = LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);

            TextView name = (TextView) newview.findViewById((R.id.txtName));
            TextView contact = (TextView) newview.findViewById((R.id.txtContact));
            TextView Dob = (TextView) newview.findViewById((R.id.txtDOB));

        name.setText(contactModel.getName());
        contact.setText(contactModel.getContact());
        Dob.setText(contactModel.getDob());


        return newview;
    }
}