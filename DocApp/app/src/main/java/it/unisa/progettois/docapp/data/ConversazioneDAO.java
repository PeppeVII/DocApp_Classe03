package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConversazioneDAO {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public ConversazioneDAO(Context context){
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
    public List<Studente> getNicknameDestinatari(String email){
        String[] selectionArgs = {email};
        String query = "SELECT * FROM Studente s JOIN Conversazione c ON s.email = c.nome_conversazione WHERE c.studente = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        List<Studente> destinatari = new ArrayList<>();

        boolean tmp = false;

        while (cursor.moveToNext()){
            int is_admin = cursor.getInt(cursor.getColumnIndex("is_admin"));
            if (is_admin == 1)
                tmp = true;

            Studente studente = new Studente(cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("nickname")), cursor.getString(cursor.getColumnIndex("password")), tmp);

            destinatari.add(studente);
        }

        return destinatari;
    }

    public int getId_Conversazione(String destinatario, String mittente){
        String[] selectionArgs = {destinatario, mittente};
        String query = "SELECT c.id FROM Conversazione c WHERE c.nome_conversazione = ? AND c.studente = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(0);
            return id;
        }
        return 0;
    }
}
