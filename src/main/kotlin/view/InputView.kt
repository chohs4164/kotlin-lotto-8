package view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import kotlin.text.isBlank
import kotlin.text.toIntOrNull

object InputView {
    // 로또 구입 금액 입력
    fun readLottoPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val inputPrice = Console.readLine()
        return validateInputPrice(inputPrice)
    }

    // 구입 금액 입력 검증
    fun validateInputPrice(inputPrice: String): Int {
        // 공백 입력 시
        if (inputPrice.isBlank()) {
            throw IllegalArgumentException("[ERROR] 구입금액을 입력해 주셔야 합니다.")
        }
        // 숫자값이 아닌 것 입력 시
        val intInputPrice = inputPrice.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 구입금액은 숫자를 입력해 주셔야 합니다.")
        // 1000단위가 아닐 시
        if (intInputPrice % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주셔야 합니다.")
        }
        // 0 또는 음수 입력 시
        if (intInputPrice <= 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 양수로 입력해주셔야 합니다.")
        }
        return intInputPrice
    }

    // 당첨 번호 입력
    fun readWinNumber(): Lotto {
        println("당첨 번호를 입력해주세요")
        // ","로 구분된 문자열
        val inputWinNumber = Console.readLine()
        return validateWinNumber(inputWinNumber)
    }

    // 입력된 당첨 번호 검증
    fun validateWinNumber(inputWinNumber: String): Lotto {
        // 콤마를 구분자로 숫자들을 입력하지 않은 경우
        if (!inputWinNumber.contains(",")) {
            throw IllegalArgumentException("[ERROR] 콤마(,)를 구분자로 숫자를 입력해주셔야합니다.")
        }
        // "," 제거한 문자 요소들
        val parts = inputWinNumber.split(",")
        // 공백 입력 시
        if (inputWinNumber.isBlank()) {
            throw IllegalArgumentException("[ERROR] 당첨 번호를 입력 해주셔야 합니다.")
        }
        // 당첨번호에 중복된 숫자가 있을 경우(distict를 통해 중복을 제거했음)
        if (parts.size != parts.distinct().size) {
            throw IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.")
        }
        for (part in parts) {
            // 숫자가 아닌 값 입력 시
            val intInputWinNumber = part.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해 주셔야 합니다.")
            // 로또 번호 범위를 벗어난 당첨 번호 입력 시
            if (intInputWinNumber < 1 || intInputWinNumber > 45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
        // 다 검증되었으면 리스트에 숫자형으로 저장
        val WinNumberList = parts.map { it.trim().toInt() }
        return Lotto(WinNumberList)
    }

    // 보너스 번호 입력
    fun readBonusNumber(inputWinNumber: Lotto): Int {
        println("보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine()
        return validateBonusNumber(inputWinNumber, inputBonusNumber)
    }

    // 보너스 번호 검증
    fun validateBonusNumber(inputWinNumber: Lotto, inputBonusNumber: String): Int {
        // 공백 입력 시
        if (inputBonusNumber.isBlank()) {
            throw IllegalArgumentException("[ERROR] 보너스 번호를 입력 해주셔야 합니다!")
        }
        // 숫자 이외의 값이 들어온 경우
        val intInputBonusNumber = inputBonusNumber.toIntOrNull()
            ?: throw java.lang.IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해 주셔야 합니다.")
        // 로또 번호 범위를 벗어난 보너스 번호 입력 시
        if (intInputBonusNumber < 1 || intInputBonusNumber > 45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        // 보너스 번호와 당첨 번호가 중복되는 경우
        val iterator = inputWinNumber.getNumbers()
        for (number in iterator) {
            if (number == intInputBonusNumber) {
                throw IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.")
            }
        }
        return intInputBonusNumber
    }
}