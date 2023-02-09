package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import it.unisa.progettois.docapp.facade.Facade;

public class FeedbackDAO implements Facade {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public FeedbackDAO(Context context){
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
        db.execSQL("INSERT INTO Feedback (documento, studente) VALUES (?,?)");
        return true;
    }

    @SuppressLint("Range")
    @Override
    public Object ottieni(int id, String email) {
        Feedback feedback = new Feedback();
        String[] selectionArgs = {String.valueOf(id), email};
        String query = "SELECT * FROM Feedback f WHERE f.documento = ? AND f.studente = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()) {
            feedback = new Feedback(cursor.getInt(cursor.getColumnIndex("documento")), cursor.getString(cursor.getColumnIndex("studente")));
            return feedback;
        }
        return null;
    }
}
