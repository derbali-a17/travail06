package ca.qc.bdeb.travail05.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.dao.IPersonneDAO;
import ca.qc.bdeb.travail05.models.dao.PersonneDAOImpl;
import ca.qc.bdeb.travail05.models.entities.Personne;
import ca.qc.bdeb.travail05.views.adapter.PersonneAdapter;

public class PersonnesActivity extends AppCompatActivity {

    TextView lblTitre;
    List<Personne> personnes;
    RecyclerView recyclerView;
    PersonneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnes);
        lblTitre = findViewById(R.id.personnes_titre);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String ville = extras.getString("ville");
            lblTitre.setText("Personnes habitans " + ville);
            int idAdresse = extras.getInt("idAdresse");
            //touver les données
            IPersonneDAO dao = new PersonneDAOImpl(this);
            personnes = dao.trouver(idAdresse);

            recyclerView = findViewById(R.id.personnes_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new PersonneAdapter(this, personnes);
            recyclerView.setAdapter(adapter);
        }
    }
}