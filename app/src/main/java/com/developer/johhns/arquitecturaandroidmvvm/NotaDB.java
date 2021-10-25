package com.developer.johhns.arquitecturaandroidmvvm;


import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Nota.class} , version = 1 , exportSchema = false)
public abstract class NotaDB extends RoomDatabase {

    private static NotaDB instancia ;
    public abstract NotaDAO notaDAO() ;

    public static synchronized NotaDB getInstancia( Context contexto ){
        if ( instancia == null ) {
           instancia = Room.databaseBuilder(contexto.getApplicationContext() , NotaDB.class , "notas_db" )
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
            notaDAO.insertar( new Nota( "Anotacion 10", "Texto de la nota 10", 5 ) );
            notaDAO.insertar( new Nota( "Anotacion 11", "Texto de la nota 11", 5 ) );
            notaDAO.insertar( new Nota( "Anotacion 12", "Texto de la nota 12", 6 ) );
            notaDAO.insertar( new Nota( "Anotacion 13", "Texto de la nota 12", 6 ) );
            notaDAO.insertar( new Nota( "Anotacion 14", "Texto de la nota 14", 7 ) );
            notaDAO.insertar( new Nota( "Anotacion 15", "Texto de la nota 15", 7 ) );
            notaDAO.insertar( new Nota( "Anotacion 16", "Texto de la nota 16", 7 ) );
            notaDAO.insertar( new Nota( "Anotacion 17", "Texto de la nota 17", 7 ) );
            notaDAO.insertar( new Nota( "Anotacion 18", "Texto de la nota 18", 8 ) );
            notaDAO.insertar( new Nota( "Anotacion 19", "Texto de la nota 19", 8 ) );
            notaDAO.insertar( new Nota( "Anotacion 20", "Texto de la nota 20", 9 ) );
            notaDAO.insertar( new Nota( "Anotacion 21", "Texto de la nota 21", 9 ) );
            return null ;
        }

    }

}
