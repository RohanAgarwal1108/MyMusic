package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Music now_playing;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static LinearLayout nowplay;
    private static TextView nowauthor;
    private static TextView nowmusic;
    ArrayList<Music> myDataset=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        nowplay=findViewById(R.id.now_playing);
        nowmusic=findViewById(R.id.nowmusic);
        nowauthor=findViewById(R.id.nowauthor);
        now_playing=null;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myDataset.add(new Music("Hello1", "Hello1","Hello1", "hello1", false));
        myDataset.add(new Music("Hello", "Hello","Hello", "hello", false));
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }

    static void UpdateNP(Music current){
        now_playing=current;
        showNP(current);
    }

    public static void showNP(Music current){
        if(current==null){
            nowplay.setVisibility(View.INVISIBLE);
            return;
        }
        nowmusic.setText(current.getName());
        nowauthor.setText(current.getAllAuthors());
        nowplay.setVisibility(View.VISIBLE);

    }
}
