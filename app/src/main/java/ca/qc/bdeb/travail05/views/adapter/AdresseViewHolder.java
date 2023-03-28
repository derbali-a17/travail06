package ca.qc.bdeb.travail05.views.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.qc.bdeb.travail05.R;

public class AdresseViewHolder extends RecyclerView.ViewHolder {
    TextView lblVille;
    TextView lblCodePostal;
    ImageView iconeAdresse;
    View conteneur;
    public AdresseViewHolder(@NonNull View itemView) {
        super(itemView);
        conteneur = itemView;
        lblVille = itemView.findViewById(R.id.ville_adresse);
        lblCodePostal = itemView.findViewById(R.id.code_postal_adresse);
        iconeAdresse = itemView.findViewById(R.id.icone_adresse);
    }
}
