package com.game.blastraven.b.brightenthelife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        DBTEST()

    }
}

class DBTEST{
    fun DBTEST(){
        val dbTEST = DBHelper(null)
        System.out.print("DBTEST")

        //val shardPreferences = getActivity().getPreferences(Context.MODE_PRIVATE)

    }
}
