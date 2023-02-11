package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MessaggioDAO {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public MessaggioDAO(Context context){
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
    public List<Messaggio> getMessaggioByTime(){
        String query = "SELECT * FROM Messaggio m ORDER BY m.timestamp_msg ASC";
        Cursor cursor = db.rawQuery(query, null);
        List<Messaggio> list = new ArrayList<>();

        while(cursor.moveToNext()){
            Messaggio messaggio = new Messaggio(cursor.getInt(cursor.getColumnIndex("conversazione")), cursor.getString(cursor.getColumnIndex("studente")), cursor.getString(cursor.getColumnIndex("testo")), cursor.getString(cursor.getColumnIndex("timestamp_msg")));
            messaggio.setId_messaggio(cursor.getInt(cursor.getColumnIndex("id")));
            list.add(messaggio);
        }
        return list;
    }

    public boolean inserimentoMessaggio(int conversazione, String studente, String testo){
        String[] selectionArgs = {String.valueOf(conversazione), studente, testo};
        String query = "INSERT INTO Messaggio(conversazione, studente, testo) VALUES (?, ?, ?)";
        db.execSQL(query, selectionArgs);
        return true;
    }
}
