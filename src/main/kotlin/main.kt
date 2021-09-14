fun toHours(seconds: Int): Int {
    return seconds / 3600
}

fun toMinutes(seconds: Int): Int {
    return seconds / 60
}

fun minutesToText(seconds: Int): String {
    var minutes = toMinutes(seconds)
    return when (minutes) {
        1, 21, 31, 41, 51 -> "$minutes минуту назад"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 ->
            "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursToText(seconds: Int): String {
    var hours = toHours(seconds)
    return when (hours) {
        1, 21 -> "$hours час назад"
        2, 3, 4, 22 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "$USER_1_NAME \nбыл(а) только что"
        in 61..3600 -> "$USER_2_NAME \nбыл(а) " + minutesToText(seconds)
        in 3601..86400 -> "$USER_3_NAME \nбыл(а) в сети " + hoursToText(seconds)
        in 86401..172800 -> "$USER_4_NAME \nбыла(а) сегодня"
        in 172801..259200 -> "$USER_5_NAME \nбыл(а) вчера"
        else -> "$USER_6_NAME \nбыл(а) давно"
    }
}

const val USER_1_NAME = "John"
const val USER_2_NAME = "Mina"
const val USER_3_NAME = "Peter"
const val USER_4_NAME = "Anna"
const val USER_5_NAME = "Michael"
const val USER_6_NAME = "Richard"

fun main() {
    print(agoToText(3480))
}
