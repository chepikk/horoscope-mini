package com.example.horoscope.utils

fun getZodiacSign(day: Int, month: Int): String {
    return when {
        (month == 3 && day >= 21) || (month == 4 && day <= 19) -> "Овен"
        (month == 4 && day >= 20) || (month == 5 && day <= 20) -> "Телец"
        (month == 5 && day >= 21) || (month == 6 && day <= 20) -> "Близнецы"
        (month == 6 && day >= 21) || (month == 7 && day <= 22) -> "Рак"
        (month == 7 && day >= 23) || (month == 8 && day <= 22) -> "Лев"
        (month == 8 && day >= 23) || (month == 9 && day <= 22) -> "Дева"
        (month == 9 && day >= 23) || (month == 10 && day <= 22) -> "Весы"
        (month == 10 && day >= 23) || (month == 11 && day <= 21) -> "Скорпион"
        (month == 11 && day >= 22) || (month == 12 && day <= 21) -> "Стрелец"
        (month == 12 && day >= 22) || (month == 1 && day <= 19) -> "Козерог"
        (month == 1 && day >= 20) || (month == 2 && day <= 18) -> "Водолей"
        (month == 2 && day >= 19) || (month == 3 && day <= 20) -> "Рыбы"
        else -> "Неизвестно"
    }
}