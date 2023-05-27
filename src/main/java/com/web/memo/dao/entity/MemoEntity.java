package com.web.memo.dao.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table("MEMOS")
public class MemoEntity {

	/** メモID */
	@Id
	private final String memoId;

	/** 順番　*/
	private final long sequence;

	/** ユーザーID */
	private final String userId;

	/** タイトル */
	private final String title;

	/** 内容 */
	private final String content;

	/** 更新時刻 */
	private final LocalDateTime updateTimestamp;

}
