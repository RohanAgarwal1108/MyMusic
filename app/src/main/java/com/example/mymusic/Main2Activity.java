package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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
    private ImageView now_thumbnail;
    private static Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentplaying);
        setTitle("Now Playing");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        music_name=findViewById(R.id.music_name);
        music_authors=findViewById(R.id.music_authors);
        now_thumbnail=findViewById(R.id.now_thumbnail);
        final Music curr_music = MainActivity.getNow_play();
        now_thumbnail.setImageResource(curr_music.getThumbnail());
        music_name.setText(curr_music.getName());
        music_authors.setText(curr_music.getAllAuthors());
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.next);
        main=findViewById(R.id.main);
        main.setImageResource(curr_music.getIsplaying()==true?R.drawable.baseline_pause_circle_filled_black_48:R.drawable.baseline_play_circle_filled_black_48);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {
                    toast.cancel();
                }
                toast=Toast.makeText(Main2Activity.this, "Previous Track", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {
                    toast.cancel();
                }
                toast=Toast.makeText(Main2Activity.this, "Next Track", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {
                    toast.cancel();
                }
                curr_music.setIsplaying(!curr_music.getIsplaying());
                main.setImageResource(curr_music.getIsplaying()==true?R.drawable.baseline_pause_circle_filled_black_48:R.drawable.baseline_play_circle_filled_black_48);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
