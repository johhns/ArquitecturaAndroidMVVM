package com.developer.johhns.arquitecturaandroidmvvm;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotaRepositorio {

    private NotaDAO notaDAO ;
    private LiveData<List<Nota>> todasLasNotas ;

    public NotaRepositorio(Context contexto){
        NotaDB db = NotaDB.getInstancia( contexto.getApplicationContext() ) ;
        notaDAO   = db.notaDAO();
        todasLasNotas = notaDAO.obtenerTodasLasNotas();
    }

    public void insertar( Nota nota ){
      new InsertarNotasTareaAsicrona(notaDAO).execute(nota);
    }

    public void actualizar( Nota nota ) {
      new ActualizarNotasTareaAsicrona(notaDAO).execute(nota);
    }

    public void eliminar( Nota nota ) {
      new EliminarNotasTareaAsicrona(notaDAO).execute(nota);
    }

    public void eliminarTodasLasNotas(){
       new EliminarTodasLasNotasTareaAsicrona(notaDAO).execute();
    }

    public LiveData<List<Nota>> obtenerTodasLasNotas(){
        return  todasLasNotas ;
    }

    private static class InsertarNotasTareaAsicrona extends AsyncTask<Nota,Void,Void>{

        private NotaDAO notaDAO ;

        private InsertarNotasTareaAsicrona( NotaDAO notaDAO ){
            this.notaDAO = notaDAO ;
        }

        @Override
        protected Void doInBackground(Nota... notas) {
            notaDAO.insertar(notas[0]);
            return null ;
        }
    }

    private static class ActualizarNotasTareaAsicrona extends AsyncTask<Nota,Void,Void>{

        private NotaDAO notaDAO ;

        private ActualizarNotasTareaAsicrona( NotaDAO notaDAO ){
            this.notaDAO = notaDAO ;
        }

        @Override
        protected Void doInBackground(Nota... notas) {
            notaDAO.actualizar(notas[0]);
            return null ;
        }
    }

    private static class EliminarNotasTareaAsicrona extends AsyncTask<Nota,Void,Void>{

        private NotaDAO notaDAO ;

        private EliminarNotasTareaAsicrona( NotaDAO notaDAO ){
            this.notaDAO = notaDAO ;
        }

        @Override
        protected Void doInBackground(Nota... notas) {
            notaDAO.eliminar(notas[0]);
            return null ;
        }
    }

    private static class EliminarTodasLasNotasTareaAsicrona extends AsyncTask<Void,Void,Void>{

        private NotaDAO notaDAO ;

        private EliminarTodasLasNotasTareaAsicrona( NotaDAO notaDAO ){
            this.notaDAO = notaDAO ;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            notaDAO.eliminarTodasLasNotas();
            return null ;
        }
    }


}


















