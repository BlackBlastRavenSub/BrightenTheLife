package com.game.blastraven.b.brightenthelife;

/**
 * Created by shota on 2017/11/15.
 */
//これはプレイヤーのイベントによって発生した効果、ダメージの内容を処理する部分だ。効果の反映をこのクラス内で行うかはまだ未定
public class CalcSys {

    //増殖イベント、増殖者の増殖係数、増殖者のLevel・・・未完成
    public int multiply(int multiplyPower) {
        //処理:回復するライフの算出
        int multiplyResult = multiplyPower;//増殖結果＝増殖係数(増殖者のLevelを加味する必要あり)
        return multiplyResult;
    }

    //捕食イベント、被害者のLevel、捕食者のLevel、捕食者の捕食係数(捕食者のLevelを加味する必要あり)・・・未完成
    public int predation(int victimLevel, int predatorLevel, int predatorEatPower) {
        //処理:発生した捕食ダメージの算出
        int dice = new java.util.Random().nextInt(6) + 1;//ダイスロール
        int eatResult = predatorEatPower * dice * (predatorLevel - victimLevel);//引数をカードのID一つにしてそこからカードのLevelや能力参照はできないのか・・？
        return eatResult;
    }

    //進化イベント、DNAカードの種類、環境の設定・・・未完成
    public int mutation(int dnaCard, int trouble) {
        //処理:喰らう進化ダメージの値と進化成功判定
        return 0;
    }

    //地球イベント、引数なし・・・未完成
    public int earthEvent() {
        //処理:ダイスの判定と効果
        int earthResult = new java.util.Random().nextInt(6) + 1;//ダイスロール
        return earthResult;
    }
}

/*Levelによってパラメータは変動するものの、Levelは最大3の上、値は一定だ。
*いっそデータベースから呼び出すときにユニットIDとLevelの２つのキーで呼び出すべきか・・？
* そうすれば計算式に放り込むユニット依存の値はユニットあたり１つにできる
* よし、今回はSQLデータベースに全ユニットとLevelごとのパラメータを叩き込んで、それを検索→セットってことにしよう。
* そうすれば計算に必要な呼び出しは一回で済む!
* よって、このコードの引数部分は大幅に書き換えることになるだろう、SQLの使い方がまだ分からないが・・
* IDさえ判れば良いなら、引数はユニットのIDと対応したイベントカードだけで済む
* (int victimLevel, int predatorLevel,int predatorEatPower → int victimId, int predatorId )*/