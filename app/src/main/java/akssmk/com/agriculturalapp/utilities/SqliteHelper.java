package akssmk.com.agriculturalapp.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.modals.ItemHealthCard;

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

    public ArrayList<ItemHealthCard> getHealthCard(String state,String district){
        ArrayList<ItemHealthCard> list = new ArrayList<>();
        String selectQuery = "SELECT Column2,Column5 FROM 'Table 1' where Column3='"+state+"' and Column4='"+district+"'" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemHealthCard item=new ItemHealthCard();
                item.setId(cursor.getString(0));
                item.setName(cursor.getString(1));

                list.add(item);
            } while (cursor.moveToNext());
        }

        return list;
    }

}
