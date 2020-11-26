package com.beebeom.a02_startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.et_name);
        EditText editTextAge = findViewById(R.id.et_age);

        findViewById(R.id.btn_send).setOnClickListener(v -> {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("name", editTextName.getText().toString());
            intent.putExtra("age", editTextAge.getText().toString());

            //startActivityFooResult 를 하면
            //결과를 받아올 수 있음
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    //결과가 넘어오면 이 메소드에서 처리한다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //인자값으로 requestCode, resultCode, intent 가 넘어온다.
        //if 문으로 어떤 리퀘스트 코드로 실행한 결과인지 따로 설정해줄 수 있음.
        //만약 실행한 인텐트가 많다면 switch 문으로 따로 따로 액션을 설정할 수 있다.
        if(requestCode==REQUEST_CODE && resultCode ==RESULT_OK){

            //결과 데이터 받기
            String result = data.getStringExtra("result");
            Toast.makeText(this, result , Toast.LENGTH_SHORT).show();
        }
    }
}