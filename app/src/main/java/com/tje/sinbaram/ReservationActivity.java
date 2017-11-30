package com.tje.sinbaram;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ReservationActivity extends BaseActivity {

    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneEdt;
    private android.widget.EditText requestEdt;
    private android.widget.EditText reservationDateEdt;
    private android.widget.Spinner visitCountSpinner;
    private android.widget.Button reservationOkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.reservationOkBtn = (Button) findViewById(R.id.reservationOkBtn);
        this.visitCountSpinner = (Spinner) findViewById(R.id.visitCountSpinner);
        this.reservationDateEdt = (EditText) findViewById(R.id.reservationDateEdt);
        this.requestEdt = (EditText) findViewById(R.id.requestEdt);
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
    }
}
