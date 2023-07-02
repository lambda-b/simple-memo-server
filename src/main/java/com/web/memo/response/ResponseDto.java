package com.web.memo.response;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 共通レスポンスDTO
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto implements Serializable {

	/** messages */
	private final List<String> messages;

	/** data */
	private final Object data;
}
