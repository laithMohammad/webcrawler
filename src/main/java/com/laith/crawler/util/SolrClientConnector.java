package com.laith.crawler.util;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class SolrClientConnector {

	private HttpSolrClient solr;

	private SolrClientConnector() {
		String urlString = "http://localhost:8983/solr/stackoverflow";
		this.solr = new HttpSolrClient.Builder(urlString).build();
	}

	public int registerBean(Object object, boolean doCommit) {
		try {
			UpdateResponse response = solr.addBean(object);
			if (doCommit) {
				solr.commit();
			}
			return response.getStatus();
		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int registerDocument(Map<String, Object> documentAttributes, boolean doCommit) {
		try {
			final SolrInputDocument document = new SolrInputDocument();
			documentAttributes.forEach((k, v) -> {
				document.addField(k, v);
			});
			UpdateResponse response = solr.add(document);
			if (doCommit) {
				solr.commit();
			}
			return response.getStatus();
		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deleteDocument(String id, boolean doCommit) {
		try {
			UpdateResponse response = solr.deleteById(id);
			if (doCommit) {
				solr.commit();
			}
			return response.getStatus();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deleteAll() {
		try {
			UpdateResponse response = solr.deleteByQuery("*:*");
			solr.commit();
			return response.getStatus();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int commit() {
		try {
			return solr.commit().getStatus();
		} catch (SolrServerException | IOException e) {
			return -1;
		}
	}
}