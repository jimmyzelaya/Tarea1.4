package com.aplication.tarea4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aplication.tarea4.configuraciones.SQLiteConexion;
import com.aplication.tarea4.configuraciones.Transacciones;
import com.aplication.tarea4.tablas.Empleados;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView lista;
    ArrayList<Empleados> listaempleados;
    ArrayList<String> ArregloEmpleados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        conexion  = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        lista = (ListView) findViewById(R.id.lista);

        ObtenerListaEmpleados();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloEmpleados);
        lista.setAdapter(adp);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }


    private void ObtenerListaEmpleados()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados list_emple = null;
        listaempleados = new ArrayList<Empleados>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.tablaempleados,null);

        while(cursor.moveToNext())
        {
            list_emple = new Empleados();

            list_emple.setId(cursor.getInt(0));                 //ID
            list_emple.setNombres(cursor.getString(1));         //Nombre
            list_emple.setDescripcion(cursor.getString(2));     //Descripcion


            listaempleados.add(list_emple);
        }

        cursor.close();

        llenalista();
    }

    private void llenalista()
    {
        ArregloEmpleados = new ArrayList<String>();

        for(int i=0; i<listaempleados.size(); i++)
        {
            ArregloEmpleados.add(listaempleados.get(i).getId() +" | "+
                    listaempleados.get(i).getNombres() +" | "+
                    listaempleados.get(i).getDescripcion());
        }

    }
}