package com.example.hw01cst438;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hw01cst438.model.User;
import com.example.hw01cst438.model.UserDao;
import com.example.hw01cst438.model.UserRoom;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //UserDao dao = UserRoom.getUserRoom(this).dao();

    //UserRoom db = Room.databaseBuilder(getApplicationContext(), UserRoom.class, "UserDB").build();



    TextView usrn;
    TextView pwrd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserRoom.getUserRoom(this).loadData(this);
        final UserDao dao = UserRoom.getUserRoom(this).dao();

        Button login = findViewById(R.id.logIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<User> users = dao.getAllUsers();
                usrn = findViewById(R.id.UserN);
                pwrd = findViewById(R.id.Pwrd);
                boolean pass = false;
                boolean userRight = false;
                boolean passRight = false;

                final String username = usrn.getText().toString();
                final String password = pwrd.getText().toString();


                /*String preuser = new String("din");
                String prepass = new String("baby");

                if(username.equals(preuser) && password.equals(prepass)){
                    pass = true;
                }*/



                for(int i = 0; i < users.size(); i++){
                    if(username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())){
                        pass = true;
                        break;
                    }
                    if(username.equals(users.get(i).getUsername())){
                        //password not right
                        if(!password.equals(users.get(i).getPassword())){
                            passRight = true;
                            userRight = false;
                            break;

                        }
                    } else if(password.equals(users.get(i).getPassword())){
                        //username wrong
                        if(!username.equals(users.get(i).getUsername())){
                            userRight = true;
                            passRight = false;
                            break;
                        }
                    } else if(!password.equals(users.get(i).getPassword()) && !username.equals(users.get(i).getUsername())){
                        //both wrong
                        passRight = true;
                        userRight = true;
                    }
                }

                String u = username;
                String p = password;

                if(pass == true){
                    Intent intent = new Intent(MainActivity.this, LandingActivity.class);
                    Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else if(pass == false){
                    if(userRight && !passRight){
                        Toast.makeText(MainActivity.this, "username is incorrect", Toast.LENGTH_LONG).show();
                        usrn.setError("Invalid user name");
                    }else if(passRight && !userRight){
                        Toast.makeText(MainActivity.this, "password is incorrect", Toast.LENGTH_LONG).show();
                        pwrd.setError("Invlid password");
                    }else if(userRight && passRight){
                        Toast.makeText(MainActivity.this, "both username and password are incorrect", Toast.LENGTH_LONG).show();
                        usrn.setError("Invalid user name");
                        pwrd.setError("Invlid password");
                    }

                }
            }
        });


    }



}
