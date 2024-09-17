package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText username= findViewById(R.id.inputname);
        EditText pass=findViewById(R.id.inputpw);
        Button btn= findViewById(R.id.signinn);
        TextView resultValue= findViewById(R.id.resultvalue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username_string = username.getText().toString();
                final String password_string = pass.getText().toString();
                final String valueString = "Account\nUsername: " + username_string + "\nPassword: " + password_string;

                if (!username_string.isEmpty() && !password_string.isEmpty()) {
                    resultValue.setText(valueString);
                } else {
                    resultValue.setText("Not value");
                }

                username.setText("");
                pass.setText("");
            }
        });
        Button chuyentrang= findViewById(R.id.Trangdki);
        chuyentrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, RegisterAvtivity.class);
                startActivity(intent);
            }
        });

    }
}