package fr.ssml.template.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.ssml.template.R;

public class CountActivity extends AppCompatActivity {

    // Variable pour stocker l'élément de la vue correspondant
    // au textView d'affichage du nombre de clics
    private TextView points;

    // Variable pour stocker l'élément de la vue correspondant
    // à l'ImageView sur laquelle il faut cliquer
    private ImageView icon;

    // Variable centralisant le compteur
    private int clics = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        this.points = findViewById(R.id.points);
        this.icon = findViewById(R.id.icon);

        // Action de clic sur l'ImageView
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Incrémentation du compteur:
                clics++;
                // Affichage du nombre de clics dans le TextView:
                points.setText("Points: " + clics);
            }
        });
    }
}