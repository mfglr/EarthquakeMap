package com.thenqlv.bitirmeprojesiclient.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thenqlv.bitirmeprojesiclient.Entities.API.Disease;
import com.thenqlv.bitirmeprojesiclient.R;

import java.util.List;

public class DiseasesAdapter extends RecyclerView.Adapter<DiseasesAdapter.RowHolder>{

    private List<Disease> list;
    public DiseasesAdapter(List<Disease> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.disease_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{

        private TextView editText;
        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(Disease disease){
            editText = itemView.findViewById(R.id.editText);
            editText.setText(disease.getName());
            editText.setEnabled(false);
        }
    }
}
