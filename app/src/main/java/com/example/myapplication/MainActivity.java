package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinnerCountType;
    private Button btnCount;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        txtInput = findViewById(R.id.txtInput);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        btnCount = findViewById(R.id.btnCount);
        txtResult = findViewById(R.id.txtResult);

        // Set up the spinner options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountType.setAdapter(adapter);

        // Set up the button click listener
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = txtInput.getText().toString();

                // Validate input
                if (inputText.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
                    return;
                }

                WordCharCounter counter = new WordCharCounter();
                String selectedOption = spinnerCountType.getSelectedItem().toString();
                int result = 0;

                // Count based on spinner selection
                if (selectedOption.equals(getString(R.string.words))) {
                    result = counter.countWords(inputText);
                } else if (selectedOption.equals(getString(R.string.characters))) {
                    result = counter.countCharacters(inputText);
                }

                // Display the result
                txtResult.setText(getString(R.string.result) + " " + result);
            }
        });
    }
}
