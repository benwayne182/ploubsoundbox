package com.fdp.benwayne.ploubsoundbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private String userName;
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
            userName = b ? s.toString() : "";
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
            startSoundbox(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = this.findViewById(R.id.activityMainTextView);
        this.editText = this.findViewById(R.id.activityMainEditText);
        this.startButton = this.findViewById(R.id.activityMainStartButton);

        this.startButton.setEnabled(false);

        this.editText.addTextChangedListener(this.textWatcher);
        this.startButton.setOnClickListener(this.onClickListener);
    }

    protected void startSoundbox(View view) {

    }
}
