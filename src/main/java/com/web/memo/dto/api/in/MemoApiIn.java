package com.web.memo.dto.api.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoApiIn {

	/** メモID */
	private final String memoId;

	/** タイトル */
	private final String title;

	/** 内容 */
	private final String content;
}
