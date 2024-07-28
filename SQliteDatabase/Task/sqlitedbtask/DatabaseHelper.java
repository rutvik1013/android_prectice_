package com.example.sqlitedbtask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "detailddb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "details";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final String ADRESS = "adress";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE " + TABLE_NAME + " (" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " TEXT, " + NAME + " TEXT, " + PHONE_NUMBER + " TEXT, " + EMAIL + " TEXT, " + ADRESS + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertdetails(detailsModel model) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, model.getDate());
        values.put(NAME, model.getName());
        values.put(PHONE_NUMBER, model.getPhone_number());
        values.put(EMAIL, model.getEmail());
        values.put(ADRESS, model.getAdress());
        long query=sqLiteDatabase.insert(TABLE_NAME,null,values);
        return query;
    }

    public ArrayList<detailsModel> viewdetails() {
        ArrayList<detailsModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(ID));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(DATE));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(NAME));
            String phone_number = cursor.getString(cursor.getColumnIndexOrThrow(PHONE_NUMBER));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL));
            String adress = cursor.getString(cursor.getColumnIndexOrThrow(ADRESS));

            detailsModel model = new detailsModel();
            model.setId(id);
            model.setDate(date);
            model.setName(name);
            model.setPhone_number(phone_number);
            model.setEmail(email);
            model.setAdress(adress);

            list.add(model);
        }
        cursor.close();
        db.close();

        return list;
    }

    public void Deletedetails(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deletequery=ID + "=" + id;
        db.delete(TABLE_NAME,deletequery,null);

    }

    public int UpdateDetails(detailsModel model) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE, model.getDate());
        contentValues.put(NAME, model.getName());
        contentValues.put(PHONE_NUMBER, model.getPhone_number());
        contentValues.put(EMAIL, model.getEmail());
        contentValues.put(ADRESS, model.getAdress());
        String updatequery=ID+"="+model.getId();
        sqLiteDatabase.update(TABLE_NAME,contentValues,updatequery,null);

        return 0;
    }
}
