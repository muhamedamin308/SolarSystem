package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.NullPointerException;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterManager extends RecyclerView.Adapter<AdapterManager.ItemsHolder> {
    private List<GalaxyClass> gGalaxyList=new ArrayList<>();
    Context context = null;
//    private onPlanetListener onPlanetListener1 ;
    public static class ItemsHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public Button button;
        public Button update;
        public ItemsHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewid);
            textView1 = itemView.findViewById(R.id.textviewid1);
            textView2 = itemView.findViewById(R.id.textviewid2);
            button = itemView.findViewById(R.id.next);
            update = itemView.findViewById(R.id.update);
        }
    }
    public AdapterManager (Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.galaxy , parent, false);
        ItemsHolder ih = new ItemsHolder(view);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        GalaxyClass planet = gGalaxyList.get(position);
        holder.imageView.setImageResource(planet.getImageResource());
        holder.textView1.setText(planet.getText1());
        holder.textView2.setText(planet.getText2());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MercuryData.class);
                intent.putExtra("image", planet.getImageResource());
                intent.putExtra("title", planet.getText1());
                intent.putExtra("Description", planet.getText2());
                intent.putExtra("number" , planet.getNumeber());
                intent.putExtra("desc",planet.getDescription());
                context.startActivity(intent);
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , AddPlanet.class);
                intent.putExtra(AddPlanet.Extra_id , planet.getNumeber());
                intent.putExtra(AddPlanet.Extra_Pname,planet.getText1());
                intent.putExtra(AddPlanet.Extra_Pdesc1,planet.getText2());
                intent.putExtra(AddPlanet.Extra_Pdesc2,planet.getDescription());
                intent.putExtra(AddPlanet.Extra_Pimage, planet.getImageResource());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return gGalaxyList.size();
    }
    public void setgGalaxyList(List<GalaxyClass> mGalaxyClass){
        gGalaxyList = mGalaxyClass;
        notifyDataSetChanged();
    }
    public GalaxyClass getPlanetAt (int pos){
        return gGalaxyList.get(pos);
    }
}