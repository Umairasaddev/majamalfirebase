package com.example.majamalfirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void process(View view) {
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

          String name = t1.getText().toString().trim();
          String duration = t2.getText().toString().trim();
          String course = t3.getText().toString().trim();
          String roll = t4.getText().toString().trim();


          dataholder obj = new dataholder(name,course,duration);

          FirebaseDatabase db = FirebaseDatabase.getInstance();
          DatabaseReference node = db.getReference("Students");//jis node/reference p entry karwani ha woh mention karain gy


          node.child(roll).setValue(obj);//why we are passing object. because we are getting the values in holder object adn by passing object we will get all the values the object is getting

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        Toast.makeText(getApplicationContext(), "Value Inserted", Toast.LENGTH_SHORT).show();

    }
}