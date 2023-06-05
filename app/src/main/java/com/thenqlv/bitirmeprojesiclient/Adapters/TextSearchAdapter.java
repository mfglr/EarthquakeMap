package com.thenqlv.bitirmeprojesiclient.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Candidate;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;
import com.thenqlv.bitirmeprojesiclient.MapsActivity;
import com.thenqlv.bitirmeprojesiclient.R;


public class TextSearchAdapter extends RecyclerView.Adapter<TextSearchAdapter.RowHolder> {
    private Candidate[] locations;
    private Individual individual;
    public TextSearchAdapter(Candidate[] locations,Individual individual) {
        this.locations = locations;
        this.individual = individual;
    }


    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(locations[position]);
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }
    public void clear() {
        int size = getItemCount();
        if (size > 0) {
            notifyItemRangeRemoved(0, size);
        }
    }

    public class RowHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView formattedAddress;
        private Candidate candidate;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }


        private void startActivity(View view){
            Intent intent = new Intent(view.getContext(),MapsActivity.class);
            intent.putExtra(
                    "candidate",
                    candidate
            );
            intent.putExtra(
                    "individual",
                    individual
            );
            view.getContext().startActivity(intent);
        }
        public void bind(Candidate model){
            title = itemView.findViewById(R.id.textViewTitle);
            formattedAddress = itemView.findViewById(R.id.buttonFormattedAddress);
            title.setText(model.getName());
            formattedAddress.setText(model.getFormattedAddress());
            candidate = model;
            formattedAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(view);
                }
            });

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(view);
                }
            });
        }

    }
}
