package com.thenqlv.bitirmeprojesiclient.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.thenqlv.bitirmeprojesiclient.Entities.Google.Candidate;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;
import com.thenqlv.bitirmeprojesiclient.R;

public class GetDirectionsAdapter extends RecyclerView.Adapter<GetDirectionsAdapter.RowHolder>{


    private Candidate[] locations;
    private EditText editText;
    private String key;

    public GetDirectionsAdapter(Candidate[] locations,EditText editText,String key) {
        this.locations = locations;
        this.editText = editText;
        this.key = key;
    }


    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout,parent,false);
        return new GetDirectionsAdapter.RowHolder(view);
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
        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }


        public void bind(Candidate model){
            title = itemView.findViewById(R.id.textViewTitle);
            formattedAddress = itemView.findViewById(R.id.buttonFormattedAddress);
            title.setText(model.getName());
            formattedAddress.setText(model.getFormattedAddress());

            formattedAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText(formattedAddress.getText());
                    ((AppCompatActivity)view.getContext()).getIntent().putExtra(
                            key,
                            model.getGeometry().getLocation()
                    );
                }
            });

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText(formattedAddress.getText());
                    ((AppCompatActivity)view.getContext()).getIntent().putExtra(
                            key,
                            model.getGeometry().getLocation()
                    );
                }
            });
        }

    }
}
