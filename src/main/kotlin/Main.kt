package pw.mlnkv

fun main() {
    // Засекаем время начала работы программы в миллисекундах
    val startTime = System.currentTimeMillis()
    println("Hello World!")
    // Засекаем время окончания работы программы в миллисекундах
    val endTime = System.currentTimeMillis()

    // Переводим получившееся время в минуты и секунды
    val minutes = if((endTime - startTime) / 1000 / 60 < 10) "0${(endTime - startTime) / 1000 / 60}" else "${(endTime - startTime) / 1000 / 60}"
    val seconds = if((endTime - startTime) / 1000 % 60 < 10) "0${(endTime - startTime) / 1000 % 60}" else "${(endTime - startTime) / 1000 % 60}"
    val milliseconds = if((endTime - startTime) % 1000 < 10) "00${(endTime - startTime) % 1000}" else if((endTime - startTime) % 1000 < 100) "0${(endTime - startTime) % 1000}" else "${(endTime - startTime) % 1000}"

    // Выводим время работы программы
    println("Время работы программы: $minutes:$seconds.$milliseconds")
}
