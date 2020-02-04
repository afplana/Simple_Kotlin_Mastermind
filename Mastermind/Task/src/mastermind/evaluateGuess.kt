package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation = Evaluation(rightPos(secret, guess), wrongPos(secret, guess))


fun rightPos(s: String, g: String): Int {
    var ret = 0
    for (i in s.indices)
        if (s[i] == g[i]) ret++
    return ret
}

fun wrongPos(s: String, g: String): Int {
    var ret = 0
    val checked = g.toCharArray()
    for (i in 0..3) if (s[i] == g[i]) checked[i] = '0'

    for (i in 0..3) {
        val cChar = s[i]
        if (checked.contains(cChar) && g[i] != cChar) {
            ret++
            checked[checked.indexOf(cChar)] = '0'
        }
    }
    return ret
}