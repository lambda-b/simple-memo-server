package com.web.memo.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	/** logger */
	private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
			logger.info("save data");
			repository.saveAll(MemoConverter.toEntity(memos));
		}

		final List<Memo> deletions = memoList.getDeletions(dbMemos);
		if (!CollectionUtils.isEmpty(deletions)) {
			logger.info("delete data");
			repository.deleteAll(MemoConverter.toEntity(deletions));
		}
	}

}
