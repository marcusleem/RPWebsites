package com.marcus.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    TextView tvCat, tvSubCat;
    Button btnDisplay;
    ArrayList<String> alDisplay;
    ArrayAdapter<String> aaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        tvCat = findViewById(R.id.textView1);
        tvSubCat = findViewById(R.id.textView2);
        btnDisplay = findViewById(R.id.button1);

        alDisplay = new ArrayList<>();
        aaDisplay = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alDisplay);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alDisplay.clear();
                        String[] strDisplay =getResources().getStringArray(R.array.student);
                        alDisplay.addAll(Arrays.asList(strDisplay));
                        break;
                    case 1:
                        alDisplay.clear();
                        String[] strDisplay1 =getResources().getStringArray(R.array.SOI);
                        alDisplay.addAll(Arrays.asList(strDisplay1));
                        break;
                }
                spn2.setAdapter(aaDisplay);
                aaDisplay.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] websites =
                        {{"https://www.rp.edu.sg/", "https://www.rp.edu.sg/student-life"},
                                {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                        "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}};
                String url = websites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];

                Intent intent = new Intent(MainActivity.this, page2.class);
                intent.putExtra("URL", url);
                startActivity (intent);
            }
        });

    }
}