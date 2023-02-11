package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class StudenteDAO {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public StudenteDAO(Context context){
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
    public Studente effettuaLogin(String email, String password){
        Studente studente;
        boolean is_admin = false;

        Cursor cursor = db.rawQuery(
                "select * from Studente s" + " where s.email = ? and s.password = ? ", new String[]{email, password});

        if(cursor.moveToFirst()) {
            int tmp = cursor.getInt(cursor.getColumnIndex("is_admin"));
            if(tmp == 1)
                is_admin = true;

            studente = new Studente(cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("nickname")), cursor.getString(cursor.getColumnIndex("password")), is_admin);
            return studente;
        }
        return null;
    }

    public String getNickname(String email){
        String[] selectionArgs = {email};
        String query = "SELECT Studente.nickname FROM Studente WHERE Studente.email = ?";

        Cursor cursor = db.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()){
            @SuppressLint("Range") String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            return nickname;
        }
        return null;
    }
}
