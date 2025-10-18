package com.example.KTGK;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOther;
    CheckBox cbSport, cbTravel, cbMusic;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bind views
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);
        cbSport = findViewById(R.id.cbSport);
        cbTravel = findViewById(R.id.cbTravel);
        cbMusic = findViewById(R.id.cbMusic);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String ageStr = edtAge.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hãy nhập họ và tên", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ageStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hãy nhập tuổi", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }


                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                String gender = "Không rõ";
                if (selectedGenderId == R.id.rbMale) gender = "Nam";
                else if (selectedGenderId == R.id.rbFemale) gender = "Nữ";
                else if (selectedGenderId == R.id.rbOther) gender = "Khác";


                StringBuilder hobbies = new StringBuilder();
                if (cbSport.isChecked()) hobbies.append("Thể thao, ");
                if (cbTravel.isChecked()) hobbies.append("Du lịch, ");
                if (cbMusic.isChecked()) hobbies.append("Âm nhạc, ");
                String hobbyStr = hobbies.length() > 0 ? hobbies.substring(0, hobbies.length() - 2) : "Không có";


                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("EXTRA_NAME", name);
                intent.putExtra("EXTRA_AGE", age);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_HOBBIES", hobbyStr);
                startActivity(intent);
            }
        });
    }
}
