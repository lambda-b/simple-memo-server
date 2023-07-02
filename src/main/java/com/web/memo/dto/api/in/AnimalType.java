package com.web.memo.dto.api.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalType {

	/** dog */
	DOG("dog"),

	/** cat */
	CAT("cat"),

	/** giant-panda */
	GIANT_PANDA("giant-panda"),
	;

	/** param-name */
	private String paramName;

}
