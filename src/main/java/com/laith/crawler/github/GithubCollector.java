package com.laith.crawler.github;

import com.laith.crawler.collector.Collector;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.nio.file.Paths;

public class GithubCollector implements Collector {

	@Override
	public Object collect(String initialUrl) {
		String repoUrl = "https://github.com/fastfoodcoding/SpringBootMongoDbCRUD.git";
		String cloneDirectoryPath = "/path/to/directory/"; // Ex.in windows c:\\gitProjects\SpringBootMongoDbCRUD\
		try {
			System.out.println("Cloning "+repoUrl+" into "+repoUrl);
			Git.cloneRepository()
					.setURI(repoUrl)
					.setDirectory(Paths.get(cloneDirectoryPath).toFile())
					.call();
			System.out.println("Completed Cloning");
		} catch (GitAPIException e) {
			System.out.println("Exception occurred while cloning repo");
			e.printStackTrace();
		}
		return null;
	}
}