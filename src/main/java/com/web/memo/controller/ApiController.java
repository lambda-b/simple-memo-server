package com.web.memo.controller;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.memo.annotation.CustomRestController;
import com.web.memo.dto.api.in.AnimalType;
import com.web.memo.response.MessageHolder;
import com.web.memo.utils.EnumEditorFactory;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@CustomRestController
@RequiredArgsConstructor
public class ApiController {

	/** message-holder */
	private final MessageHolder holder;

	@GetMapping("/api/animal")
	@Parameter(name = "type", schema = @Schema(allowableValues = { "dog", "cat", "giant-panda" }))
	public Map<String, String> getAnimal(@RequestParam("type") final AnimalType type) {
		holder.add("getAnimal");
		final Map<String, String> out = new HashMap<>();
		out.put("type", type.toString());
		return out;
	}


	@InitBinder
	public void initBinder(final WebDataBinder dataBinder) {
		final PropertyEditor editor = EnumEditorFactory.create(AnimalType.class, AnimalType::getParamName);
		dataBinder.registerCustomEditor(AnimalType.class, editor);
	}

}
