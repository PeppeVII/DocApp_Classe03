package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import it.unisa.progettois.docapp.facade.Facade;

public class DocumentoDAO{
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public DocumentoDAO(Context context){
        dp = new DatabasePopulator(context);
        open();
    }

    public void open(){
        db = dp.getWritableDatabase();
    }

    public void close(){
        db.close();
    }


    @SuppressLint("Range")
    public List<Documento> retreiveByFiltraggio(String universita_scelta, String facolta_scelta, String insegnamento_scelto){
        List<Documento> documenti = new ArrayList<>();
        String[] selectionArgs = {universita_scelta, facolta_scelta, insegnamento_scelto};
        String query = "SELECT * FROM Documento d WHERE d.universita = ? AND d.facolta = ? AND d.corso_di_studio = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()){
            do {
                documenti.add(new Documento(cursor.getString(cursor.getColumnIndex("nome")), cursor.getString(cursor.getColumnIndex("descrizione")), cursor.getString(cursor.getColumnIndex("universita")), cursor.getString(cursor.getColumnIndex("facolta")), cursor.getString(cursor.getColumnIndex("corso_di_studio")), cursor.getString(cursor.getColumnIndex("percorso")), cursor.getInt(cursor.getColumnIndex("dimensione"))));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return documenti;
    }

    @SuppressLint("Range")
    public Documento inserisciDocumento(String nome, String descrizione, String universita, String facolta, String corso_di_studio, String percorso, int dimensione){
        Documento d;
        String[] selectionArgs = {nome, descrizione, universita, facolta, corso_di_studio, percorso, String.valueOf(dimensione)};
        String sql ="INSERT INTO Documento(nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql1 = "select * from Documento d where d.nome = ? and d.descrizione = ? AND d.universita = ? AND d.facolta = ? AND d.corso_di_studio = ? AND d.percorso = ? AND d.dimensione = ?";
        db.execSQL(sql, selectionArgs);
        Cursor cursor1 = db.rawQuery(sql1, new String[]{nome, descrizione, universita, facolta, corso_di_studio, percorso, String.valueOf(dimensione)});

        if(cursor1.moveToFirst()) {
            d = new Documento(cursor1.getString(cursor1.getColumnIndex("nome")), cursor1.getString(cursor1.getColumnIndex("descrizione")), cursor1.getString(cursor1.getColumnIndex("universita")), cursor1.getString(cursor1.getColumnIndex("facolta")), cursor1.getString(cursor1.getColumnIndex("corso_di_studio")), cursor1.getString(cursor1.getColumnIndex("percorso")), cursor1.getInt(cursor1.getColumnIndex("dimensione")));
            d.setId_documento(cursor1.getInt(cursor1.getColumnIndex("id")));
            return d;
        }
        return null;
    }

}
