package com.example.tarrito.aplicacion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class thirdactivity extends AppCompatActivity {

    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imageButtonPhone;
    private ImageButton imageButtonWeb;
    private ImageButton imageButtonCamera;
    private final int PHONE_CALL_CODE = 100;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);

        editTextPhone =(EditText) findViewById(R.id.editText2);
        editTextWeb = (EditText) findViewById(R.id.editText3);
        imageButtonPhone = (ImageButton) findViewById(R.id.imageButton);
        imageButtonWeb = (ImageButton) findViewById(R.id.imageButton2);
        imageButtonCamera = (ImageButton) findViewById(R.id.imageButton3);

        imageButtonPhone.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                String NroTelefono = editTextPhone.getText().toString();
                if(NroTelefono !=null){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                    }else{
                        olderVersions(NroTelefono);
                    }
                }
            }

            private void olderVersions(String NroTelefono){
                Intent intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("Tel:" + NroTelefono));
                if (verificarPermiso(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentLlamar);
                }else{
                    Toast.makeText(thirdactivity.this, "Sin permiso para llamar", Toast.LENGTH_LONG).show();
                }
            }

            private void NewerVersions(){

            }
        });

        imageButtonCamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intentCamera);
            }
        });
    }

    public void onRequestPermissionsResult(int requesCode, String[] permissions, int[] grantResult){
        switch(requesCode){
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResult[0];
                if(permission.equals(Manifest.permission.CALL_PHONE)){
                    if(result == PackageManager.PERMISSION_GRANTED){
                        String NroTelefono = editTextPhone.getText().toString();
                        Intent intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+NroTelefono));
                        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            return;
                        }
                        startActivity(intentLlamar);
                    } else {
                        Toast.makeText(thirdactivity.this,"sin permiso para llamadas", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requesCode, permissions, grantResult);
                break;
        }
        super.onRequestPermissionsResult(requesCode, permissions, grantResult);
    }

    private boolean verificarPermiso(String permission){
        int resultado = checkCallingOrSelfPermission(permission);
        return resultado == PackageManager.PERMISSION_GRANTED;
    }
}
