package com.example.tarrito.aplicacion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Switch swt;
    private CheckBox cbx;
    private Button btn2;
    private final String Saludo = "Hola a todos desde activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.buttonMain);
        btn2 = (Button) findViewById(R.id.button);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondactivity.class);
                intent.putExtra("sl2", Saludo);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "clock en el boton", Toast.LENGTH_SHORT).show();
            }
        });

        cbx = (CheckBox) findViewById(R.id.checkMain);
        cbx.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clock en el check", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void miMetodo(View v){
        Toast.makeText(MainActivity.this, "click en el boton", Toast.LENGTH_SHORT).show();
    }
}
