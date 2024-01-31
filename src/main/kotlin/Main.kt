package pw.mlnkv

import pw.mlnkv.scanner.Scanner
import java.text.SimpleDateFormat

fun main() {
    // Засекаем время начала работы программы в миллисекундах
    val startTime = System.currentTimeMillis()
    println("Start time: ${SimpleDateFormat("HH:mm:ss").format(startTime)}")

    // Запускаем программу
    Scanner().run()

    // Засекаем время окончания работы программы в миллисекундах
    val endTime = System.currentTimeMillis()
    println("End time: ${SimpleDateFormat("HH:mm:ss").format(endTime)}")

    // Переводим получившееся время в минуты и секунды
    val minutes = if((endTime - startTime) / 1000 / 60 < 10) "0${(endTime - startTime) / 1000 / 60}" else "${(endTime - startTime) / 1000 / 60}"
    val seconds = if((endTime - startTime) / 1000 % 60 < 10) "0${(endTime - startTime) / 1000 % 60}" else "${(endTime - startTime) / 1000 % 60}"
    val milliseconds = if((endTime - startTime) % 1000 < 10) "00${(endTime - startTime) % 1000}" else if((endTime - startTime) % 1000 < 100) "0${(endTime - startTime) % 1000}" else "${(endTime - startTime) % 1000}"

    // Выводим время работы программы
    println("Total execution time: $minutes:$seconds.$milliseconds")
}
