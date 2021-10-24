package com.developer.johhns.arquitecturaandroidmvvm;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Nota.class} , version = 1)
public abstract class NotaDB extends RoomDatabase {

    private static NotaDB instancia ;

    public abstract NotaDAO notaDAO() ;

    public static synchronized NotaDB getInstancia(Context contexto){
        if ( instancia == null ) {
           instancia = Room.databaseBuilder( contexto.getApplicationContext() , NotaDB.class , "notas_db" )
                           .fallbackToDestructiveMigration()
                           .addCallback(roomCallbac)
                           .build();
        }
        return instancia ;
    }

    private static RoomDatabase.Callback roomCallbac = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PoblarBaseDatosTareaAsincrona(instancia).execute();
        }
    } ;

    private static class PoblarBaseDatosTareaAsincrona extends AsyncTask<Void,Void,Void> {

        private NotaDAO notaDAO ;

        private PoblarBaseDatosTareaAsincrona( NotaDB notaDB ){
            notaDAO = notaDB.notaDAO();
        }

        @Override
        protected Void doInBackground( Void... voids ){
            notaDAO.insertar( new Nota( "Anotacion 1", "Texto de la nota 1", 1 ) );
            notaDAO.insertar( new Nota( "Anotacion 2", "Texto de la nota 2", 1 ) );
            notaDAO.insertar( new Nota( "Anotacion 3", "Texto de la nota 3", 2 ) );
            notaDAO.insertar( new Nota( "Anotacion 4", "Texto de la nota 4", 3 ) );
            notaDAO.insertar( new Nota( "Anotacion 5", "Texto de la nota 5", 3 ) );
            notaDAO.insertar( new Nota( "Anotacion 6", "Texto de la nota 6", 4 ) );
            notaDAO.insertar( new Nota( "Anotacion 7", "Texto de la nota 7", 4 ) );
            notaDAO.insertar( new Nota( "Anotacion 8", "Texto de la nota 8",  5) );
            notaDAO.insertar( new Nota( "Anotacion 9", "Texto de la nota 9", 5 ) );
            return null ;
        }

    }

}
