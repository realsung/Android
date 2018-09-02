package bookshared.android.kr.bookshared;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class LogoActivity extends AppCompatActivity {
    LinearLayout llBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        llBack = (LinearLayout)findViewById(R.id.llBack);
        llBack.setBackgroundColor(Color.parseColor("#013064"));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        // 액션 바 숨김
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }
}
