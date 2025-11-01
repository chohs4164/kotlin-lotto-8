package util

import lotto.Lotto

object Validator {
    // lottos: 구매한 로또 번호 리스트들, inputWinNumber: 당첨 로또 번호, inputBonusNumber: 당첨 보너스 번호
    fun validateNumber(lottos: List<Lotto>, inputWinNumber: Lotto, inputBonusNumber: Int): MutableList<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        var winCount = 0
        var bonusCount = 0
        for (lotto in lottos) {
            // 이미 오름차순으로 랜덤 번호를 정렬해놓았으니 이렇게 일치하는지 계산
            winCount = lotto.getNumbers().count { it in inputWinNumber.getNumbers() }
            // 보너스 번호도 계산
            if (inputBonusNumber in lotto.getNumbers())
                bonusCount++
            result.add(Pair(winCount, bonusCount))
        }
        return result
    }
}