package ca.qc.bdeb.travail05.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.entities.Personne;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneViewHolder> {
    Context context;
    List<Personne> personnes;

    public PersonneAdapter(Context context, List<Personne> personnes) {
        this.context = context;
        this.personnes = personnes;
    }


    @NonNull
    @Override
    public PersonneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ligne_personne, parent, false);
        return new PersonneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonneViewHolder holder, int position) {
        holder.lblNom.setText(this.personnes.get(position).getNom());
        holder.lblDateNaissance.setText(this.personnes.get(position).getDateNaissance());
    }

    @Override
    public int getItemCount() {
        return this.personnes.size();
    }
}
