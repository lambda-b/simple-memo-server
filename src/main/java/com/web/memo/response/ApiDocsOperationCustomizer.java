package com.web.memo.response;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.web.memo.annotation.CustomController;
import com.web.memo.annotation.CustomRestController;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Swaggerの表示をカスタム
 */
@Component
class ApiDocsOperationCustomizer implements OperationCustomizer {

	/** カスタムannotations */
	private final Set<Class<? extends Annotation>> annotations = Set.of(CustomController.class, CustomRestController.class);

	@Override
	public Operation customize(final Operation operation, final HandlerMethod handlerMethod) {

		if (isCustom(handlerMethod)) {
			final Content content = operation.getResponses().get("200").getContent();
			content.keySet().forEach(mediaTypeKey -> {
				final MediaType mediaType = content.get(mediaTypeKey);
				mediaType.schema(customizeSchema(mediaType.getSchema()));
			});
		}
		return operation;
	}

	/**
	 * swaggerのカスタムを実施するかどうか
	 * @param handlerMethod
	 * @return true: 実施　/ false: 実施しない
	 */
	private boolean isCustom(final HandlerMethod handlerMethod) {
		return annotations.stream()
				.anyMatch(clazz -> Objects.nonNull(handlerMethod.getBeanType().getAnnotation(clazz)));

	}

	/**
	 * レスポンス形式のカスタマイズ
	 * @param objSchema
	 * @return カスタムされたスキーマ
	 */
	private Schema<?> customizeSchema(final Schema<?> objSchema) {
		final Schema<?> wrapperSchema = new Schema<>();
		final ArraySchema array = new ArraySchema();
		array.setDefault(new ArrayList<String>());
		wrapperSchema.addProperties("messages", array);
		wrapperSchema.addProperties("data", objSchema);
		return wrapperSchema;
	}
}
