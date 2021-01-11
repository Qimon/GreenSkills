package fr.ssml.greenskills.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import fr.ssml.template.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerView = findViewById(R.id.);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(new View.OnClickListener()
            { public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ModifyPlantActivity.class);
                startActivity(intent);
            }
            }
        );
    }
}