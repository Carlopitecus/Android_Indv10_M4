package com.example.individual10_m4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton_1;
    EditText url_sitio;


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
        boton_1 = findViewById(R.id.btn_1);
        url_sitio = findViewById(R.id.url_ingreso);

        boton_1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_1){
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            String mandar_url = url_sitio.getText().toString();
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("LINK",mandar_url);
            startActivity(intent);
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    public void irSegundaPantalla(View view){

        String mandar_url = url_sitio.getText().toString();
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("LINK",mandar_url);
        startActivity(intent);
    }
}