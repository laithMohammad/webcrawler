package com.laith.crawler.stackoverflow;

import com.laith.crawler.collector.Collector;
import com.laith.crawler.config.PropertiesConfig;
import com.laith.crawler.stackoverflow.entities.Item;
import com.laith.crawler.stackoverflow.entities.Post;
import com.laith.crawler.util.HttpUtil;
import com.laith.crawler.util.JsonUtil;
import com.laith.crawler.util.SolrClientConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StackOverFlowCollector implements Collector<Post> {

	@Autowired
	SolrClientConnector solrClientConnector;

	private static final String STACK_OVER_FLOW_POSTS = "https://api.stackexchange.com/2.2/posts?page=%d&pagesize=%d&order=asc&sort=creation&site=stackoverflow";
	private static final long stackOverFlowPageSize = PropertiesConfig.getLong("StackOverFlow.Page.Size");
	private static final long stackOverFlowStartPage = PropertiesConfig.getLong("StackOverFlow.Page.Start");

	@Override
	public Post collect(String initialUrl) {
		try {
			processPostIndexing(stackOverFlowStartPage, stackOverFlowPageSize);
			return null;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void processPostIndexing(long pageNumber, long pageSize) throws IOException, InterruptedException {
		String response = HttpUtil.getJson(String.format(STACK_OVER_FLOW_POSTS, pageNumber, pageSize));
		Post post = JsonUtil.parse(response, Post.class);
		for (Item item : post.getItems()) {
			solrClientConnector.registerDocument(item.getItemMap(), false);
		}
		solrClientConnector.commit();
		if(post.getBackoff() != null && post.getBackoff() > 0) {
			Thread.sleep(post.getBackoff() * 1000);
		}
		System.out.println(post.getItems().size() + " Have been processed correctly!!!");
		if(post.getHas_more() != null && post.getHas_more()) {
			processPostIndexing(++pageNumber, pageSize);
		}
	}

}
