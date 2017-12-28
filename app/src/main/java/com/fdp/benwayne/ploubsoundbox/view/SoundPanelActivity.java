package com.fdp.benwayne.ploubsoundbox.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fdp.benwayne.ploubsoundbox.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SoundPanelActivity extends AppCompatActivity {

    /**
     * Lecteur de fichier audio/vidéo
     */
    private MediaPlayer mPlayer = null;

    private Map<Integer, Integer> buttonSoundMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_panel);
        this.createButtonList();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
    }

    /**
     * Créer la liste des boutons
     */
    private void createButtonList() {
        buttonSoundMap.put(R.id.buttonAllez, R.raw.allez);
        buttonSoundMap.put(R.id.buttonCaPetille, R.raw.ca_petille);
        buttonSoundMap.put(R.id.buttonComplique, R.raw.la_vie_cest_complique);
        buttonSoundMap.put(R.id.buttonDuSale, R.raw.du_sale);
        buttonSoundMap.put(R.id.buttonOkCestParti, R.raw.ok_cest_parti);
        buttonSoundMap.put(R.id.buttonOktamer, R.raw.oktamer);
        buttonSoundMap.put(R.id.buttonPilon, R.raw.pilon);
        buttonSoundMap.put(R.id.buttonTg, R.raw.tg);
        buttonSoundMap.put(R.id.buttonZbob, R.raw.zbob_zbob);
        this.associateButtonsList();
    }

    /**
     * Fonction de lecture des sons
     *
     * @param resId id du son
     */
    private void playSound(int resId) {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, resId);
        mPlayer.start();
    }

    private void associateButtonsList() {
        Iterator<Map.Entry<Integer, Integer>> iterator = buttonSoundMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            associateSoundToButton(pair.getKey(), pair.getValue());
            iterator.remove();
        }
    }

    private void associateSoundToButton(Integer buttonId, final Integer soundId) {
        Button button = this.findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(soundId);
            }
        });
    }
}
