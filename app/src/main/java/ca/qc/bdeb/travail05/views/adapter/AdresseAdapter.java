package ca.qc.bdeb.travail05.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.entities.Adresse;
import ca.qc.bdeb.travail05.views.PersonnesActivity;

public class AdresseAdapter extends RecyclerView.Adapter<AdresseViewHolder> {
    Context context;
    List<Adresse> adresses;

    public AdresseAdapter(Context context, List<Adresse> adresses) {
        this.context = context;
        this.adresses = adresses;
    }

    @NonNull
    @Override
    public AdresseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ligne_adresse, parent, false);
        return new AdresseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdresseViewHolder holder, int position) {
        holder.lblVille.setText(this.adresses.get(position).getVille());
        holder.lblCodePostal.setText(this.adresses.get(position).getCodePostal());
        holder.iconeAdresse.setImageResource(R.mipmap.ic_adresse);
        String ville = this.adresses.get(position).getVille();
        int idAdresse = this.adresses.get(position).getId();
        holder.conteneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonnesActivity.class);
                intent.putExtra("ville", ville);
                intent.putExtra("idAdresse", idAdresse);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.adresses.size();
    }
}
