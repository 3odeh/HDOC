package com.example.doch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    final public  static  String DOCTOR_ID = "id";

    private ListView doctorLV;
    private TextView appointmentNumberTextView;
    private Button showAllPppointmentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        doctorLV = findViewById(R.id.doctor_lv);
        appointmentNumberTextView = findViewById(R.id.appointment_number);
        showAllPppointmentsButton = findViewById(R.id.show_all_appointments_btn);

        List<Doctor> doctors= DataSource.getAllDoctors();

        DoctorAdapter doctorAdapter = new DoctorAdapter(this,doctors);
        doctorLV.setAdapter(doctorAdapter);

        doctorLV.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(HomeActivity.this, DoctorBookActivity.class);
            intent.putExtra(DOCTOR_ID, position);

            startActivity(intent);
        });

        showAllPppointmentsButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DisplayAppointmentsActivity.class);

            startActivity(intent);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        appointmentNumberTextView.setText("You have "+ DataSource.addAppointmentsCount() +" appointments");
    }
}