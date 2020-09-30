package fire.win.com.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOn;
    Button btnOff;
    Button btnSetTimer;
    Button btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn = findViewById(R.id.btnOn);
        btnOn.setOnClickListener(this);

        btnOff = findViewById(R.id.btnOff);
        btnOff.setOnClickListener(this);

        btnSetTimer = findViewById(R.id.btnSetTimer);
        btnSetTimer.setOnClickListener(this);

        btnStatus = findViewById(R.id.btnStatus);
        btnStatus.setOnClickListener(this);


    }

    public void manish(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("On");

    }

    public void manan(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Off");


    }


    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btnOn:
               manish();
               Toast.makeText(MainActivity.this,"Watering the Plants!",Toast.LENGTH_LONG).show();
               break;

           case R.id.btnOff :
               manan();
               Toast.makeText(MainActivity.this,"Not Watering the Plants!",Toast.LENGTH_LONG).show();
               break;

           case R.id.btnSetTimer :
               
               startActivity(new Intent(MainActivity.this,timerActivity.class));
               break;

           case R.id.btnStatus :
               startActivity(new Intent(MainActivity.this,statusActivity.class));
               break;

       }

    }
}
