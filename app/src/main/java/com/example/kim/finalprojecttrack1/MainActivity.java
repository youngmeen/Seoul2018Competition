package com.example.kim.finalprojecttrack1;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kim.finalprojecttrack1.Fragment.Instruction;
import com.example.kim.finalprojecttrack1.chat.MessageActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    AlertDialog.Builder alert_ex;

    public static final String[] MANDATORY_PERMISSIONS = {
            "android.permission.CAMERA",
            "android.permission.CHANGE_NETWORK_STATE",
            "android.permission.ACCESS_NETWORK_STATE",
            "android.permission.CHANGE_WIFI_STATE",
            "android.permission.ACCESS_WIFI_STATE",
            "android.permission.RECORD_AUDIO",
            "android.permission.INTERNET",
            "android.permission.BLUETOOTH",
            "android.permission.BLUETOOTH_ADMIN",
            "android.permission.BROADCAST_STICKY",
            "android.permission.READ_PHONE_STATE",
            "android.permission.MODIFY_AUDIO_SETTINGS",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 24) {

            checkPermission(MANDATORY_PERMISSIONS);
        }//권한 주기
    }


    @TargetApi(24)
    private void checkPermission(String[] permissions) {
        requestPermissions(permissions, 100);
    }


    public void f1(View view) {
        intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra("number", R.id.navigation_emrgency);
        startActivity(intent);
        finish();
    }

    public void f2(View view) {
        intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra("number", R.id.navigation_shelter);
        startActivity(intent);
        finish();
    }

    public void f3(View view) {
        intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra("number", R.id.navigation_message);
        startActivity(intent);
        finish();
    }

    public void f4(View view) {
        intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra("number", R.id.navigation_setting);
        startActivity(intent);
        finish();
    }

    public void f5(View view) {
        show();
    }

    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("긴급모드 입니다");
        builder.setMessage(" 누르시겠습니까?");
        builder.setPositiveButton("예",
                (dialog, which) -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        builder.setNegativeButton("아니오",
                (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "아니오를 선택했습니다.", Toast.LENGTH_LONG).show();
                    return;
                });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("정말로 종료하시겠습니다.");

        alert_ex.setPositiveButton("취소", (dialogInterface, i) -> {

        });
        alert_ex.setNegativeButton("종료", (dialogInterface, i) -> {
            FirebaseAuth.getInstance().signOut();
            finishAffinity();
        });
        AlertDialog alert = alert_ex.create();
        alert.show();
    }
}

