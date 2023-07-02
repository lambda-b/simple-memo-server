package com.web.memo.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Getter;

@Getter
@RequestScope
@Component
public class MessageHolder {

	/** messages */
	private final List<String> messages = new ArrayList<>();

	/**
	 * messageを追加
	 * @param message
	 */
	public void add(final String message) {
		messages.add(message);
	}
}
