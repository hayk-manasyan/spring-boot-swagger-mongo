
package com.project.io.demo.converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class ZonedDateTimeJsonSerializer implements Converter<ZonedDateTime, String> {
	@Override
	public String convert(ZonedDateTime value) {
		return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value);
	}
}
