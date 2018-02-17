import java.util.*

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(c1: C, c2: C, p: (T) -> Boolean): Pair<C, C> {
    for (e in this) {
        if (p(e)) {
            c1.add(e)
        } else {
            c2.add(e)
        }
    }
    return Pair(c1, c2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
