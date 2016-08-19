package akssmk.com.agriculturalapp.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by sukhbir on 19/8/16.
 */
public class SqliteHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "soil_lab";
    private static final int DATABASE_VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<String> getDistinctStates(){
        ArrayList<String> list = new ArrayList<String>();
        String selectQuery = "SELECT distinct Column3 FROM 'Table 1'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        list.add("Select State");

        if (cursor.move(3)) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public ArrayList<String> getDistricts(String state){
        ArrayList<String> list = new ArrayList<String>();
        String selectQuery = "SELECT  distinct Column4 FROM 'Table 1' where Column3='"+state+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        list.add("Select District");

        if (cursor.moveToFirst()) {
            do {
                Log.v("district",cursor.getString(0));
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public ArrayList<String> getHealthCard(String state,String district){
        ArrayList<String> list = new ArrayList<String>();
        String selectQuery = "SELECT  distinct Column4 FROM 'Table 1' where Column3='"+state+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        list.add("Select District");

        if (cursor.moveToFirst()) {
            do {
                Log.v("district",cursor.getString(0));
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public Cursor getData() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"'State'", "'District'"};
        String sqlTables = "'Table 1'";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;
    }
}
