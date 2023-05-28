package com.web.memo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MemoListTest
 */
@SpringBootTest
public class MemoListTest {

	@Test
	void test_isValidId1() {
		// setup
		final List<Memo> memos = createSampleMemos("1000", "");
		final MemoList memoList = new MemoList(memos);

		// exercise
		final boolean isValid = memoList.isValidId(createDbMemos());

		// verify
		assertThat(isValid).isTrue();
	}

	@Test
	void test_idValidId2() {
		// setup
		final List<Memo> memos = createSampleMemos("1000", "4000");
		final MemoList memoList = new MemoList(memos);

		// exercise
		final boolean isValid = memoList.isValidId(createDbMemos());

		// verify
		assertThat(isValid).isFalse();
	}

	@Test
	void test_getDeletions1() {
		// setup
		final List<Memo> memos = createSampleMemos("1000", "2000", "3000", "");
		final MemoList memoList = new MemoList(memos);

		// exercise
		final List<Memo> deletions = memoList.getDeletions(createDbMemos());

		// verify
		assertThat(deletions.size()).isEqualTo(0);
	}

	@Test
	void test_getDeletions2() {
		// setup
		final List<Memo> memos = createSampleMemos("1000", "");
		final MemoList memoList = new MemoList(memos);

		// exercise
		final List<Memo> deletions = memoList.getDeletions(createDbMemos());

		// verify
		final List<String> deletionId = deletions.stream().map(Memo::getMemoId).collect(Collectors.toList());
		assertThat(deletionId).isEqualTo(List.of("2000", "3000"));
	}

	/**
	 * サンプルメモの作成
	 * @return sample-memo
	 */
	private List<Memo> createSampleMemos(final String... memoId) {
		return Arrays.stream(memoId)
				.map(id -> Memo.builder().memoId(id).title("タイトル").content("サンプル").build())
				.collect(Collectors.toList());
	}

	/**
	 * DBのリスト作成
	 * @return DB-memo
	 */
	private List<Memo> createDbMemos() {
		return List.of(
				Memo.builder().memoId("1000").title("タイトル1").content("内容1").build(),
				Memo.builder().memoId("2000").title("タイトル2").content("内容2").build(),
				Memo.builder().memoId("3000").title("タイトル3").content("内容3").build());
	}
}
