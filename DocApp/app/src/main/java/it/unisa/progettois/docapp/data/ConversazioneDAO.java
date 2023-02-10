package it.unisa.progettois.docapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
