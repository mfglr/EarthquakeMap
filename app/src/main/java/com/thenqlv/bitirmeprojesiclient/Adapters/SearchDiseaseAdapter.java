package com.thenqlv.bitirmeprojesiclient.Adapters;

import android.app.Activity;
import android.content.Context;
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

public class SearchDiseaseAdapter extends RecyclerView.Adapter<SearchDiseaseAdapter.RowHolder>{
    private List<Disease> list;
    private EditText editTextSearch;
    private Activity parent;
    public SearchDiseaseAdapter(List<Disease> list, EditText editTextSearch, Activity parent) {
        this.list = list;
        this.editTextSearch = editTextSearch;
        this.parent = parent;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.disease_layout,parent,false);
        return new SearchDiseaseAdapter.RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(Disease disease){
            textView = itemView.findViewById(R.id.editText);
            textView.setText(disease.getName());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        editTextSearch.setText(disease.getName());
                        parent.getIntent().putExtra("disease",disease);
                }
            });
        }
    }
}
