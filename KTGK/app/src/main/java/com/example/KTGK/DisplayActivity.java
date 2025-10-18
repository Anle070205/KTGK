package com.example.KTGK;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.KTGK.R;

public class DisplayActivity extends AppCompatActivity {
    TextView tvName, tvAge, tvGender, tvHobbies;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvHobbies = findViewById(R.id.tvHobbies);
        btnEdit = findViewById(R.id.btnEdit);


        String name = getIntent().getStringExtra("EXTRA_NAME");
        int age = getIntent().getIntExtra("EXTRA_AGE", -1);
        String gender = getIntent().getStringExtra("EXTRA_GENDER");
        String hobbies = getIntent().getStringExtra("EXTRA_HOBBIES");

        tvName.setText(name != null ? name : "Không có");
        tvAge.setText(age >= 0 ? String.valueOf(age) : "Không có");
        tvGender.setText(gender != null ? gender : "Không có");
        tvHobbies.setText(hobbies != null ? hobbies : "Không có");

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // quay về màn hình nhập để sửa
            }
        });
    }
}
