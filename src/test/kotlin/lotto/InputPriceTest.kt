package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.InputView.validateInputPrice

class InputPriceTest {
    @Test
    fun `구입금액 입력에 공백이 들어올 경우 예외처리1`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("")
            }
        }
    }

    @Test
    fun `구입금액 입력에 공백이 들어올 경우 예외처리2`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("    ")
            }
        }
    }

    @Test
    fun `구입금액 입력에 공백이 들어올 경우 예외처리3`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("\t")
            }
        }
    }

    @Test
    fun `구입금액 입력에 공백이 들어올 경우 예외처리4`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("\n")
            }
        }
    }

    @Test
    fun `구입금액 입력 문자열을 숫자로 변환하고자 하였을 때 문제가 발생하면 예외처리`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("1000a")
            }
        }
    }

    @Test
    fun `구입금액이 1000단위로 들어오지 않을 경우`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("1234")
            }
        }
    }

    @Test
    fun `구입금액이 0 또는 음수가 들어올 경우`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInputPrice("-1234")
            }
        }
    }
}