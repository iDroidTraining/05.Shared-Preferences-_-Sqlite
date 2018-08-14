package ws.idroid.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText etTextValue;
    private TextView tvRestoredLabel;
    private Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        initViews();
        readFromPreferences();
        writeToPreferences();
    }

    private void writeToPreferences() {
        btSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences("mySharedFile", MODE_PRIVATE)
                    .edit();
            editor.putString("nameKey", etTextValue.getText().toString());
            editor.apply();
        });
    }

    private void readFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("mySharedFile", MODE_PRIVATE);
        String restoredText = sharedPreferences.getString("nameKey", "There is nothing saved!");
        tvRestoredLabel.setText(restoredText);
    }

    private void initViews() {
        etTextValue = findViewById(R.id.et_shared_preferences);
        tvRestoredLabel = findViewById(R.id.tv_shared_preferences);
        btSave = findViewById(R.id.button);
    }
}
