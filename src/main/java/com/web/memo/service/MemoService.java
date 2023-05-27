package com.web.memo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.memo.dao.entity.MemoEntity;
import com.web.memo.dao.repository.MemoRepository;
import com.web.memo.domain.Memo;
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
}
