package com.web.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.memo.controller.converter.MemoControllerConverter;
import com.web.memo.domain.Memo;
import com.web.memo.dto.api.in.MemoApiIn;
import com.web.memo.dto.api.out.MemoApiOut;
import com.web.memo.service.MemoService;

import lombok.RequiredArgsConstructor;

/**
 * MemoController
 */
@Controller
@RequiredArgsConstructor
public class MemoController {

	/** service */
	private final MemoService service;


	@GetMapping("/api/memos")
	@ResponseBody
	List<MemoApiOut> getAll() {
		final List<Memo> memos = service.getAll();
		return MemoControllerConverter.toOut(memos);
	}

	@PostMapping("/api/save-memos")
	@ResponseBody
	void saveMemo(@Validated @RequestBody final List<MemoApiIn> in) {
		final List<Memo> memos = MemoControllerConverter.toMemo(in);
		service.saveMemo(memos);
	}
}
