package com.web.memo.controller.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.web.memo.domain.Memo;
import com.web.memo.dto.api.in.MemoApiIn;
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
				.map(MemoControllerConverter::toOut)
				.collect(Collectors.toList());
	}

	public static Memo toMemo(final MemoApiIn in) {
		return Memo.builder()
				.memoId(in.getMemoId())
				.title(in.getTitle())
				.content(in.getContent())
				.build();
	}
	/**
	 * 変換メソッド
	 * @param in
	 * @return memo
	 */
	public static List<Memo> toMemo(final List<MemoApiIn> in) {
		return in.stream()
				.map(MemoControllerConverter::toMemo)
				.collect(Collectors.toList());
	}
}
