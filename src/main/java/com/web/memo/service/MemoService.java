package com.web.memo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.web.memo.dao.entity.MemoEntity;
import com.web.memo.dao.repository.MemoRepository;
import com.web.memo.domain.Memo;
import com.web.memo.domain.MemoList;
import com.web.memo.service.converter.MemoConverter;

import lombok.RequiredArgsConstructor;

/**
 * メモサービス
 */
@Service
@RequiredArgsConstructor
public class MemoService {

	/** レポジトリ */
	private final MemoRepository repository;

	/**
	 * すべてのメモを返却
	 * @return メモのリスト
	 */
	public List<Memo> getAll() {
		final List<MemoEntity> entities = repository.findAll();

		return MemoConverter.toMemo(entities);
	}

	/**
	 * メモを保存
	 * @param memos
	 */
	public void saveMemo(final List<Memo> memos) {
		final MemoList memoList = new MemoList(memos);
		final List<Memo> dbMemos = getAll();

		if (!memoList.isValidId(dbMemos)) {
			return; // TODO 例外処理を記述
		}

		if (!CollectionUtils.isEmpty(memos)) {
			repository.saveAll(MemoConverter.toEntity(memos));
		}

		final List<Memo> deletions = memoList.getDeletions(dbMemos);
		if (!CollectionUtils.isEmpty(deletions)) {
			repository.deleteAll(MemoConverter.toEntity(deletions));
		}
	}

}
