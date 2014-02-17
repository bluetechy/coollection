package com.wagnerandade.coollection.query.order;

import java.util.Comparator;

import com.wagnerandade.coollection.reflection.Phanton;

public class OrderComparator<T> implements Comparator<T> {

	private String method = null;

	public OrderComparator(String method) {
		this.method = method;
	}

    public OrderComparator() {}

	@Override
	@SuppressWarnings("unchecked")
	public int compare(T one, T other) {
		Object oneValue = method == null ? one : Phanton.from(one).call(method);
		Object otherValue =  method == null ? other : Phanton.from(other).call(method);
		if(oneValue == null || otherValue == null) {
			return 0;
		}
		if(oneValue instanceof Comparable) {
			return ((Comparable<Object>) oneValue).compareTo(otherValue);
		} else {
			return 0;
		}
	}
	
}