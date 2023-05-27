package com.web.memo.dto.api.out;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemoApiOut implements Serializable {

	/** メモID　*/
	private final String memoId;

	/** タイトル */
	private final String title;

	/** 内容 */
	private final String content;
}
