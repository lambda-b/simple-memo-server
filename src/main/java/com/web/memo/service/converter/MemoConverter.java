package com.web.memo.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.web.memo.dao.entity.MemoEntity;
import com.web.memo.domain.Memo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * MemoConverter
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemoConverter {

	/**
	 * エンティティからドメインに変換するメソッド
	 * @param entity
	 * @return メモのリスト
	 */
	public static Memo toMemo(final MemoEntity entity) {
		return Memo.builder()
				.memoId(entity.getMemoId())
				.title(entity.getTitle())
				.content(entity.getContent())
				.build();
	}

	/**
	 * リスト変換のメソッド
	 * @param entities
	 * @return メモのリスト
	 */
	public static List<Memo> toMemo(final List<MemoEntity> entities) {
		return entities.stream()
				.map(entity -> toMemo(entity))
				.collect(Collectors.toList());
	}
}
