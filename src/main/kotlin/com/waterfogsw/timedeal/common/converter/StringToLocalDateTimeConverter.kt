package com.waterfogsw.timedeal.common.converter

import org.springframework.core.convert.converter.Converter
import java.time.LocalDateTime

class StringToLocalDateTimeConverter : Converter<String, LocalDateTime> {

    override fun convert(source: String): LocalDateTime {
        return LocalDateTime.parse(source)
    }
}
