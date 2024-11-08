package com.example.doch;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayAppointmentsActivity extends AppCompatActivity {

    private ImageButton backImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_appointments);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView appointmentListView= findViewById(R.id.appointment_list_view);
        AppointmentAdapter appointmentAdapter = new AppointmentAdapter(this, DataSource.getAllAppointments());
        appointmentListView.setAdapter(appointmentAdapter);

        backImageButton = findViewById(R.id.appointments_display_back_btn);
        backImageButton.setOnClickListener(v -> {
            finish();
        });
    }
}