package com.fdp.benwayne.ploubsoundbox.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fdp.benwayne.ploubsoundbox.R;
import com.fdp.benwayne.ploubsoundbox.model.User;

public class MainActivity extends AppCompatActivity {

    /**
     * Message d'ouverture
     */
    private TextView textView;
    /**
     * Change de saisie du nom d'utilisateur
     */
    private EditText editText;
    /**
     * Bouton start
     */
    private Button startButton;
    /**
     * Nom de l'utilisateur
     */
    private User user;
    /**
     * Listener sur la modification du champs de saisie
     */
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            boolean b = (s.length() != 0);
            startButton.setEnabled(b);
            String userName = b ? s.toString() : "";
            user.setName(userName);
            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            preferences.edit().putString("username", user.getName()).apply();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    /**
     * Listener sur le clic du bouton start
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startSoundbox();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User();
        this.textView = this.findViewById(R.id.activityMainTextView);
        this.editText = this.findViewById(R.id.activityMainEditText);
        this.startButton = this.findViewById(R.id.activityMainStartButton);

        this.startButton.setEnabled(true);

        this.editText.addTextChangedListener(this.textWatcher);
        this.startButton.setOnClickListener(this.onClickListener);
    }

    private void startSoundbox() {
        String username = getPreferences(MODE_PRIVATE).getString("username", null);
        Toast.makeText(this, this.getText(R.string.toast) + " " + username, Toast.LENGTH_SHORT).show();
        Intent gameActivity = new Intent(MainActivity.this, SoundPanelActivity.class);
        startActivity(gameActivity);
    }
}
