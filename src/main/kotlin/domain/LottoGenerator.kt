package domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGenerator {
    // 로또 한 줄
    fun createLotto(): Lotto {
        val random = Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
        return Lotto(random)
    }

    fun createLottos(lottoCount: Int): List<Lotto> {
        return List(lottoCount){
            createLotto()
        }
    }
}