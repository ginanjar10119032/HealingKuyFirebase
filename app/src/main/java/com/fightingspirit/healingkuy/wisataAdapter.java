package com.fightingspirit.healingkuy;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class wisataAdapter extends FirebaseRecyclerAdapter<
        wisata, wisataAdapter.wisataViewholder> implements View.OnClickListener {

    Context context;
    int bindAdapter;

    public wisataAdapter(
            @NonNull FirebaseRecyclerOptions<wisata> options, Context context)
    {
        super(options);
        this.context = context;
    }

     @Override
    protected void
    onBindViewHolder(@NonNull wisataViewholder holder,
                     int position, @NonNull wisata model)
    {

        Picasso.get().load(model.getFoto()).into(holder.foto);

        holder.lokasi.setText(model.getLokasi());

        holder.nama.setText(model.getNama());

        holder.alamat.setText(model.getAlamat());
    }


    @NonNull
    @Override
    public wisataViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wisata, parent, false);
        return new wisataAdapter.wisataViewholder(view);
    }

    @Override
    public void onClick(View view) {

    }

    class wisataViewholder
            extends RecyclerView.ViewHolder {
        TextView lokasi, nama, alamat;
        ImageView foto;

        public wisataViewholder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            lokasi = itemView.findViewById(R.id.lokasi);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), MapActivity.class);
                    view.getContext().startActivity(i);
                }
            });
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

            DatabaseReference databaseReference = firebaseDatabase.getReference();

            DatabaseReference getImage = databaseReference.child("foto");

            getImage.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);

                    Picasso.get().load(link).into(foto);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(context, "Error Loading Image", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
