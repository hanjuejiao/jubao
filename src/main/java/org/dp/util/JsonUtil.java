package org.dp.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	private volatile static JsonUtil instance;
	Gson gson;
	private JsonUtil(Gson gson){
		this.gson = gson;
	}
	public static JsonUtil getInstance(){
		if(instance==null){
			synchronized (JsonUtil.class) {
				if(instance==null){
					instance = new JsonUtil(new Gson());
				}
			}
		}
		return instance;
	}
	
	public String toJson(Object obj){
		return gson.toJson(obj);
	}
	public <T> Object fromJsonToObject(String data,Class<T> type){
		return gson.fromJson(data, type);
	}
	public Object fromJsonToList(String data){
		return gson.fromJson(data, new TypeToken<List>(){}.getType());
	}
}
