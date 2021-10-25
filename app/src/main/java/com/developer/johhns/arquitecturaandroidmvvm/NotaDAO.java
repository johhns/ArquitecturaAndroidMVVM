package com.developer.johhns.arquitecturaandroidmvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotaDAO {

    @Insert
    void insertar( Nota nota ) ;

    @Update
    void actualizar( Nota nota ) ;

    @Delete
    void eliminar( Nota nota ) ;

    @Query("Delete From notas")
    void eliminarTodasLasNotas();

    @Query("Select * From notas Order By id ")
    LiveData<List<Nota>>  obtenerTodasLasNotas() ;

}
