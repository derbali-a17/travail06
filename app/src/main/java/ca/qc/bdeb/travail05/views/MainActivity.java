package ca.qc.bdeb.travail05.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ca.qc.bdeb.travail05.R;
import ca.qc.bdeb.travail05.models.dao.AdresseDAOImpl;
import ca.qc.bdeb.travail05.models.dao.IAdresseDAO;
import ca.qc.bdeb.travail05.models.dao.IPersonneDAO;
import ca.qc.bdeb.travail05.models.dao.PersonneDAOImpl;
import ca.qc.bdeb.travail05.models.entities.Adresse;
import ca.qc.bdeb.travail05.models.entities.Personne;
import ca.qc.bdeb.travail05.views.adapter.AdresseAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdresseAdapter adapter;
    List<Adresse> adresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //trouver les données
        IAdresseDAO dao = new AdresseDAOImpl(this);
        adresses = dao.trouver();

        recyclerView = findViewById(R.id.main_rv_adresses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdresseAdapter(this, adresses);
        recyclerView.setAdapter(adapter);
    }
}