package com.example.doch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DoctorBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView doctorImage = findViewById(R.id.book_doctor_profile_image);
        TextView doctorName = findViewById(R.id.book_doctor_name);
        TextView doctorSpecialty = findViewById(R.id.book_doctor_specialty);
        TextView doctorLocation = findViewById(R.id.book_doctor_location);
        TextView doctorRating = findViewById(R.id.book_doctor_rating);

        ImageButton imageButton = findViewById(R.id.back_btn);
        Button bookAppointmentBtn = findViewById(R.id.book_btn);

        Intent intent = getIntent();
        int id = intent.getIntExtra(HomeActivity.DOCTOR_ID, 0);
        Doctor selectedDoctor =  DataSource.getDoctor(id);

        doctorImage.setImageResource(selectedDoctor.getImageResourceId());
        doctorName.setText(selectedDoctor.getName());
        doctorSpecialty.setText(selectedDoctor.getSpecialty());
        doctorLocation.setText(selectedDoctor.getPlace());
        doctorRating.setText(selectedDoctor.getRating()+"");

        imageButton.setOnClickListener(v -> {
            finish();
        });

        bookAppointmentBtn.setOnClickListener(v -> {
            Intent newIntent = new Intent( DoctorBookActivity.this, BookAppointmentActivity.class);
            newIntent.putExtra(HomeActivity.DOCTOR_ID,id);
            startActivity(newIntent);
        });
    }
}