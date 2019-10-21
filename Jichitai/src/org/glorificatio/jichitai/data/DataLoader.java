package org.glorificatio.jichitai.data;

import java.io.IOException;
import java.util.List;

import org.glorificatio.jichitai.hp.Site;

public interface DataLoader {

	
	public void setSource(String source);
	
	public List<Site> createList() throws IOException;

}
