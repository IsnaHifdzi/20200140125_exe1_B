package com.example.exerices1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DuaActivity extends AppCompatActivity {

    Button btnRegis;

    EditText edNama, edEmail, edPass, edRepass;
    String nama, email, password, rPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_kedua);

        btnRegis = findViewById(R.id.bRegister);
        edNama = findViewById(R.id.txNama);
        edEmail = findViewById(R.id.txEmail);
        edPass = findViewById(R.id.regPass);
        edRepass = findViewById(R.id.regRepass);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edNama.getText().toString();
                email = edEmail.getText().toString();
                password = edPass.getText().toString();
                rPassword = edRepass.getText().toString();

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(email)
                        && TextUtils.isEmpty(password) && TextUtils.isEmpty(rPassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua kolom diatas",Toast.LENGTH_LONG);
                    t.show();
                    edNama.setError("Nama harus diisi");
                    edEmail.setError("Email harus diisi");
                }
                else if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(email)
                        || TextUtils.isEmpty(password) || TextUtils.isEmpty(rPassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua data!",Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (!password.equals(rPassword)){
                        Toast t = Toast.makeText(getApplicationContext(),"Password harus sama!",Toast.LENGTH_LONG);
                        t.show();
                        edRepass.setError("Password tidak cocok");
                    }
                    else {
                        Bundle b = new Bundle();

                        b.putString("name", nama.trim());
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                        t.show();
                        Intent i = new Intent(getApplicationContext(), TigaActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            }
        });
    }
}

