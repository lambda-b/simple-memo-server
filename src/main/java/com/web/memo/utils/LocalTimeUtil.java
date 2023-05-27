package com.web.memo.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 時刻に関するUtilクラス
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalTimeUtil {

	/** ZoneId */
	private static ZoneId zoneId = ZoneId.systemDefault();

	/** 現在時刻 */
	public static LocalDateTime now() {
		return Instant.ofEpochMilli(System.currentTimeMillis()).atZone(zoneId).toLocalDateTime();
	}

}
