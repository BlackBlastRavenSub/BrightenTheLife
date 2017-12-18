package com.game.blastraven.b.brightenthelife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.game.blastraven.b.brightenthelife.BuildConfig;
import com.game.blastraven.b.brightenthelife.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NodaShotaro on 2017/12/18.
 */

public class DBAdd {

    public static final String TAG = "DBAdd";

    /**
     * return Dau List
     *
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @return the list objects of rows, null otherwise.
     */
    public static List<Dau> getDauList(final Context context) {
        List<Dau> list = new ArrayList<Dau>();
        Dau dau = null;
        Cursor c = null;
        DBHelper dBHelper = null;
        try {
            dBHelper = new DBHelper(context);

            StringBuffer sql = new StringBuffer();
            sql.append("select ");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[1] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[2] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[3] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[4] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[5] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[6] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[7] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[8] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[9]);
            sql.append(" from ");
            sql.append(" " + Dau.TABLE_NAME + " " + Dau.TABLE_NAME_OMISSION);

            if (BuildConfig.DEBUG) {
                Log.d(TAG, "sql : " + sql.toString());
            }

            c = dBHelper.db.rawQuery(sql.toString(), null);

            boolean isResult = c.moveToFirst();

            while (isResult) {
                dau = new Dau();
                dau.id = c.getString(0);
                dau.dau_date = c.getString(1);
                dau.opening_price = c.getString(2);
                dau.high_price = c.getString(3);
                dau.low_price = c.getString(4);
                dau.closing_price = c.getString(5);
                dau.change_price = c.getString(6);
                dau.deleted_at = c.getString(7);
                dau.created_at = c.getString(8);
                dau.updated_at = c.getString(9);
                list.add(dau);
                isResult = c.moveToNext();
            }

        } catch (Exception e) {
            Log.e(TAG, "error occured!! cause : " + e.getMessage());
        } finally {

            if (c != null) {
                c.close();
            }

            if (dBHelper != null) {
                dBHelper.cleanup();
            }
        }
        return list;
    }

    /**
     * return Dau
     *
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param id Dau's id
     * @return the object of rows affected if id is passed in, null otherwise.
     */
    public static Dau getDau(final Context context, final String id) {
        Dau dau = null;
        Cursor c = null;
        DBHelper dBHelper = null;
        try {
            dBHelper = new DBHelper(context);

            StringBuffer sql = new StringBuffer();
            sql.append("select ");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[1] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[2] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[3] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[4] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[5] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[6] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[7] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[8] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[9]);
            sql.append(" from ");
            sql.append(" " + Dau.TABLE_NAME + " " + Dau.TABLE_NAME_OMISSION);
            sql.append(" where " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + "="" +  id + """);
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "sql" + sql.toString());
            }

            c = dBHelper.db.rawQuery(sql.toString(), null);

            boolean isResult = c.moveToFirst();

            if (isResult) {
                dau = new Dau();
                dau.id = c.getString(0);
                dau.dau_date = c.getString(1);
                dau.opening_price = c.getString(2);
                dau.high_price = c.getString(3);
                dau.low_price = c.getString(4);
                dau.closing_price = c.getString(5);
                dau.change_price = c.getString(6);
                dau.deleted_at = c.getString(7);
                dau.created_at = c.getString(8);
                dau.updated_at = c.getString(9);
                isResult = c.moveToNext();
            }

        } catch (Exception e) {
            Log.e(TAG, "error occured!! cause : " + e.getMessage());
        } finally {

            if (c != null) {
                c.close();
            }

            if (dBHelper != null) {
                dBHelper.cleanup();
            }
        }
        return dau;
    }

    /**
     * update
     *
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param contentValues
     * @param id is primary key
     * @return the number of rows affected
     */
    public static long update(final Context context, final ContentValues contentValues, String id) {
        DBHelper dBHelper = new DBHelper(context);
        long result = dBHelper.db.update(Dau.TABLE_NAME, contentValues, Dau.COL[0] + "=" + id, null);
        dBHelper.cleanup();
        return result;
    }

    /**
     * insert
     *
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param contentValues
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    public static long insert(final Context context, final ContentValues contentValues) {
        DBHelper dBHelper = new DBHelper(context);
        long result = dBHelper.db.insert(Dau.TABLE_NAME, null, contentValues);
        dBHelper.cleanup();
        return result;
    }

    /**
     * delete
     *
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param id is primary key
     * @return the number of rows affected if a whereClause is passed in, 0
     *         otherwise. To remove all rows and get a count pass "1" as the
     *         whereClause.
     */
    public static long delete(final Context context, String id) {
        DBHelper dBHelper = new DBHelper(context);
        int result = dBHelper.db.delete(Dau.TABLE_NAME, Dau.COL[0] + "=" + id, null);
        dBHelper.cleanup();
        return result;
    }
}