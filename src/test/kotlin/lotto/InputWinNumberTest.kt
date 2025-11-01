package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.InputView.validateInputPrice
import view.InputView.validateWinNumber

class InputWinNumberTest {
    @Test
    fun `당첨번호 입력이 콤마(,)를 구분자로 문자열이 들어오지 않을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("\n")
            }
        }
    }

    @Test
    fun `당첨번호 입력에 공백이 들어올 경우1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("")
            }
        }
    }

    @Test
    fun `당첨번호 입력에 공백이 들어올 경우2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("   ")
            }
        }
    }

    @Test
    fun `당첨번호 입력에 공백이 들어올 경우3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("\t")
            }
        }
    }

    @Test
    fun `당첨번호 입력에 공백이 들어올 경우4`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("\n")
            }
        }
    }

    @Test
    fun `당첨번호 입력이 구분자 이외에 숫자가 아닌값이 들어온 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("a,b,c")
            }
        }
    }

    @Test
    fun `당첨번호 입력이 중복된 숫자가 있는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateWinNumber("1,2,3,4,5,5")
            }
        }
    }
}