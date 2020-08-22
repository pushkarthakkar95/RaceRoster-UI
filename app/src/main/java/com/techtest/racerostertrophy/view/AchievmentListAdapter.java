package com.techtest.racerostertrophy.view;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techtest.racerostertrophy.R;
import com.techtest.racerostertrophy.model.Achievement;

import java.util.List;

public class AchievmentListAdapter extends RecyclerView.Adapter<AchievmentListAdapter.AchivementViewHolder> {
    private Context context;
    private List<Achievement> achievements;

    public AchievmentListAdapter(Context context, List<Achievement> achievements) {
        this.context = context;
        this.achievements = achievements;
    }

    @NonNull
    @Override
    public AchivementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.achievement_item,parent,false);
        return new AchivementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchivementViewHolder holder, int position) {
        Achievement current = achievements.get(position);
        holder.title.setText(current.getTitle());
        holder.record.setText(current.getRecord());
        holder.badge.setImageResource(current.getImageResource());
        if(!current.isAchieved()){
            setLocked(holder.badge, holder.title, holder.record);
        }else{
            holder.itemView.setOnClickListener(v -> showConfetti());
        }
    }

    private void showConfetti(){

    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    public static void  setLocked(ImageView v, TextView tv, TextView recordTv)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        v.setImageAlpha(128);
        tv.setEnabled(false);
        recordTv.setEnabled(false);

    }

    public class AchivementViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView record;
        private ImageView badge;
        public AchivementViewHolder(@NonNull View itemView) {
            super(itemView);
             title = itemView.findViewById(R.id.achievementTitleTextv);
             record = itemView.findViewById(R.id.achievementRecordTextv);
             badge = itemView.findViewById(R.id.badgeImgV);
        }
    }
}
