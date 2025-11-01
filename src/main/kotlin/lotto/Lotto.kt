package lotto

import camp.nextstep.edu.missionutils.Randoms

// 생성한 로또 번호 1줄을 담을 lotto 객체
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun getNumbers():List<Int>{
        return numbers
    }
}
