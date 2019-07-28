package com.example.to_do.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class Taskhelper extends SQLiteOpenHelper {

        public Taskhelper(Context context) {
            super(context, Taskaccess.DB_NAME, null, Taskaccess.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + Taskaccess.TaskEntry.TABLE + " ( " +
                    Taskaccess.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Taskaccess.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Taskaccess.TaskEntry.TABLE);
            onCreate(db);
        }
    }

