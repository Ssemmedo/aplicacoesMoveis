package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<LanguagesModel> languagesModels = new ArrayList<>();
    int image = R.drawable.eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setupProgrammingLanguagesModels();

        PL_recyclerViewAdapter adapter = new PL_recyclerViewAdapter(this, languagesModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupProgrammingLanguagesModels(){
        String[] programmingLanguages = getResources().getStringArray(R.array.programming_languages);
        String[] description = getResources().getStringArray(R.array.description);

        for (int i = 0; i < programmingLanguages.length; i++){
            languagesModels.add(
                new LanguagesModel(
                    programmingLanguages[i],
                    description[i],
                    image
                )
            );
        }
    }
}