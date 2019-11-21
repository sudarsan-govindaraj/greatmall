package com.gmt.ecommerce.util;

import com.google.gson.Gson;

public class JsonUtil {
	public static String getjson(Object o){
		return new Gson().toJson(o);
	}
}
