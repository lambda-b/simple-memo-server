package com.web.memo.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import com.web.memo.annotation.CustomController;
import com.web.memo.annotation.CustomRestController;

import lombok.RequiredArgsConstructor;

/**
 * レスポンスに関する共通処理
 *
 */
@RequiredArgsConstructor
@RestControllerAdvice(annotations = { CustomController.class, CustomRestController.class })
public class CommonResponseBodyControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {

	/** message-holder */
	private final MessageHolder holder;

	@Override
	protected void beforeBodyWriteInternal(final MappingJacksonValue bodyContainer, final MediaType contentType,
			final MethodParameter returnType, final ServerHttpRequest request, final ServerHttpResponse response) {

		final Object data = bodyContainer.getValue();
		final ResponseDto out = new ResponseDto(holder.getMessages(), data);
		bodyContainer.setValue(out);
	}

}
