package com.game.blastraven.b.brightenthelife;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.junit.Test;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;


/**
 * Created by NodaShotaro on 2017/11/21.
 */
//ネットからパクってきたコードだから、最後は消すように!!
public class DBHelperTest extends AppCompatActivity {


    DBHelper dBHelper = null;

    @Test
    public void cleanup() throws Exception {
    }

    @Test
    public void isDatabaseDelete() throws Exception {
        try {
            dBHelper = new DBHelper(getApplicationContext());
            boolean result = dBHelper.isDatabaseDelete(getApplicationContext());
            Log.d(TAG, " delete result : " + result);
        } catch (
                Exception e)

        {
            Log.d(TAG, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Test
    //DBHelperとDBOpenHelperを使ってデータベースを作成します。
    public void add() throws Exception {
        System.out.println("addメソッド開始");
        Log.v(TAG, "addメソッド開始");
        try {
            dBHelper = new DBHelper(getApplicationContext());
        } catch (
                Exception e) {
            Log.v(TAG, e.getMessage());
            System.out.println(e.getMessage());
        }
        Log.v(TAG, "addメソッド終了");
    }

    public void delete() throws Exception {
        //上記で作成したデータベースを削除します。
        //DBHelper dBHelper = null;
        try {
            dBHelper = new DBHelper(getApplicationContext());
            boolean result = dBHelper.isDatabaseDelete(getApplicationContext());
            Log.d(TAG, " delete result : " + result);
            System.out.println(" delete result : " + result);
        } catch (
                Exception e)

        {
            Log.d(TAG, e.getMessage());
            System.out.println(e.getMessage());
        }
    }


}