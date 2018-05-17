package io.github.mpao.show_joke_lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = this.getIntent().getStringExtra("joke");
        TextView text = findViewById(R.id.text);
        text.setText(joke);

    }

}
