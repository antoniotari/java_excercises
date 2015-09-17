package com.antoniotari.structures;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author antonio
 */
public class LruCache<K, V>{
	private final Map<K,V> cache;   

	public LruCache(final int maxEntries) {
		this.cache = Collections.synchronizedMap(new LruCacheMap<K, V>(maxEntries));
	}

	public void put(K key, V value) {
		synchronized(cache) {
			cache.put(key, value);
		}
	}
	public V get(K key) {
		synchronized(cache) {
			return cache.get(key);
		}
	}

	/**
	 * @author antonio
	 */
	private class LruCacheMap<A, B> extends LinkedHashMap<A, B> {
		private static final long serialVersionUID = -1236481390177598762L;
		private final int maxEntries;

		public LruCacheMap(final int maxEntries) {
			super(maxEntries + 1, 0.75F, true);
			this.maxEntries = maxEntries;
		}

		/**
		 * Returns <tt>true</tt> if this <code>LruCache</code> has more entries than the maximum specified when it was
		 * created.
		 *
		 * <p>
		 * This method <em>does not</em> modify the underlying <code>Map</code>; it relies on the implementation of
		 * <code>LinkedHashMap</code> to do that, but that behavior is documented in the JavaDoc for
		 * <code>LinkedHashMap</code>.
		 * </p>
		 *
		 * @param eldest
		 *            the <code>Entry</code> in question; this implementation doesn't care what it is, since the
		 *            implementation is only dependent on the size of the cache
		 * @return <tt>true</tt> if the oldest
		 * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
		 */
		@Override
		protected boolean removeEldestEntry(final Map.Entry<A, B> eldest) {
			return super.size() > maxEntries;
		}
	}
}
