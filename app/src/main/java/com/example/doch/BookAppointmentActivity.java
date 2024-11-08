package com.example.doch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class BookAppointmentActivity extends AppCompatActivity {

    private ImageView doctorImage;
    private ImageButton backImageButton;
    private TextView doctorNameTextView;
    private Spinner timeSlotSpinner;
    private RadioGroup consultationTypeGroup;
    private CheckBox medicalReportCheckBox;
    private CheckBox labTestsCheckBox;
    private EditText patientDescriptionEditText;
    private Button bookAppointmentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appointment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backImageButton = findViewById(R.id.appointment_back_btn);
        doctorImage = findViewById(R.id.appointment_doctor_photo);
        doctorNameTextView = findViewById(R.id.appointment_doctor_name);
        timeSlotSpinner = findViewById(R.id.appointment_time_slot_spinner);
        consultationTypeGroup = findViewById(R.id.appointment_consultation_type_group);
        medicalReportCheckBox = findViewById(R.id.appointment_service_medical_report);
        labTestsCheckBox = findViewById(R.id.appointment_service_lab_tests);
        patientDescriptionEditText = findViewById(R.id.appointment_patient_description);
        bookAppointmentButton = findViewById(R.id.appointment_book_btn);

        Intent intent = getIntent();
        int id = intent.getIntExtra(HomeActivity.DOCTOR_ID, 0);
        Doctor selectedDoctor = DataSource.getDoctor(id);

        doctorImage.setImageResource(selectedDoctor.getImageResourceId());
        doctorNameTextView.setText(selectedDoctor.getName());

        List<String> timeSlots = selectedDoctor.getAvailableTimeSlots();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeSlots);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSlotSpinner.setAdapter(adapter);

        backImageButton.setOnClickListener(v -> {
            finish();
        });
        bookAppointmentButton.setOnClickListener(v -> {
            createAppointment(selectedDoctor);
        });
    }

    private void createAppointment(Doctor selectedDoctor) {

        String timeSlot = timeSlotSpinner.getSelectedItem().toString();

        int selectedConsultationTypeId = consultationTypeGroup.getCheckedRadioButtonId();
        RadioButton selectedConsultationTypeRadioButton = findViewById(selectedConsultationTypeId);
        String consultationType = selectedConsultationTypeRadioButton.getText() + "";

        boolean medicalReport = medicalReportCheckBox.isChecked();
        boolean labTests = labTestsCheckBox.isChecked();

        String patientDescription = patientDescriptionEditText.getText() + "";

        Appointment appointment = new Appointment(selectedDoctor, timeSlot, consultationType, medicalReport, labTests, patientDescription);
        DataSource.addAppointment(appointment);

        Toast.makeText(this, "Appointment created successfully at " + appointment.getTimeSlot(), Toast.LENGTH_LONG).show();
        finish();
    }
}