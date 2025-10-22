package com.example.classicsnake.data.local.datastore

import androidx.datastore.core.Serializer
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class UserSettingsSerializer: Serializer<UserSettings> {

    // начальное значение
    override val defaultValue: UserSettings
        get() = UserSettings() // при обращении к переменной создается объект со значениями по умолчанию

    // переопределяем функцию для чтения данных из файла
    override suspend fun readFrom(input: InputStream): UserSettings {
        try {
            input.use { stream ->
                // декодируем данные из JSON-строки в объект типа UserSettings
                return Json.decodeFromString(
                    deserializer = UserSettings.serializer(),
                    string = stream.readBytes().decodeToString()
                )
            }
        } catch (e: Exception) {
            return defaultValue // если во время конвертации произошла ошибка, возвращаем объект со стандартными настройками
        }
    }

    // переопределяем функцию для запись данных в файл
    override suspend fun writeTo(t: UserSettings, output: OutputStream) {
        try {
            output.use { stream ->
                stream.write(
                    // кодируем данные из объекта типа UserSettings в JSON-строку
                    Json.encodeToString(
                        serializer = UserSettings.serializer(),
                        value = t
                    ).encodeToByteArray()
                )
            }
        } catch (e: Exception) {
            // если произошла ошибка во время конвертации, данные не сохранятся
        }
    }


}