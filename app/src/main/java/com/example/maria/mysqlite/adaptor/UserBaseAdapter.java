package com.example.maria.mysqlite.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maria.mysqlite.R;
import com.example.maria.mysqlite.domain.User;

import java.util.List;

/**
 * Created by maria on 30/04/2017.
 */

public class UserBaseAdapter extends BaseAdapter {
    private class ViewHolder{
        TextView txtFirstName,txtLastName,txtAge,txtNotes;
        private ViewHolder(View view){
            txtFirstName = (TextView)view.findViewById(R.id.txt_first_name_adapter);
            txtLastName = (TextView)view.findViewById(R.id.txt_last_name_adapter);
            txtAge = (TextView)view.findViewById(R.id.txt_age_adapter);
            txtNotes = (TextView)view.findViewById(R.id.txt_notes_adapter);
        }
    }
    private List<User>users;
    private LayoutInflater inflater;

    public UserBaseAdapter(Context context, List<User>users){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.users = users;
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.user_base_adapter, parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        User user = getItem(position);
        if(user != null){
            holder.txtFirstName.setText(user.getFirstName());
            holder.txtLastName.setText(user.getLastName());
            holder.txtAge.setText(String.valueOf(user.getAge()));
            holder.txtNotes.setText(user.getNotes());
        }
        return view;
    }
}
