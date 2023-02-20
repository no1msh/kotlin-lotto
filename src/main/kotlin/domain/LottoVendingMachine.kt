package domain

object LottoVendingMachine {
    private const val LOTTO_PRICE = 1000

    fun getLottoCount(money: Money): Int {
        return (money.amount / LOTTO_PRICE).toInt()
    }

    fun getLottoBundle(lottoCount: Int, lottoGenerator: LottoGenerator): LottoBundle {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottos.add(lottoGenerator.generate())
        }
        return LottoBundle(lottos)
    }
}
