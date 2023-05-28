package com.web.memo.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;

/**
 * MemoListのドメイン
 */
@AllArgsConstructor
public class MemoList {

	/** memoリスト */
	private final List<Memo> memos;


	/**
	 * メモIDの有効性をチェック
	 *
	 * @param registeredMemos
	 * @return true: 有効　/ false: 無効
	 */
	public boolean isValidId(final List<Memo> registeredMemos) {
		final Set<String> registeredIdSet = registeredMemos.stream()
				.map(Memo::getMemoId)
				.collect(Collectors.toSet());

		return memos.stream()
				.allMatch(memo -> StringUtils.isEmpty(memo.getMemoId()) || registeredIdSet.contains(memo.getMemoId()));

	}

	/**
	 * 削除される対象メモを抽出
	 *
	 * @param registeredMemos
	 * @return 削除対象のメモリスト
	 */
	public List<Memo> getDeletions(final List<Memo> registeredMemos) {
		final Set<String> memoIdSet = memos.stream()
				.map(Memo::getMemoId)
				.collect(Collectors.toSet());

		return registeredMemos.stream()
				.filter(memo -> !memoIdSet.contains(memo.getMemoId()))
				.collect(Collectors.toList());

	}
}
