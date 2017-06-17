package org.dp.cache;

public class LocalCache {
	private static int jubaoId = 0;
	public static int getJubaoId(){
		synchronized (LocalCache.class) {
			return jubaoId++;
		}
	}
}
