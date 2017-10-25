package com.lukasowy.utils;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorUtils {
	public static String customErrors(List<ObjectError> errors) {
		JSONObject jsonObject = new JSONObject();
		try {
			String errorMessage = "";
			jsonObject.put("status", "failure");
			jsonObject.put("title", "Field Errors");
			for (ObjectError objectError : errors) {
				if (objectError instanceof FieldError) {
					FieldError fieldError = (FieldError) objectError;
					errorMessage += "<b>" + fieldError.getField() + " :</b>" + fieldError.getDefaultMessage() + "</br>";
				}
			}
			jsonObject.put("message", errorMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
