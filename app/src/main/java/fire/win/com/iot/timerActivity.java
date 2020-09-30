package fire.win.com.iot;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class timerActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTimerset;
    TimePicker timePicker;
    int h;
    int m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        btnTimerset = findViewById(R.id.btnTimerset);
        btnTimerset.setOnClickListener(this);

        timePicker = findViewById(R.id.timerPicker);

        timePicker.setIs24HourView(true);

    }

    public void om(){

       /* c="24:59:59";
        final String time = editTextTimer.getText().toString().trim();
        if (time.isEmpty()){
            editTextTimer.setError("Please Enter the time");
            editTextTimer.requestFocus();
            return;
        }

        if (time.length() == 8 )  {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Timer");

            myRef.setValue(time);

            Toast.makeText(timerActivity.this,"Timer is Set ",Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }else {
            Toast.makeText(timerActivity.this,"Please Enter a Valid Input ",Toast.LENGTH_LONG).show();
        }*/

        h = timePicker.getCurrentHour();
        m = timePicker.getCurrentMinute();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Time");
        myRef.child("Hours").setValue(h);
        myRef.child("Minutes").setValue(m);

        Toast.makeText(timerActivity.this,"Timer is Set to " + h + ":" + m ,Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(this,MainActivity.class));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTimerset:
                om();
                break;

        }
    }
}
