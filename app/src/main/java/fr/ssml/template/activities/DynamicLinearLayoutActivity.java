package fr.ssml.template.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import fr.ssml.template.R;
import fr.ssml.template.app_elements.CustomPopup;

public class DynamicLinearLayoutActivity extends AppCompatActivity {

    // Variable locale de classe qui pointe vers l'élément de la view d'entrée qui
    // sert à changer d'activité
    private LinearLayout myLayout;

    private DynamicLinearLayoutActivity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamic_linear_layout);

        this.myLayout = findViewById(R.id.myDynamicLayout);
        this.thisActivity = this;

        // Il est possible de créer des éléments à afficher dans une view directement dans une classe java:
        // Nouvelle Instance d'une Image à insérer sur le layout:
        ImageView image = new ImageView((this));

        // Paramètrage de l'image:
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(100, 100);
        image.setLayoutParams(params);
        image.setBackgroundResource(R.drawable.ic_launcher_background);

        // Ajout de l'image sur le layout:
        myLayout.addView(image);

        // Idem pour un texte:
        TextView text = new TextView(this);
        text.setText(getResources().getString(R.string.next_layout));
        text.setTextColor(getResources().getColor(R.color.design_default_color_primary_variant));
        text.setTextSize(getResources().getInteger(R.integer.total));
        myLayout.addView(text);

        // Ajouter dynamiquement un bouton:
        for(int i = 0; i < 6; i++){
            Button button = new Button(this);
            button.setText("Button " + i);

            // Ajout d'un évènement pour lancer une pop-up:
            button.setOnClickListener(new View.OnClickListener() {

                // Methode customisée
                @Override
                public void onClick(View view) {
                    CustomPopup customPopup = new CustomPopup(thisActivity);
                    customPopup.setTitle("Mon titre a changé");
                    customPopup.setSubtitle("Mon sous titre a changé");
                    customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "OUI - OK", Toast.LENGTH_SHORT).show();
                        // Pour fermer la popup:
                            customPopup.dismiss();
                        }

                    });

                    customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "NON - KO", Toast.LENGTH_SHORT).show();
                            // Pour fermer la popup:
                            customPopup.dismiss();
                        }

                    });


                    customPopup.build();
                }



                // Methode de popup par défaut

                // @Override
                // public void onClick(View view) {
                //     AlertDialog.Builder myPopup = new AlertDialog.Builder(thisActivity);
                //     myPopup.setTitle("Salut");
                //     myPopup.setMessage("Salut à tous ceci est un message");
                //     myPopup.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                //         @Override
                //         public void onClick(DialogInterface dialogInterface, int i) {
                //             Toast.makeText(getApplicationContext(), "Vous avez cliqué sur OUI", Toast.LENGTH_LONG).show();
                //         }
                //     });
//
                //     myPopup.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                //         @Override
                //         public void onClick(DialogInterface dialogInterface, int i) {
                //             Toast.makeText(getApplicationContext(), "Vous avez cliqué sur NON", Toast.LENGTH_SHORT).show();
                //         }
                //     });
//
                //     myPopup.show();
                // }
            });




            // Augmenter à chaque fois la taille des boutons
            button.setTextSize(20 + i);
            myLayout.addView(button);
        }
    }
}