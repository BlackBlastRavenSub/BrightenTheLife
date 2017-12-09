package com.game.blastraven.b.brightenthelife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import java.io.File;

/**
 * Created by NodaShotaro on 2017/11/21.
 */
//ネットからパクってきたコードだから、最後は消すように!!

public class DBHelper {
    public static final String TAG = "DBHelper";

    public SQLiteDatabase db;
    private final DBOpenHelper dbOpenHelper;

    public DBHelper(final Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
        establishDb();
    }

    private void establishDb() {
        if (this.db == null) {
            this.db = this.dbOpenHelper.getWritableDatabase();//this.dbOpenHelper.getWritableDatabase();でデータベースに接続します。
        }
    }

    public void cleanup() {
        if (this.db != null) {
            this.db.close();
            this.db = null;
        }
    }

    /**
     * Databaseが削除できればtrue。できなければfalse
     * @param context
     * @return
     */
    public boolean isDatabaseDelete(final Context context) {
        boolean result = false;
        if (this.db != null) {
            File file = context.getDatabasePath(dbOpenHelper.getDatabaseName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                result = this.db.deleteDatabase(file);
            }
        }
        return result;
    }
}
