package com.dms.utils;

import org.springframework.data.domain.Sort;

public class SortTools {
	public static Sort basicSort() {
		return basicSort("desc", "id");
	}

	public static Sort basicSort(String orderType, String orderField) {
		Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
		return sort;
	}
}
