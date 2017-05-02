package com.example.maria.mysqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.mysqlite.db.service.UserService;
import com.example.maria.mysqlite.domain.User;

public class MainActivity extends AppCompatActivity {

    private EditText edFirstName,edLastName,edAge, edNotes;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        edFirstName = (EditText) findViewById(R.id.txt_first_name);
        edLastName = (EditText) findViewById(R.id.txt_last_name);
        edAge = (EditText) findViewById(R.id.txt_age);
        edNotes = (EditText) findViewById(R.id.txt_notes);
        btnSave = (Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Intent intent = new Intent(MainActivity.this, UserListActivity.class);
                startActivity(intent);

            }
        });
    }

    private void saveData(){
        if(edFirstName.getText() != null && edFirstName.getText().length()>0
            && edLastName.getText() !=null && edLastName.getText().length()>0
                && edAge.getText() != null && edAge.getText().length()>0){
            User user = new User(edFirstName.getText().toString(),
                    edLastName.getText().toString(),
                    Integer.parseInt(edAge.getText().toString()),
                            edNotes.getText().toString());
            new UserService(this).save(user);
            Intent intent = new Intent(MainActivity.this, UserListActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Please in all field", Toast.LENGTH_SHORT).show();
        }
    }

}
