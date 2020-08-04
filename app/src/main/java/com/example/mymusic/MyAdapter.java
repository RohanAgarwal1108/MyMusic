package com.example.mymusic;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Music> mymusic;

    public MyAdapter(ArrayList<Music> myDataset) {
        mymusic=myDataset;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        final Music mymusic1=mymusic.get(position);
        holder.title.setText(mymusic1.getName());
        holder.authors.setText(mymusic1.getAllAuthors());
        //holder.image.setImageDrawable(newImage(mymusic1));
        holder.play_pause.setImageResource(getPlayPause(mymusic1));
        holder.play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayPause(mymusic1);
            }
        });
    }

    private void handlePlayPause(Music current_music){
        if(current_music.getIsplaying()==false){
            for(int i=0;i<mymusic.size();i++){
                mymusic.get(i).setIsplaying(false);
            }
            UpdateNowPlaying(current_music);
            current_music.setIsplaying(true);
        }
        else{
            current_music.setIsplaying(false);
        }
        notifyDataSetChanged();
    }

    private int getPlayPause(Music music){
        if(music.getIsplaying()==true){
            return R.drawable.baseline_pause_black_18dp;
        }
        else{
            return R.drawable.baseline_play_arrow_black_18dp;
        }
    }

    private void UpdateNowPlaying(Music music){
        MainActivity.UpdateNP(music);
    }

    @Override
    public int getItemCount() {
        if(mymusic!=null) {
            return mymusic.size();
        }
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final View view;
        public final TextView title;
        public final TextView authors;
        public final ImageView play_pause;
        public final ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
            title=view.findViewById(R.id.title);
            authors=view.findViewById(R.id.authors);
            image=view.findViewById(R.id.image);
            play_pause=view.findViewById(R.id.play_pause);

        }
    }
}
