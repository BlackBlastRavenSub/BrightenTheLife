package com.game.blastraven.b.brightenthelife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by NodaShotaro on 2017/11/21.
 */
//ネットからパクってきたコードだから、最後は消すように!!
//DBOpenHelperクラスはSQLiteOpenHelperを継承したクラスです。このクラスは、データベースの作成と更新を行います。

public class DBOpenHelper extends SQLiteOpenHelper {
    public Context m_context;
    public static final String TAG = "DBOpenHelper";
    public static final String DB_NAME = "android_sqlite_demo";
    public static final int DB_VERSION = 1;

    public DBOpenHelper(final Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.m_context = context;
    }

    /*アプリにSQLiteファイルがない場合、onCreateメソッドが呼びだされて、SQLiteファイルが作成されます。
    SQLiteは、assetsフォルダに置いたsqlファイルを読み込んでsqlを実行します。
    下記のコードでは、以下のcreate文を実行します。
    CREATE TABLE IF NOT EXISTS dau (id integer,dau_date text,opening_price text,high_price text,low_price text,closing_price text,change_price text,deleted_at text,created_at text,updated_at text);*/
    @Override
    public void onCreate(final SQLiteDatabase db) {
        System.out.println("onCreate version : " + db.getVersion());
        System.out.println( "onCreate version : " + db.getVersion());
        this.execFileSQL(db, "create_table.sql");
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        System.out.println("onUpgrade version : " + db.getVersion());
        System.out.println("onUpgrade oldVersion : " + oldVersion);
        System.out.println("onUpgrade newVersion : " + newVersion);
    }

    /**
     * assetsフォルダのSQLファイルを実行する
     *
     * @param db
     * @param fileName
     */
    private void execFileSQL(SQLiteDatabase db, String fileName) {
        InputStream in = null;
        InputStreamReader inReader = null;
        BufferedReader reader = null;
        try {
            // 文字コード(UTF-8)を指定して、ファイルを読み込み
            in = m_context.getAssets().open(fileName);
            inReader = new InputStreamReader(in, "UTF-8");
            reader = new BufferedReader(inReader);

            // ファイル内の全ての行を処理
            String s;
            while ((s = reader.readLine()) != null) {
                // 先頭と末尾の空白除去
                s = s.trim();

                // 文字が存在する場合（空白行は処理しない）
                if (0 < s.length()) {
                    // SQL実行
                    db.execSQL(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inReader != null) {
                try {
                    inReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
