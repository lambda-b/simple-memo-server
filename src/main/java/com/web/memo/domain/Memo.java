package com.web.memo.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * メモのドメインクラス
 */
@Getter
@Builder
public class Memo {

	/** メモID */
	private final String memoId;

	/** 順番 */
	private final long sequence;

	/** タイトル */
	private final String title;

	/** 内容 */
	private final String content;

}
