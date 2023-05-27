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
}
