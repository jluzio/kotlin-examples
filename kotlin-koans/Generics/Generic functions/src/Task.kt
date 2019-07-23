import java.util.*
import java.util.function.Predicate

fun <T> Collection<T>.partitionTo(accepted: MutableCollection<T>, rejected: MutableCollection<T>, predicate: (v: T) -> Boolean): Pair<Collection<T>, Collection<T>> {
    forEach {
        if (predicate(it)) {
            accepted.add(it)
        } else {
            rejected.add(it)
        }
    }
    return Pair(accepted, rejected)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
