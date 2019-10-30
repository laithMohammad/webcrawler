package com.laith.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.*;

@EnableScheduling
@SpringBootApplication
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Main.class);
	}

	public static void crawl() {
		BasicWebCrawler basicWebCrawler = new BasicWebCrawler();
		basicWebCrawler.preparePageLinks("https://techcrunch.com");
		Set<String> links = basicWebCrawler.getLinks();
		System.out.println("Fetched Links = " + links.size());
	}

	public static class BasicWebCrawler {
		Set<String> links;

		public BasicWebCrawler(Set<String> links) {
			this.links = links;
		}

		public BasicWebCrawler() {
			links = new HashSet<String>();
		}

		public Set<String> getLinks() {
			return links;
		}

		public void preparePageLinks(String url) {
			if (!links.contains(url)) {
				try {
					if (links.add(url)) {
						System.out.println(url);
					}
					Document document = Jsoup.connect(url).get();
					Elements elements = document.select("a[href]");
					for (Element element : elements) {
						preparePageLinks(element.attr("abs:href"));
					}
				} catch (IOException e) {
					System.out.println("Error in URL: " + url + " - Message: " + e.getMessage());
				}
			}
		}
	}
}
