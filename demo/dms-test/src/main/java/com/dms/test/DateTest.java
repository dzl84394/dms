package com.dms.test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTest {
	

/**
 * 测试java8 之后提供的新的api LocalDate，LocalTime,LocalDateTime,Clock
 * @param args
 */
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		Clock clock = Clock.systemDefaultZone();
		Instant instant = Instant.now();
		
	}
}
