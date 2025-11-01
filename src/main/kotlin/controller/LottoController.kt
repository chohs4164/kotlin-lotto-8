package controller


import domain.LottoGenerator
import domain.Rank
import util.Validator
import view.InputView
import view.OutputView

//로또 몇 줄을 만들지 결정만 함.
class LottoController() {
    fun start() {
        // 구입 금액 알아내고
        try {
            val inputPrice = InputView.readLottoPrice()
            // 갯수로 변환하여
            val lottoCount = inputPrice / 1000
            // 갯수 만큼의 로또 줄을 만들고
            val lottos = LottoGenerator.createLottos(lottoCount)
            // 로또 구매 갯수와 랜덤 숫자들 출력
            OutputView.printLottoNumber(lottoCount, lottos)
            // 진짜 당첨 번호 입력하고
            val inputWinNumber = InputView.readWinNumber()
            // 보너스 번호도 입력하고
            val inputBonusNumber = InputView.readBonusNumber(inputWinNumber)
            // 몇 개 맞았는지 확인해서 등수 메기기
            val ranks: List<Rank> = Validator.validateNumber(lottos, inputWinNumber, inputBonusNumber)
            OutputView.printWinStatistics(lottoCount, ranks)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}