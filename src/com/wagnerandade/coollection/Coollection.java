package com.wagnerandade.coollection;

import java.util.Collection;

import com.wagnerandade.coollection.matcher.Matcher;
import com.wagnerandade.coollection.matcher.custom.*;
import com.wagnerandade.coollection.query.Query;

public class Coollection {

	public static <T> Query<T> from(Collection<T> collection) {
		return new Query<T>(collection);
	}

	public static Matcher eq(Object value) {
		return new Equals(value);
	}
	
	public static Matcher contains(String value) {
		return new Contains(value);
	}

    public static Matcher startsWith(String value) {
        return new StartsWith(value);
    }
	
	public static Matcher eqIgnoreCase(String value) {
		return new EqualsIgnoreCase(value);
	}
	
	public static Matcher not(Matcher matcher) {
		return new Not(matcher);
	}
	
	public static Matcher greaterThan(Number value) {
		return new GreaterThan(value);
	}
	
	public static Matcher lessThan(Number value) {
		return new LessThan(value);
	}
	
	public static Matcher isNull() {
		return new IsNull();
	}

}