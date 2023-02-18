package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JudgementTest {
    @Test
    fun `당첨 번호를 비교하여 결과를 반환한다`() {
        // given
        val winningNumbers = WinningNumbers(
            Lotto((1..6).map { LottoNumber.create(it) }.toSet()),
            LottoNumber.create(7)
        )

        val firstRankLottoNumbers = (1..6).map { LottoNumber.create(it) }.toSet()
        val secondRankLottoNumbers = (2..7).map { LottoNumber.create(it) }.toSet()
        val fourthRankLottoNumbers = (3..8).map { LottoNumber.create(it) }.toSet()
        val lottoBundle = LottoBundle(
            listOf(
                Lotto(firstRankLottoNumbers),
                Lotto(secondRankLottoNumbers),
                Lotto(fourthRankLottoNumbers)
            )
        )
        val expected = WinningResult(
            listOf(
                ComparingResult(6, false),
                ComparingResult(5, true),
                ComparingResult(4, true)
            )
        )
        // when
        val actual: WinningResult = Judgement.compareLottoBundle(winningNumbers, lottoBundle)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
