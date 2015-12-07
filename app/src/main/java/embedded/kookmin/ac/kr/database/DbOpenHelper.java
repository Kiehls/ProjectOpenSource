package embedded.kookmin.ac.kr.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 승수 on 2015-11-22.
 */
public class DbOpenHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "addressbook.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "contestList";

    public DbOpenHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //처음 DB를 생성할 떄
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT , contestName text UNIQUE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertContestName(String name){
        SQLiteDatabase database = getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME
                + "(contestName) VALUES('" + name + "');";
        try {
            database.execSQL(query);
        } catch (Exception ex) {
            Log.e("error", "Exception in Drop address table  SQL" + ex.toString());
        }
    }

    public void insertContestInfo(String tableName, String need, int num, String comm) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("needPerson", need);
        values.put("numPerson", num);
        values.put("comments", comm);

        database.insert(tableName, null, values);
    }

    public void subOnCreate(SQLiteDatabase db, String tableName) {
        //db.execSQL("DROP TABLE IF EXISTS " + tableName);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, needPerson text, numPerson text, comments text)");
    }
}

