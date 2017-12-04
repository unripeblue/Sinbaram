package com.tje.sinbaram;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.tje.sinbaram.util.DateTimeUtil;

import java.util.Calendar;

public class ReservationActivity extends BaseActivity {

    Calendar mReservationDate = Calendar.getInstance();

    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneEdt;
    private android.widget.EditText requestEdt;
    private android.widget.EditText reservationDateEdt;
    private android.widget.Spinner visitCountSpinner;
    private android.widget.Button reservationOkBtn;
    private Button selectDateBtn;
    private Button selectTimeBtn;

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

        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        mReservationDate.set(Calendar.YEAR, year);
                        mReservationDate.set(Calendar.MONTH, month);
                        mReservationDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        selectDateBtn.setText(DateTimeUtil.getDateString(mReservationDate));


                    }
                }, mReservationDate.get(Calendar.YEAR),
                        mReservationDate.get(Calendar.MONTH),
                        mReservationDate.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mReservationDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        mReservationDate.set(Calendar.MINUTE, minute);

                        selectTimeBtn.setText(DateTimeUtil.getTimeString(mReservationDate));

                    }
                }, mReservationDate.get(Calendar.HOUR_OF_DAY),
                        mReservationDate.get(Calendar.MINUTE), false).show();
            }
        });


    }

    @Override
    public void setValues() {
    }

    @Override
    public void bindViews() {
        this.reservationOkBtn = (Button) findViewById(R.id.reservationOkBtn);
        this.visitCountSpinner = (Spinner) findViewById(R.id.visitCountSpinner);
        this.selectTimeBtn = (Button) findViewById(R.id.selectTimeBtn);
        this.selectDateBtn = (Button) findViewById(R.id.selectDateBtn);
        this.requestEdt = (EditText) findViewById(R.id.requestEdt);
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
    }
}
