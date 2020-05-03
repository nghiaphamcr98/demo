package com.example.demo.response;

import com.example.demo.languague.ErrorContent;
import com.example.demo.util.AppUtil;

import org.json.simple.JSONObject;

public class Response {
	public static JSONObject success(JSONObject data) {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.SUCCESS_CODE);
		result.put("error", "SUCCESS");
		result.put("data", data);
		return result;
	}

	public static JSONObject successWarning(JSONObject data, String warning) {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.SUCCESS_CODE);
		result.put("error", "SUCCESS");
		result.put("warning", warning);
		result.put("data", data);
		return result;
	}

	public static JSONObject logout() {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.LOGOUT_CODE);
		result.put("error", "LOGOUT");
		result.put("data", new JSONObject());
		return result;
	}

	public static JSONObject logOut(int language) {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.LOGOUT_CODE);
		result.put("error", "LOGOUT");
		result.put("data", new JSONObject());
		return result;
	}

	public static JSONObject error(String error) {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.ERROR_CODE);
		result.put("error", error);
		result.put("data", new JSONObject());
		return result;
	}

	public static JSONObject error(int code, int language) {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.ERROR_CODE);
		result.put("error", ErrorContent.from(code).getError(language));
		result.put("data", new JSONObject());
		return result;
	}

	public static JSONObject error(int code, int data, int language) {
		JSONObject result = new JSONObject();
		result.put("code", code);
		result.put("error", ErrorContent.from(data).getError(language));
		result.put("data", new JSONObject());
		return result;
	}

	public static JSONObject success() {
		JSONObject result = new JSONObject();
		result.put("code", AppUtil.SUCCESS_CODE);
		result.put("error", "SUCCESS");
		result.put("data", new JSONObject());
		return result;
	}
}
