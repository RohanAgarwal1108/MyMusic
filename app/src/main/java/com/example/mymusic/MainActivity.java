package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static Music now_playing;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static ImageView nowimage;
    private static LinearLayout nowplay;
    private static TextView nowauthor;
    private static TextView nowmusic;
    ArrayList<Music> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        nowplay = findViewById(R.id.now_playing);
        nowmusic = findViewById(R.id.nowmusic);
        nowauthor = findViewById(R.id.nowauthor);
        nowimage = findViewById(R.id.nowimage);
        now_playing = null;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myDataset.add(new Music("Thrift Shop (ft. Wanz)", "Macklemore", "Ryan Lewis", "Wanz", false, R.drawable.thriftshop));
        myDataset.add(new Music("Once Upon a Time", "Max Oazo", "Moonessa", null, false, R.drawable.onceupon));
        myDataset.add(new Music("Blinding Lights", "The Weeknd", null, null, false, R.drawable.blinding));
        myDataset.add(new Music("The Box", "Roddy Ricch", null, null, false, R.drawable.thebox));
        myDataset.add(new Music("THE SCOTTS", "THE SCOTTS", "Travis Scott", "Kid Cudi", false, R.drawable.scotts));
        myDataset.add(new Music("SOS", "Avicii", "Aloe Blancc", "null", false, R.drawable.sos));
        myDataset.add(new Music("Cradles", "Sub Urban", null, null, false, R.drawable.cradles));
        myDataset.add(new Music("Call You Mine", "The Chainsmokers", "Bebe Rexha", null, false, R.drawable.callyou));
        myDataset.add(new Music("Lose Yourself", "Eminem", null, null, false, R.drawable.lose));
        myDataset.add(new Music("Dance Monkey", "Vibe2Vibe", null, null, false, R.drawable.maxresdefault));
        myDataset.add(new Music("Godzilla (feat. Juice WRLD)", "Eminem", "Juice WRLD", null, false, R.drawable.godzilla));
        myDataset.add(new Music("bad guy", "Billie Eilish", null, null, false, R.drawable.badguy));
        myDataset.add(new Music("Burberry Headband", "Lil Mosey", null, null, false, R.drawable.burberry));
        myDataset.add(new Music("We Did It", "AREA21", null, null, false, R.drawable.wedid));
        myDataset.add(new Music("365", "Zedd", "Katy Perry", null, false, R.drawable.katy));
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
        nowplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    static void UpdateNP(Music current) {
        now_playing = current;
        showNP(current);
    }

    public static void showNP(Music current) {
        if (current == null) {
            nowplay.setVisibility(View.INVISIBLE);
            return;
        }
        nowmusic.setText(current.getName());
        nowauthor.setText(current.getAllAuthors());
        nowimage.setImageResource(current.getThumbnail());
        nowplay.setVisibility(View.VISIBLE);

    }

    public static Music getNow_play() {
        return now_playing;
    }
}
