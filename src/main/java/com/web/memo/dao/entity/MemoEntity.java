package com.web.memo.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;

@Getter
@Table("MEMOS")
public class MemoEntity {

	/** メモID */
	@Id
	private String memoId;

	/** 順番　*/
	private long sequence;

	/** ユーザーID */
	private String userId;

	/** タイトル */
	private String title;

	/** 内容 */
	private String content;

}
