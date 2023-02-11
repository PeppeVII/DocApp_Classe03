package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import it.unisa.progettois.docapp.facade.Facade;

public class Documenti_VisualizzatiDAO implements Facade {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public Documenti_VisualizzatiDAO(Context context){
        dp = new DatabasePopulator(context);
        open();
    }

    public void open(){
        db = dp.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    @Override
    public boolean inserisci(int id, String email) {
        String[] selectionArgs = {String.valueOf(id), email};
        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (?,?)");
        return true;
    }

    @SuppressLint("Range")
    @Override
    public Object ottieni(int id, String email) {
        Documenti_Visualizzati documenti_visualizzati = new Documenti_Visualizzati();
        String[] selectionArgs = {String.valueOf(id), email};
        String query = "SELECT * FROM DocumentiVisualizzati dv WHERE dv.documento = ? AND dv.studente = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()) {
            documenti_visualizzati = new Documenti_Visualizzati(cursor.getInt(cursor.getColumnIndex("documento")), cursor.getString(cursor.getColumnIndex("studente")));
            return documenti_visualizzati;
        }
        return null;
    }

    @SuppressLint("Range")
    public List<Documento> getDocumentiPertinenti(){
        String query = "SELECT documento, COUNT(documento) as views FROM DocumentiVisualizzati GROUP BY documento ORDER BY views DESC LIMIT 5";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Documento> lista_documenti = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int views = cursor.getInt(1);
            Documento d;
            String[] selectionArgs = {String.valueOf(id)};
            String sql = "SELECT * FROM Documento d WHERE d.id = ?";
            Cursor cursor1 = db.rawQuery(sql, selectionArgs);

            if(cursor1.moveToFirst()) {
                d = new Documento(cursor1.getString(cursor1.getColumnIndex("nome")), cursor1.getString(cursor1.getColumnIndex("descrizione")), cursor1.getString(cursor1.getColumnIndex("universita")), cursor1.getString(cursor1.getColumnIndex("facolta")), cursor1.getString(cursor1.getColumnIndex("corso_di_studio")), cursor1.getString(cursor1.getColumnIndex("percorso")), cursor1.getInt(cursor1.getColumnIndex("dimensione")));
                d.setId_documento(cursor1.getInt(cursor1.getColumnIndex("id")));
                lista_documenti.add(d);
            }
        }
        return lista_documenti;
    }
}
