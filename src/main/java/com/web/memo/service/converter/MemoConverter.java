package com.web.memo.service.converter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.web.memo.dao.entity.MemoEntity;
import com.web.memo.domain.Memo;
import com.web.memo.utils.LocalTimeUtil;
import com.web.memo.utils.TokenGeneratorUtil;

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
				.map(MemoConverter::toMemo)
				.collect(Collectors.toList());
	}

	/**
	 * ドメインからエンティティへの変換メソッド
	 * @param memo
	 * @param sequence
	 * @return entity
	 */
	public static MemoEntity toEntity(final Memo memo, final long sequence) {
		final String memoId = StringUtils.isEmpty(memo.getMemoId()) ? TokenGeneratorUtil.generate() : memo.getMemoId();

		return MemoEntity.builder()
				.memoId(memoId)
				.sequence(sequence)
				.userId("sa") // TODO あとで認証機能設定する
				.title(memo.getTitle())
				.content(memo.getContent())
				.updateTimestamp(LocalTimeUtil.now())
				.build();
	}

	/**
	 * リスト変換のメソッド
	 * @param memos
	 * @return entityのリスト
	 */
	public static List<MemoEntity> toEntity(final List<Memo> memos) {
		final AtomicInteger index = new AtomicInteger();
		return memos.stream()
				.map(memo -> toEntity(memo, index.getAndIncrement()))
				.collect(Collectors.toList());
	}
}
