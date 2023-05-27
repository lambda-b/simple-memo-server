package com.web.memo.dao.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.memo.dao.entity.MemoEntity;

@Mapper
public interface MemoRepository {

	/**
	 * DB上のすべてのデータを取得する
	 * @return メモリスト
	 */
	List<MemoEntity> findAll();

	/**
	 * DBに保存する
	 * @param メモリスト
	 */
	void saveAll(List<MemoEntity> memoList);

	/**
	 * DBのメモを削除する (物理削除)
	 * @param memoList 削除対象のメモリスト
	 */
	void deleteAll(List<MemoEntity> memoList);
}
