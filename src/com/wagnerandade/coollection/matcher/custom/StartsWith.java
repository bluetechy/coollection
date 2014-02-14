package com.wagnerandade.coollection.matcher.custom;

import com.wagnerandade.coollection.matcher.Matcher;

public class StartsWith implements Matcher {

	private final String matcherValue;

	public StartsWith(String matcherValue) {
		this.matcherValue = matcherValue;
	}

	@Override
	public boolean match(Object value) {
		return String.valueOf(value).startsWith(matcherValue);
	}

}
