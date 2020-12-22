package fr.ssml.template.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import fr.ssml.template.R;

public class LinearLayoutActivity extends AppCompatActivity {

    // Variable locale de classe qui pointe vers l'élément de la view d'entrée qui
    // sert à changer d'activité
    private Button layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear_layout);
        launchEventOnButton();
    }

    public void launchEventOnButton(){
        // Trouver l'élement de la vue associée par son id
        this.layout2 = findViewById(R.id.showNextLayout);

        // Créer un  évènement lié au clic sur cet élément
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            // Fonction qui décrit l'action à réaliser suite au clic:
            public void onClick(View view) {
                // Instanciation d'un objet d'instruction, lui donner le contexte et la classe vers laquelle se diriger
                Intent otherActivity = new Intent(getApplicationContext(), MenuActivity.class);
                // Démarrer l'activité
                startActivity(otherActivity);
                // Terminer l'activité en cours pour ce faire
                finish();
            }
        }
        );
    }
}