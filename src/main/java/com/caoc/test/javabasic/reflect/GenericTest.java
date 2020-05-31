package com.caoc.test.javabasic.reflect;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GenericTest {
	public static void main(String[] args) {
		Arrays.stream(InterfaceDemo.class.getGenericInterfaces()).forEach(
				t -> {
					System.out.println("t=" + t + "," + "t.type=" + t.getTypeName());
					System.out.println(t instanceof ParameterizedType);
				}

		);
		System.out.println("===========================================");
		Arrays.stream(InterfaceDemo.class.getInterfaces()).forEach(
				t -> System.out.println("t=" + t + "," + "t.type=" + t.getTypeName())
		);
	}

	class InterfaceDemo<K, V> implements Serializable, Comparable, Map<K, V> {

		@Override
		public int compareTo(@NotNull Object o) {
			return 0;
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean containsKey(Object key) {
			return false;
		}

		@Override
		public boolean containsValue(Object value) {
			return false;
		}

		@Override
		public V get(Object key) {
			return null;
		}

		@Nullable
		@Override
		public V put(K key, V value) {
			return null;
		}

		@Override
		public V remove(Object key) {
			return null;
		}

		@Override
		public void putAll(@NotNull Map<? extends K, ? extends V> m) {

		}

		@Override
		public void clear() {

		}

		@NotNull
		@Override
		public Set<K> keySet() {
			return null;
		}

		@NotNull
		@Override
		public Collection<V> values() {
			return null;
		}

		@NotNull
		@Override
		public Set<Entry<K, V>> entrySet() {
			return null;
		}
	}
}
