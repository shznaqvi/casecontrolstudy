package edu.aku.hassannaqvi.casecontrolstudyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.casecontrolstudyproject.FormsContract.singleForm;
import edu.aku.hassannaqvi.casecontrolstudyproject.UsersContract.singleUser;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT );";
    private static final String DATABASE_NAME = "virband.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + singleForm.TABLE_NAME + "("
            + singleForm._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleForm.COLUMN_NAME_UID + " TEXT,"
            + singleForm.COLUMN_NAME_DEVICE_ID + " TEXT,"
            + singleForm.COLUMN_NAME_PROJECT_NAME + " TEXT,"
            //+ singleForm.COLUMN_NAME_SURVEY_TYPE + " TEXT,"
            + singleForm.COLUMN_NAME_GPS_ACC + " TEXT,"
            + singleForm.COLUMN_NAME_GPS_LAT + " TEXT,"
            + singleForm.COLUMN_NAME_GPS_LNG + " TEXT,"
            + singleForm.COLUMN_NAME_GPS_TIME + " TEXT,"
            + singleForm.COLUMN_NAME_SYNCED + " TEXT,"
            + singleForm.COLUMN_NAME_SYNCED_DATE + " TEXT,"
            + singleForm.COLUMN_NAME_FORM_DATE + " TEXT,"
            + singleForm.COLUMN_NAME_INTERVIEWER + " TEXT,"
            + singleForm.COLUMN_NAME_AREA_CODE + " TEXT,"
            + singleForm.COLUMN_NAME_SUBAREA_CODE + " TEXT,"
            + singleForm.COLUMN_NAME_ISTATUS + " TEXT,"

            //+ singleForm.COLUMN_NAME_SA + " TEXT,"
            + singleForm.COLUMN_NAME_SB + " TEXT,"
            + singleForm.COLUMN_NAME_SC + " TEXT,"
            + singleForm.COLUMN_NAME_SD + " TEXT,"

            + singleForm.COLUMN_NAME_SIC + " TEXT"
            + " );";
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + singleForm.TABLE_NAME;
    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");


                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, userName);
                values.put(singleUser.ROW_PASSWORD, password);
                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleForm.COLUMN_NAME_PROJECT_NAME, fc.getProjectName());
        //values.put(singleForm.COLUMN_NAME_SURVEY_TYPE, fc.getProjectName());
        values.put(singleForm.COLUMN_NAME_DEVICE_ID, fc.getDeviceID());
        values.put(singleForm.COLUMN_NAME_GPS_ACC, fc.getGpsAcc());
        values.put(singleForm.COLUMN_NAME_GPS_LAT, fc.getGpsLat());
        values.put(singleForm.COLUMN_NAME_GPS_LNG, fc.getGpsLng());
        values.put(singleForm.COLUMN_NAME_GPS_TIME, fc.getGpsTime());
        values.put(singleForm.COLUMN_NAME_FORM_DATE, fc.getFormDate());
        values.put(singleForm.COLUMN_NAME_INTERVIEWER, fc.getInterviewer());
        values.put(singleForm.COLUMN_NAME_AREA_CODE, fc.getAreacode());
        values.put(singleForm.COLUMN_NAME_SUBAREA_CODE, fc.getSubareacode());
        values.put(singleForm.COLUMN_NAME_HOUSEHOLD, fc.getHousehold());
        values.put(singleForm.COLUMN_NAME_ISTATUS, fc.getIstatus());
        //values.put(singleForm.COLUMN_NAME_SA, fc.getsA());
        values.put(singleForm.COLUMN_NAME_SB, fc.getsB());
        values.put(singleForm.COLUMN_NAME_SC, fc.getsC());
        values.put(singleForm.COLUMN_NAME_SD, fc.getsD());
        values.put(singleForm.COLUMN_NAME_SIC, fc.getsIC());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleForm.TABLE_NAME,
                singleForm.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public void updateForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleForm.COLUMN_NAME_SYNCED, true);
        values.put(singleForm.COLUMN_NAME_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleForm._ID + " LIKE ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleForm.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleForm._ID,
                singleForm.COLUMN_NAME_UID,
                singleForm.COLUMN_NAME_PROJECT_NAME,
                //singleForm.COLUMN_NAME_SURVEY_TYPE,
                singleForm.COLUMN_NAME_DEVICE_ID,
                singleForm.COLUMN_NAME_GPS_LAT,
                singleForm.COLUMN_NAME_GPS_LNG,
                singleForm.COLUMN_NAME_GPS_ACC,
                singleForm.COLUMN_NAME_GPS_TIME,
                singleForm.COLUMN_NAME_SYNCED,
                singleForm.COLUMN_NAME_SYNCED_DATE,
                singleForm.COLUMN_NAME_FORM_DATE,
                singleForm.COLUMN_NAME_INTERVIEWER,
                singleForm.COLUMN_NAME_AREA_CODE,
                singleForm.COLUMN_NAME_SUBAREA_CODE,
                singleForm.COLUMN_NAME_HOUSEHOLD,
                singleForm.COLUMN_NAME_ISTATUS,
                //singleForm.COLUMN_NAME_SA,
                singleForm.COLUMN_NAME_SB,
                singleForm.COLUMN_NAME_SC,
                singleForm.COLUMN_NAME_SD,
                singleForm.COLUMN_NAME_SIC,


        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                singleForm._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    singleForm.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getTodayForms() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleForm._ID,
                singleForm.COLUMN_NAME_AREA_CODE,
                singleForm.COLUMN_NAME_SUBAREA_CODE,
                singleForm.COLUMN_NAME_HOUSEHOLD,
        };

        String whereClause = singleForm.COLUMN_NAME_AREA_CODE + " LIKE ?";
        String[] whereArgs = {spDateT};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleForm._ID + " ASC";

        Collection<FormsContract> formList = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    singleForm.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }


        // return contact list
        return formList;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }

    }
}