package com.example.nangyalkhan.todolist;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Nangyal Khan on 4/12/2015.
 */
public class DataTra {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public DataTra(Context ctx, String value)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("LIST",value);
        database.insert(dbHelper.TABLE,"",values);
        database.close();
    }
    public DataTra() {
    }

    public String[] GetList(Context ctx)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM ACTIVITY");
        cur.moveToFirst();
        String List[] = new String[cur.getCount()];
        int i=0;
        do{
            List[i]  = cur.getString(cur.getColumnIndex("LIST"));
            i++;
        }while (cur.moveToNext());
        return List;
    }
}
