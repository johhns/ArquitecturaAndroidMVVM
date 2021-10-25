package com.developer.johhns.arquitecturaandroidmvvm;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NotaViewModel notaViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View vista  = findViewById(R.id.contenido) ;
        RecyclerView recView = findViewById( R.id.recView1 ) ;
        recView.setLayoutManager( new LinearLayoutManager(this));
        recView.setHasFixedSize(true);

        NotaAdaptador adaptador = new NotaAdaptador() ;

        recView.setAdapter( adaptador );

        notaViewModel = new ViewModelProvider(this ).get(NotaViewModel.class) ;
        notaViewModel.obtenerTodasLasNotas().observe( this , new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> notas) {
                Snackbar.make( vista ,"onChange", Snackbar.LENGTH_LONG ).show();
                adaptador.inicializarNotas(notas);
            }
        }); ;

    }
}