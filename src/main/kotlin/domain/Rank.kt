package domain

enum class Rank(
    val matchCount: Int, // 일치하는 숫자 개수
    val prize: Long, // 상금
    val needsBonus: Boolean //보너스 점수 맞았는지
) {
    FIRST(6, 2000000000L, false),
    SECOND(5, 30000000L, true),
    THIRD(5, 1500000L, false),
    FOURTH(4, 50000L, false),
    FIFTH(3, 5000L, true),
    MISS(0, 0L, false);

    companion object{
        // 일치하는 숫자 개수와 보너스 일치 여부를 넘겨받아서 등수로 변환
        fun from(matchCount: Int, bonusMatched:Boolean): Rank = when (matchCount) {
            6 -> FIRST
            5 -> if (bonusMatched) SECOND else THIRD
            4 -> FOURTH
            3 -> FIFTH
            else -> MISS
        }
    }
}