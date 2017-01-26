package com.kagssoft.cobonat.Layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kagssoft.cobonat.R;

public class Login extends AppCompatActivity {
    private static Button button_reg, button_log, button_skip;
    private static EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RegisterButton();
        LoginButton();
        Skip() ;
    }

    public void RegisterButton() {
        button_reg = (Button) findViewById(R.id.button_reg);
        button_reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.kagssoft.cobonat.Layouts.Registration");
                        startActivity(intent);
                    }
                }
        );
    }

    public void Skip() {
        button_skip = (Button) findViewById(R.id.button_skip);
        button_skip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.kagssoft.cobonat.Layouts.Main_wedgit");
                        startActivity(intent);
                    }
                }
        );
    }

    public void LoginButton() {
        username = (EditText) findViewById(R.id.Name_Text);
        password = (EditText) findViewById(R.id.pass_text);
        button_log = (Button) findViewById(R.id.button_log);

        button_log.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("admin") &&
                                password.getText().toString().equals("admin")) {
                            Toast.makeText(Login.this, "Sucsess",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.kagssoft.cobonat.Layouts.Main_wedgit");
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
}
