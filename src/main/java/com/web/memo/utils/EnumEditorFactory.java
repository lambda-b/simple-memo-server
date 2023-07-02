package com.web.memo.utils;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

public class EnumEditorFactory {

	public static <E extends Enum<E>> PropertyEditor create(final Class<E> clazz, final Function<E, String> getter) {
		return new PropertyEditorSupport() {
			@Override
			public void setAsText(final String text) {
				final E type = Arrays.stream(clazz.getEnumConstants())
						.filter(e -> StringUtils.equals(getter.apply(e), text))
						.findFirst()
						.orElseThrow(() -> new IllegalArgumentException(""));
				setValue(type);
			}
		};
	}
}
