package com.example.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;


public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hwSQL.db";
    public static final String TABLE_NOTES = "notes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOTA = "nota";
    public static final String COLUMN_FECHA = "fecha";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTES_TABLE = "CREATE TABLE " +  TABLE_NOTES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NOTA + " TEXT,"
                + COLUMN_FECHA + " INTEGER" + ")";

        db.execSQL(CREATE_NOTES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }

    public void addNotes(Notes notes){

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTA,notes.getNota());
        values.put(COLUMN_FECHA,notes.getFecha());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NOTES,null,values);
        db.close();

    }

    public Notes findNotes(int id){

        String query = "SELECT * FROM " + TABLE_NOTES + " WHERE " +
                COLUMN_ID  + " = " +  id;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Notes notes = new Notes();

        if (cursor.moveToFirst()){
            notes.setID(Integer.parseInt(cursor.getString(0)));
            notes.setNota(cursor.getString(1));
            notes.setFecha(Integer.parseInt(cursor.getString(2)));
        }
        else {
            notes = null;
        }
        cursor.close();
        db.close();

        return notes;
    }

    public void updateNotes(int id, String nota, int fecha){

        //String query = "UPDATE " + TABLE_NOTES + " SET nota = " + nota + ", fecha = " + fecha + " WHERE " +
        //        COLUMN_ID  + " = " +  id;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, 1);
        cv.put(COLUMN_NOTA, nota);
        cv.put(COLUMN_FECHA, fecha);
        db.update(TABLE_NOTES, cv, COLUMN_ID + "= " + id, null);

        db.close();

    }

    public boolean deleteNotes(int id){

        boolean result = false;

        String query = "SELECT * FROM  " + TABLE_NOTES + " WHERE " +
                COLUMN_ID  + " = " +  id;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Notes notes = new Notes();

        if (cursor.moveToFirst()){
            notes.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NOTES,COLUMN_ID  + " = ?", new String[] {String.valueOf(notes.getID())});
            result = true;
        }
        cursor.close();

        return result;
    }
}
