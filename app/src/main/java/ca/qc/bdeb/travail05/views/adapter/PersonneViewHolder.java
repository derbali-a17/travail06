package ca.qc.bdeb.travail05.views.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.qc.bdeb.travail05.R;

public class PersonneViewHolder extends RecyclerView.ViewHolder {
    TextView lblNom, lblDateNaissance;

    public PersonneViewHolder(@NonNull View itemView) {
        super(itemView);
        lblNom = itemView.findViewById(R.id.nom_personne);
        lblDateNaissance = itemView.findViewById(R.id.date_naissance_personne);
    }
}
