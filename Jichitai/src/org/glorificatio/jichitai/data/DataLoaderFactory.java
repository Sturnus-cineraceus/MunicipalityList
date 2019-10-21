package org.glorificatio.jichitai.data;

import org.glorificatio.jichitai.data.impl.CsvLoader;

public class DataLoaderFactory {
	
	
	public enum Kind {
		CSV;
	}
	
	
	public static DataLoader createLoader(Kind kind) {
		DataLoader loader = null;
		switch (kind) {
		case CSV:
			loader = new CsvLoader();
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + kind);
		}
		
		return loader;
	}

}
