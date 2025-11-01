package util

import domain.Rank
import lotto.Lotto

object Validator {
    // lottos: 구매한 로또 번호 리스트들, inputWinNumber: 당첨 로또 번호, inputBonusNumber: 당첨 보너스 번호
    fun validateNumber(
        lottos: List<Lotto>,
        inputWinNumber: Lotto,
        inputBonusNumber: Int
    ): List<Rank> {
        // 당첨 번호를 집합으로 만들기!
        val winSet = inputWinNumber.getNumbers().toSet()

        // 각 로또 줄을 하나씩 등수로 변환하여 리스트로 반환하기
        return lottos.map { lotto ->
            val nums = lotto.getNumbers()
            val matchCount = nums.count { it in winSet }
            val bonusMatched = inputBonusNumber in nums
            Rank.from(matchCount,bonusMatched)
        }
    }
}