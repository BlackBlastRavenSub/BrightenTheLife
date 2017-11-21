package com.game.blastraven.b.brightenthelife;

import android.util.Log;

import org.junit.Test;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;

/**
 * Created by NodaShotaro on 2017/11/21.
 */
//ネットからパクってきたコードだから、最後は消すように!!
public class DBHelperTest {

    DBHelper dBHelper = null;
    @Test
    public void cleanup() throws Exception {
    }

    @Test
    public void isDatabaseDelete() throws Exception {
    }

    @Test
    //DBHelperとDBOpenHelperを使ってデータベースを作成します。
    public void add() throws Exception {
        try{
            dBHelper = new DBHelper(getApplicationContext());
        } catch(
                Exception e)

        {
            Log.d(TAG, e.getMessage());
        }
    }
    public void delete() throws Exception {
        //上記で作成したデータベースを削除します。
        //DBHelper dBHelper = null;
        try{
            dBHelper = new DBHelper(getApplicationContext());
            boolean result = dBHelper.isDatabaseDelete(getApplicationContext());
            Log.d(TAG, " delete result : " + result);
        } catch(
                Exception e)

        {
            Log.d(TAG, e.getMessage());
        }
    }


}