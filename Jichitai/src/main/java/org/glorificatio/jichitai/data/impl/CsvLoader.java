package org.glorificatio.jichitai.data.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.glorificatio.jichitai.data.DataLoader;
import org.glorificatio.jichitai.hp.Site;
public class CsvLoader implements DataLoader {
	
	private String csvPath = null;

	public CsvLoader() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public List<Site> createList() throws IOException {
		
		List<Site> list = new ArrayList<>();
		Path path = Paths.get(csvPath);
		try(BufferedReader reader =  Files.newBufferedReader(path)){
			reader.lines().forEach((final String line) -> list.add(newSite(line)));			
		} 
		return list;
	}

	@Override
	public void setSource(String source) {
		csvPath = source;
	}
	
	
	private Site newSite(String line) {
		String[] lines = line.split(",");
		return new Site(lines[1],lines[0],lines[2],lines[3]);
	}

}
