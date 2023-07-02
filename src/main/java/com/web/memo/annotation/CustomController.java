package com.web.memo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;

/**
 * APIで共通のレスポンスボディ形式を返すためのControllerアノテーション
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
public @interface CustomController {

	/**
	 * Controllerのアノテーションパラメータを継承
	 * @return value
	 */
	@AliasFor(annotation = Controller.class)
	String value() default "";
}
