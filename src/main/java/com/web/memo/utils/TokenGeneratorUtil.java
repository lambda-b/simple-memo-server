package com.web.memo.utils;

import java.util.Base64;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * TokenGeneratorUtil
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TokenGeneratorUtil {

	/**
	 * generate
	 * @return uuid(base64encode)
	 */
	public static String generate() {
		final UUID uuid = UUID.randomUUID();

		return base64Encode(uuid.toString());
	}


	/**
	 * Encode the value using Base64.
	 * @param value the String to Base64 encode
	 * @return the Base64 encoded value
	 * @since 1.2.2
	 */
	private static String base64Encode(final String value) {
		final byte[] encodedCookieBytes = Base64.getEncoder().encode(value.getBytes());
		return new String(encodedCookieBytes);
	}
}
