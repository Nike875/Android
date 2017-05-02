package com.example.maria.mysqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.mysqlite.db.dao.UserDao;
import com.example.maria.mysqlite.db.service.UserService;
import com.example.maria.mysqlite.domain.User;

/**
 * Created by maria on 01/05/2017.
 */

public class UserEditor  extends AppCompatActivity {
    private EditText eddFirstName,eddLastName,eddAge, eddNotes;
    private Button btnReturn, btnDelete,btnSave1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_editor);
        inity();
    }
    private void inity() {
        eddFirstName = (EditText) findViewById(R.id.txt_first_name1);
        eddLastName = (EditText) findViewById(R.id.txt_last_name1);
        eddAge = (EditText) findViewById(R.id.txt_age1);
        eddNotes = (EditText) findViewById(R.id.txt_notes1);
        btnReturn = (Button) findViewById(R.id.btn_returne);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserEditor.this, UserListActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserEditor.this, UserListActivity.class);
                startActivity(intent);
            }
        });
        btnSave1 =(Button) findViewById(R.id.btn_save1);
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData1();
            }
        });
    }
    private void saveData1(){
        if(eddFirstName.getText() != null && eddFirstName.getText().length()>0
                && eddLastName.getText() !=null && eddLastName.getText().length()>0
                && eddAge.getText() != null && eddAge.getText().length()>0){
            User user = new User(eddFirstName.getText().toString(),
                    eddLastName.getText().toString(),
                    Integer.parseInt(eddAge.getText().toString()),
                    eddNotes.getText().toString());
            new UserService(this).save(user);
            Intent intent = new Intent(UserEditor.this, UserListActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Please in all field", Toast.LENGTH_SHORT).show();
        }
    }

}

