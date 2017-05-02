package com.example.maria.mysqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.maria.mysqlite.adaptor.UserBaseAdapter;
import com.example.maria.mysqlite.db.service.UserService;
import com.example.maria.mysqlite.domain.User;

import java.util.List;

/**
 * Created by maria on 30/04/2017.
 */

public class UserListActivity extends AppCompatActivity {
    private ListView lvUsers;
    private Button btnCreate;
    private Button btnEdit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        init();
        updateAdapter();
    }
    private void init(){
        lvUsers = (ListView)findViewById(R.id.lv_users);
        btnEdit = (Button)findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListActivity.this, UserEditor.class);
                startActivity(intent);

            }
        });
        btnCreate = (Button)findViewById(R.id.btn_create_user);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
    private void updateAdapter(){
        List<User> users = new UserService(this).getAll();
        if(users!= null){
            UserBaseAdapter userBaseAdapter = new UserBaseAdapter(this, users);
            lvUsers.setAdapter(userBaseAdapter);
        }
    }
}
