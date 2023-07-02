package com.web.memo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

/**
 * APIで共通のレスポンスボディ形式を返すためのRestControllerアノテーション
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface CustomRestController {

	/**
	 * RestControllerのアノテーションパラメータを継承
	 * @return value
	 */
	@AliasFor(annotation = RestController.class)
	String value() default "";
}
