package com.web.memo.dao.entity;

import java.time.LocalDateTime;

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

	/** 更新時刻 */
	private LocalDateTime updateTimestamp;

}
