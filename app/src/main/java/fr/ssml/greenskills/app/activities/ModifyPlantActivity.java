package fr.ssml.greenskills.app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import fr.ssml.greenskills.app.dao.PlantDatabase;
import fr.ssml.template.R;

public class ModifyPlantActivity extends AppCompatActivity {

    EditText nom_input, famille_input, arrosage_input, ensoleillement_input ;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nom_input = findViewById(R.id.nom_input);
        famille_input = findViewById(R.id.famille_input);
        arrosage_input = findViewById(R.id.arrosage_input);
        ensoleillement_input = findViewById(R.id.ensoleillement_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantDatabase plDB = new PlantDatabase(ModifyPlantActivity.this);
                plDB.addPlant(nom_input.getText().toString().trim(),
                famille_input.getText().toString().trim(),
                Integer.valueOf(arrosage_input.getText().toString().trim()),
                Integer.valueOf(ensoleillement_input.getText().toString().trim())
                        );
            }
        });

    }
}