package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="Contactsdb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="contacts";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String PHONE_NUMBER="phone_number";



    public DbHelper( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + PHONE_NUMBER + " TEXT" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long insertContacts(Model model){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,model.getName());
        values.put(PHONE_NUMBER,model.getPhone_number());
        long query=sqLiteDatabase.insert(TABLE_NAME,null,values);
        return query;
    }
    public ArrayList<Model>viewContancts(){
        ArrayList<Model>list=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone_number=cursor.getString(2);


            Model m=new Model();
            m.setId(id);
            m.setName(name);
            m.setPhone_number(phone_number);

            list.add(m);

        }
        cursor.close();
        db.close();
        return list;
    }
    public void DeleteContacts(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        String deletequery=ID + "=" + id;
        db.delete(TABLE_NAME,deletequery,null);
    }
    public int updateContacts(Model model){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID, model.getId());
        contentValues.put(NAME,model.getName());
        contentValues.put(PHONE_NUMBER,model.getPhone_number());
        String updatequery=ID+"="+model.getId();
        db.update(TABLE_NAME,contentValues,updatequery,null);


        return 0;
    }
}
