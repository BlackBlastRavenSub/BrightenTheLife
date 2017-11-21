package com.game.blastraven.b.brightenthelife

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by shota on 2017/11/15.
 */
//このファイルは本アプリとは無関係!!
class TestFileTest {

    private var mTestfile: TestFile? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mTestfile = TestFile()
    }

    @Test
    @Throws(Exception::class)
    fun testSum() {
        //予想：1 + 5 で 6が返ってくるはず
        assertEquals("正しい値", mTestfile!!.sum(1, 5), 6)
    }

    @Test
    @Throws(Exception::class)
    fun testSubstract() {
        assertEquals("正しい値2", mTestfile!!.substract(9, 3), 6)
    }

    @Test
    @Throws(Exception::class)
    fun testFirstKotlin() {
        assertEquals(mTestfile!!.firstKotlin("OK?", 68), "GoodLuck!!")
        //assertEquals(mTestfile!!.firstKotlin("OK?",68).toLong(),"GoodLuck!!")
    }


}

/*package com.game.blastraven.b.brightenthelife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ShotaroNoda on 2017/11/12.
 */

//このファイルは本アプリとは無関係!!
public class TestFileTest {

    private TestFile mTestfile;

    @Before
    public void setUp() throws Exception {
        mTestfile = new TestFile();
    }

    @Test
    public void testSum() throws Exception {
        //予想：1 + 5 で 6が返ってくるはず
        assertEquals( "正しい値",mTestfile.sum(1, 5), 6);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals("正しい値2", mTestfile.substract(9, 3), 6);
    }
    GIT
    これは使いやすそう!!
}*/