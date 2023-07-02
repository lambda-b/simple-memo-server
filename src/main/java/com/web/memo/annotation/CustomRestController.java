package com.web.memo.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

/**
 * APIで共通のレスポンスボディ形式を返すためのRestControllerアノテーション
 */
public @interface CustomRestController {

	/**
	 * RestControllerのアノテーションパラメータを継承
	 * @return value
	 */
	@AliasFor(annotation = RestController.class)
	String value() default "";
}
