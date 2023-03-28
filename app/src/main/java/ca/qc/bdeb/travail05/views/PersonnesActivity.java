package ca.qc.bdeb.travail05.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.dao.IPersonneDAO;
import ca.qc.bdeb.travail05.models.dao.PersonneDAOImpl;
import ca.qc.bdeb.travail05.models.entities.Personne;
import ca.qc.bdeb.travail05.views.adapter.PersonneAdapter;

public class PersonnesActivity extends AppCompatActivity {

    TextView lblTitre;
    EditText txtNom, txtDateNaissance;
    List<Personne> personnes;
    RecyclerView recyclerView;
    PersonneAdapter adapter;
    int idAdresse = 0;
    IPersonneDAO dao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnes);
        lblTitre = findViewById(R.id.personnes_titre);
        txtNom = findViewById(R.id.personne_txt_nom);
        txtDateNaissance = findViewById(R.id.personne_txt_date_naissance);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String ville = extras.getString("ville");
            lblTitre.setText("Personnes habitans " + ville);
            idAdresse = extras.getInt("idAdresse");
            //touver les données
            dao = new PersonneDAOImpl(this);
            personnes = dao.trouver(idAdresse);

            recyclerView = findViewById(R.id.personnes_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new PersonneAdapter(this, personnes);
            recyclerView.setAdapter(adapter);
        }
    }

    public void Ajouter(View view) {
        String nom = txtNom.getText().toString();
        String dateNaissance = txtDateNaissance.getText().toString();
        //persister la nouvelle personne dans la BD
        if(!nom.trim().equals("") && !dateNaissance.trim().equals("")){
            Personne personne = new Personne();
            personne.setNom(nom);
            personne.setDateNaissance(dateNaissance);
            personne  = dao.ajouter(personne, idAdresse);

            //mettre à jour la source de données de la RecyclerView
            personnes.add(personne);
            //mettre à jour l'affichage de la RecyclerView
            adapter.notifyDataSetChanged();
        }
    }
}