package com.developer.johhns.arquitecturaandroidmvvm;

import android.app.Application;
import android.content.Context;

public class Aplicacion extends Application {

    private static Context contextoApp ;

    @Override
    public void onCreate() {
        super.onCreate();
        Aplicacion.contextoApp = getApplicationContext() ;
    }

    public static Context  contextoAplicacion(){
        return contextoApp ;
    }


}
