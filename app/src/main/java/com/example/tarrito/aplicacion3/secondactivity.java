package com.example.tarrito.aplicacion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {
    private View btn3;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        texto = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        bundle = null;
        if(bundle != null){
            String saludo = bundle.getString("saludo");
            Toast.makeText(secondactivity.this, saludo, Toast.LENGTH_LONG).show();
            texto.setText(saludo);
        } else{
            Toast.makeText(secondactivity.this,"esta vacio", Toast.LENGTH_LONG).show();
        }

        setContentView(R.layout.activity_secondactivity);

        btn3 = (Button) findViewById(R.id.button2);
        btn3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(secondactivity.this,thirdactivity.class);
                startActivity(intent);
            }
        });
    }
}
