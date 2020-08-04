package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView music_name;
    private TextView music_authors;
    private ImageView previous;
    private ImageView next;
    private ImageView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentplaying);
        music_name=findViewById(R.id.music_name);
        music_authors=findViewById(R.id.music_authors);
        final Music curr_music = MainActivity.getNow_play();
        music_name.setText(curr_music.getName());
        music_authors.setText(curr_music.getAllAuthors());
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.next);
        main=findViewById(R.id.main);
        main.setImageResource(curr_music.getIsplaying()==true?R.drawable.round_pause_circle_filled_black_18dp:R.drawable.round_play_circle_filled_black_18dp);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Previous Track", Toast.LENGTH_SHORT).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Next Track", Toast.LENGTH_SHORT).show();
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_music.setIsplaying(!curr_music.getIsplaying());
                main.setImageResource(curr_music.getIsplaying()==true?R.drawable.round_pause_circle_filled_black_18dp:R.drawable.round_play_circle_filled_black_18dp);
            }
        });
    }
}
