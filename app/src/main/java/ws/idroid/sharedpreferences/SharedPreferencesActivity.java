package ws.idroid.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

public class SharedPreferencesActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "mypref";
    private EditText etTextValue;
    private TextView tvRestoredLabel;
    private Button btSave;
    private SharedPreferences sharedPreferences;
    private static final String DEFAULT_STRING = "There is no name saved!";
    private static final String PREF_KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        initViews();
        sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = sharedPreferences.getString(PREF_KEY_NAME, DEFAULT_STRING);
        tvRestoredLabel.setText(restoredText);
        btSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)
                    .edit();
            editor.putString(PREF_KEY_NAME, etTextValue.getText().toString());
            editor.apply();
        });

    }

    private void initViews() {
        etTextValue = findViewById(R.id.et_shared_preferences);
        tvRestoredLabel = findViewById(R.id.tv_shared_preferences);
        btSave = findViewById(R.id.button);
    }
}
