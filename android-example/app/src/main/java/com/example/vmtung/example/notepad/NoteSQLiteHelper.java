package com.example.vmtung.example.notepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vmtung on 24/08/2017.
 */

public class NoteSQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SmartNote.db";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + NoteContract.Note.TABLE_NAME + " (" +
                    NoteContract.Note._ID + " INTEGER PRIMARY KEY," +
                    NoteContract.Note.COLUMN_NAME_TITLE + " TEXT," +
                    NoteContract.Note.COLUMN_NAME_CONTENT + " TEXT)";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + NoteContract.Note.TABLE_NAME;

    public NoteSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
