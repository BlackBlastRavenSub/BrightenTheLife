package com.game.blastraven.b.brightenthelife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shota on 2017/11/15.
 */
//このファイルはCalcSysのユニットテスト用のファイルだ
public class CalcSysTest {
    CalcSys calcSys = new CalcSys();

    @Test
    public void multiply() throws Exception {
        System.out.println(calcSys.multiply(100));
    }

    @Test
    public void predation() throws Exception {
        System.out.println(calcSys.predation(2, 4, 100));
    }

    @Test
    public void mutation() throws Exception {
        System.out.println(calcSys.mutation(0, 0));
    }

    @Test
    public void earthEvent() throws Exception {
        System.out.println(calcSys.earthEvent());
    }

}