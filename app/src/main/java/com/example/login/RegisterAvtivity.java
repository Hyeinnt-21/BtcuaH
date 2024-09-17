package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_avtivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView signinn= findViewById(R.id.signinn);
        TextView inputname = findViewById(R.id.inputname);
        TextView inputemail = findViewById(R.id.inputemail);
        TextView inputpw = findViewById(R.id.inputpw);
        TextView inputcfpw = findViewById(R.id.inputcfpw);
        TextView resultValue= findViewById(R.id.resultValue);

        signinn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterAvtivity.this, MainActivity.class));
                final String username = inputname.getText().toString();
                final String email = inputemail.getText().toString();
                final String password = inputpw.getText().toString();
                final String cfpassword = inputcfpw.getText().toString();
                final String valueString = "Account\nUsername: " + username + "\nPassword: " + password +  "\nEmail: "+ email;

                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    resultValue.setText("Error!!!");
                } else {
                    if (password.equals(cfpassword)) {
                        resultValue.setText(valueString);
                    }
                    else {
                        resultValue.setText("Confirm password is not match");
                    }
                }

                inputname.setText("");
                inputpw.setText("");
                inputemail.setText("");
                inputcfpw.setText("");
            }
        });
        Button chuyentrangg= findViewById(R.id.trangsignin);
        chuyentrangg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegisterAvtivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}