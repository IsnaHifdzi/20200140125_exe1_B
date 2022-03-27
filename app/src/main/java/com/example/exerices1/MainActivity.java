package com.example.exerices1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    Button btnsign;
    TextView txRegister;
    EditText edNama, edPassword;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNama = findViewById(R.id.user1);
        edPassword = findViewById(R.id.pass1);
        txRegister = findViewById(R.id.tRegister);
        btnsign = findViewById(R.id.btsign);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edNama.getText().toString();
                password = edPassword.getText().toString();

                Bundle b = new Bundle();

                b.putString("name", nama.trim());

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(password)){
                    edNama.setError("Nama harus isi");

                    Toast t = Toast.makeText(getApplicationContext(), "Masukkan Nama dan Password Anda", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (TextUtils.isEmpty(password)){
                    Toast t = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                    t.show();
                    edPassword.setError("Password harus isi");

                }
                else if (TextUtils.isEmpty(nama)){
                    edNama.setError("Nama harus isi");
                }
                else {
                    if (nama.equals("Pascal") && password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT);
                        t.show();

                        Intent log = new Intent(getApplicationContext(), TigaActivity.class);
                        log.putExtras(b);
                        startActivity(log);
                    }
                    else if (nama.equals("Pascal") && !password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Password Anda Salah", Toast.LENGTH_SHORT);
                        t.show() ;
                    }
                    else if(!nama.equals("Pascal") && password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Nama Anda Salah", Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Toast t = Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });

        txRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DuaActivity.class);
                startActivity(i);
            }
        });
    }
}