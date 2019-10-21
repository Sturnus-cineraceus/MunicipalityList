package org.glorificatio.jichitai;

import java.io.IOException;
import java.util.List;

import org.glorificatio.jichitai.data.DataLoader;
import org.glorificatio.jichitai.data.DataLoaderFactory;
import org.glorificatio.jichitai.data.DataLoaderFactory.Kind;
import org.glorificatio.jichitai.hp.Site;

public class JichitaiStart {

	public JichitaiStart() {

	}
	
	
	public static void main(String...args) {
		DataLoader loader =  DataLoaderFactory.createLoader(Kind.CSV);
		
		loader.setSource(args[0]);
		try {
			List<Site> list = loader.createList();
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
