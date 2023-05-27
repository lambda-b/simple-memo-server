package com.web.memo.controller.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.web.memo.domain.Memo;
import com.web.memo.dto.api.out.MemoApiOut;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * MemoControllerConverter
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemoControllerConverter {

	/**
	 * 変換メソッド
	 * @param memo
	 * @return out
	 */
	public static MemoApiOut toOut(final Memo memo) {
		return MemoApiOut.builder()
				.memoId(memo.getMemoId())
				.sequence(memo.getSequence())
				.title(memo.getTitle())
				.content(memo.getContent())
				.build();
	}

	/**
	 * 変換メソッド
	 * @param memos
	 * @return out
	 */
	public static List<MemoApiOut> toOut(final List<Memo> memos) {
		return memos.stream()
				.map(memo -> toOut(memo))
				.collect(Collectors.toList());
	}
}
