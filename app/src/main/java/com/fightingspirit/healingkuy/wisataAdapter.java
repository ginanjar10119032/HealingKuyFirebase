package com.fightingspirit.healingkuy;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.Map;

public class wisataAdapter extends FirebaseRecyclerAdapter<
        wisata, wisataAdapter.personsViewholder> {

    Context context;
    public wisataAdapter(
            @NonNull FirebaseRecyclerOptions<wisata> options, Context context)
    {
        super(options);
        this.context = context;
    }

    // Function to bind the view in Card view(here
    // "wisata.xml") iwth data in
    // model class(here "wisata.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull wisata model)
    {

        // Add lokasi from model class (here
        // "wisata.class")to appropriate view in Card
        // view (here "wisata.xml")
        holder.lokasi.setText(model.getLokasi());

        // Add nama from model class (here
        // "wisata.class")to appropriate view in Card
        // view (here "wisata.xml")
        holder.nama.setText(model.getNama());

        // Add alamat from model class (here
        // "wisata.class")to appropriate view in Card
        // view (here "wisata.xml")
        holder.alamat.setText(model.getAlamat());
    }

//    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent i = new Intent(context, MapActivity.class);
//            context.startActivity(i);
//        }
//    };

    // Function to tell the class about the Card view (here
    // "wisata.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wisata, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MapActivity.class);
                context.startActivity(i);
            }
        });
        return new wisataAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "wisata.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView lokasi, nama, alamat;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            lokasi
                    = itemView.findViewById(R.id.lokasi);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
        }
    }

}
