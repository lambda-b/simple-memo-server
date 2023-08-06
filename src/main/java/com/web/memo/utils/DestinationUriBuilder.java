package com.web.memo.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

public class DestinationUriBuilder {

	private final List<String> uriList;

	private DestinationUriBuilder(final Builder builder) {
		this.uriList = builder.uriList;
	}

	public static Builder builder() {
		return new Builder(new ArrayList<>());
	}

	public String path() {
		return StringUtils.join(uriList, "/");
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Builder {

		/** URIリスト */
		private final List<String> uriList;

		public DestinationUriBuilder build() {
			return new DestinationUriBuilder(this);
		}

		public Builder company(final String company) {
			uriList.add("company");
			uriList.add(company);
			return new Builder(uriList);
		}

		public Builder user(final String first, final String family) {
			uriList.add("name");
			uriList.add(first + "-" + family);
			return new Builder(uriList);
		}

		public Builder customerQuote(final String ask, final String bid) {
			uriList.add("ask");
			uriList.add(ask);
			uriList.add("bid");
			uriList.add(bid);
			return new Builder(uriList);
		}

	}

}
