package view

import camp.nextstep.edu.missionutils.Randoms
import domain.Rank
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
    fun printWinStatistics(number: Int, ranks: List<Rank>) {
        // 등수별 갯수 세기
        val firstCount = ranks.count { it == Rank.FIRST }
        val secondCount = ranks.count { it == Rank.SECOND }
        val thirdCount = ranks.count { it == Rank.THIRD }
        val fourthCount = ranks.count { it == Rank.FOURTH }
        val fifthCount = ranks.count { it == Rank.FIFTH }

        println("당첨 통계\n---")
        println("3개 일치 (5,000원) - ${fifthCount}개")
        println("4개 일치 (50,000원) - ${fourthCount}개")
        println("5개 일치 (1,500,000원) - ${thirdCount}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${secondCount}개")
        println("6개 일치 (2,000,000,000원) - ${firstCount}개")
        val profitSum = ranks.sumOf { it.prize }
        val profitRate = profitSum.toDouble() / (number * 1000) * 100
        println("총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
    }
}