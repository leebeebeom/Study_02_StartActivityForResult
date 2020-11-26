package com.beebeom.a02_startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //이 액티비티를 실행한 인텐트 받아오기.
        Intent intent = getIntent();

        //데이터 받아오기
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");

        TextView textView = findViewById(R.id.text_result);
        textView.setText("이름 : "+name+", 나이 : "+age);

        //버튼을 클릭하면 대괄호 안에 코드들이 순차적으로 실행된다.
        findViewById(R.id.btn_send_result).setOnClickListener(v -> {
            //이 인텐트를 따로 인자를 설정해주지 않아도
            // setResult 로 인해 자동으로 실행한 액티비로 돌아감.
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", textView.getText().toString());

            //리설트 코드는 내 마음대로.
            // RESULT_CANCELED 로 입력하고 메인액티비티에서 어떠한 액션을 만들어줘도 됨.
            setResult(RESULT_OK, resultIntent);

            //액티비티 종료 코드
            finish();
        });
    }
}