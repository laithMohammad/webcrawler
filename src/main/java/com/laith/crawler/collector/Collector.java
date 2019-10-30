package com.laith.crawler.collector;

public interface Collector<T> {

	T collect(String initialUrl);
}
