package com.developer.johhns.arquitecturaandroidmvvm;


import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

public class NotaViewModel extends ViewModel {

    private NotaRepositorio repositorio;
    private LiveData<List<Nota>> todasLasNotas;
    Aplicacion aplicacion = new Aplicacion() ;

    public NotaViewModel() {
        super();
        this.repositorio = new NotaRepositorio( aplicacion );
        this.todasLasNotas = repositorio.obtenerTodasLasNotas();
    }



    public void insertar(Nota nota) {
        repositorio.insertar(nota);
    }

    public void actualizar(Nota nota) {
        repositorio.actualizar(nota);
    }

    public void eliminar(Nota nota) {
        repositorio.eliminar(nota);
    }

    public void eliminarTodasLasNotas() {
        repositorio.eliminarTodasLasNotas();
    }

    public LiveData<List<Nota>> obtenerTodasLasNotas()  {
        return todasLasNotas;
    }

}
