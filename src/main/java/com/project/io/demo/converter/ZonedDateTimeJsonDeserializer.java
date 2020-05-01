/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.io.demo.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;


@ReadingConverter
public class ZonedDateTimeJsonDeserializer implements Converter<String, ZonedDateTime> {
	@Override
	public ZonedDateTime convert(String value) {
		TemporalAccessor dt = DateTimeFormatter.ISO_DATE_TIME.parseBest(value, ZonedDateTime::from, LocalDateTime::from);
		return dt instanceof ZonedDateTime ? (ZonedDateTime) dt : ZonedDateTime.of((LocalDateTime) dt, ZoneId.of("Europe/Zurich"));
	}
}