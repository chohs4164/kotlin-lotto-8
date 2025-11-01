package view

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object OutputView {
    // 구매 갯수에 따른 복권 출력
    fun printLottoNumber(number: Int, lottos: List<Lotto>) {
        println("\n${number}개를 구매했습니다.")
        lottos.forEach { lotto ->
            print(lotto.getNumbers())
            println()
        }
        println()
    }
    // number는 로또 구매 갯수
    fun printWinStatistics(number: Int, winAndBonusCount: MutableList<Pair<Int, Int>>) {
        var threeCount = 0
        var fourCount = 0
        var fiveCount = 0
        var fiveAndBonusCount = 0
        var sixCount = 0
        for ((winCount, bonusCount) in winAndBonusCount) {
            when (winCount) {
                3 -> threeCount++
                4 -> fourCount++
                5 -> if (bonusCount == 1)
                        fiveAndBonusCount++
                    else
                        fiveCount++
                6 -> sixCount++
            }
        }
        println("당첨 통계\n---")
        println("3개 일치 (5,000원) - ${threeCount}개")
        println("4개 일치 (50,000원) - ${fourCount}개")
        println("5개 일치 (1,500,000원) - ${fiveCount}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${fiveAndBonusCount}개")
        println("6개 일치 (2,000,000,000원) - ${sixCount}개")
        val profitSum = threeCount * 5000L + fourCount * 50000L + fiveCount * 1500000L + fiveAndBonusCount * 30000000L + sixCount * 2000000000L
        val profitRate = profitSum.toDouble() / (number * 1000) * 100
        println("총 수익률은 ${String.format("%.1f",profitRate)}%입니다.")
    }
}