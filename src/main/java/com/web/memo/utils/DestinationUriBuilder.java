package com.web.memo.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class DestinationUriBuilder {

	private final List<String> uriList;

	private DestinationUriBuilder(final Builder builder) {
		this.uriList = builder.uriList;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String path() {
		return StringUtils.join(uriList, "/");
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Builder {

		/** URIリスト */
		private final List<String> uriList = new ArrayList<>();

		public DestinationUriBuilder build() {
			return new DestinationUriBuilder(this);
		}

		public Builder company(final String company) {
			uriList.add("company");
			uriList.add(company);
			return this;
		}

		public Builder user(final String first, final String family) {
			uriList.add("name");
			uriList.add(first + "-" + family);
			return this;
		}

		public Builder customerQuote(final String ask, final String bid) {
			uriList.add("ask");
			uriList.add(ask);
			uriList.add("bid");
			uriList.add(bid);
			return this;
		}

	}

}
