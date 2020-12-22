package fr.ssml.template.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fr.ssml.template.core.HighTechItem;
import fr.ssml.template.core.HighTechitemAdapter;
import fr.ssml.template.R;

public class MenuActivity extends AppCompatActivity {

    // Variable locale de classe qui pointe vers l'élément de la view d'netrée qui
    // sert à changer d'activité
    private ImageView entryPoint;

    private TextView layout;

    // test database
    private DatabaseReference reference;


    // Pour ajouter un son
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayerFromWeb;

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test db:
        dbtest();

        List<HighTechItem> highTechItemList = new ArrayList<>();
        highTechItemList.add(new HighTechItem("Ordinateur", "ordi", 900));
        highTechItemList.add(new HighTechItem("Smartphone", "smartphone",  200));
        highTechItemList.add(new HighTechItem("gps", "gps", 350));

        ListView shopListView = findViewById(R.id.listView);
        shopListView.setAdapter( new HighTechitemAdapter(this, highTechItemList));

        launchEventOnImage();
        launchEventOnText(R.id.showNextLayout, LinearLayoutActivity.class);
        launchEventOnText(R.id.entryPoint2, DynamicLinearLayoutActivity.class);

        this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.son_test);
        this.seekBar = findViewById(R.id.sound_bar);

        String url = "https://gravendev.fr/ressources/music.mp3";
        this.mediaPlayerFromWeb = new MediaPlayer();
        try {
            mediaPlayerFromWeb.setDataSource(url);
            mediaPlayerFromWeb.prepare();
        } catch (IOException e) {
            System.out.println("En BUG Complet");
            e.printStackTrace();
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition()/1000);
            }
        }, 1000, 1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(seekBar.getProgress()*1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

        public void launchEventOnImage(){
            // Trouver l'élement de la vue associée par son id
            this.entryPoint = findViewById(R.id.entryPoint);

            // Créer un  évènement lié au clic sur cet élément
            entryPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                // Fonction qui décrit l'action à réaliser suite au clic:
                public void onClick(View view) {

                    // Instanciation d'un objet d'instruction, lui donner le contexte et la classe vers laquelle se diriger
                    Intent otherActivity = new Intent(getApplicationContext(), CountActivity.class);
                    // Démarrer l'activité
                    startActivity(otherActivity);
                    // Terminer l'activité en cours pour ce faire
                    finish();
                }
            }
        );
    }

    public void launchEventOnText(int elementId, Class classe){
        // Trouver l'élement de la vue associée par son id
        this.layout = findViewById(elementId);

        // Créer un  évènement lié au clic sur cet élément
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            // Fonction qui décrit l'action à réaliser suite au clic:
            public void onClick(View view) {
                // Instanciation d'un objet d'instruction, lui donner le contexte et la classe vers laquelle se diriger
                Intent otherActivity = new Intent(getApplicationContext(), classe);
                // Démarrer l'activité
                startActivity(otherActivity);
                // Terminer l'activité en cours pour ce faire
                finish();
            }
        }
        );
    }

    public void playSound(View view) {

        Button button = (Button) view;
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            button.setText("Lancer");
        }
        else {
            mediaPlayer.start();
            button.setText("Arrêter");
        }
    }

    public void playWebSound(View view) {
        mediaPlayerFromWeb.start();
    }

    public void dbtest(){
        reference = FirebaseDatabase.getInstance().getReference();
        System.out.println(reference.getKey());
        System.out.println(reference.getRoot());
        System.out.println("--------------------------- Après l'ajout en db ---------------------------");
    }
}