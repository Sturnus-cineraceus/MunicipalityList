package org.glorificatio.jichitai;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.glorificatio.jichitai.data.DataLoader;
import org.glorificatio.jichitai.data.DataLoaderFactory;
import org.glorificatio.jichitai.data.DataLoaderFactory.Kind;
import org.glorificatio.jichitai.hp.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JichitaiStart {

	private static int WORKERS = 3;
	
	public static void main(String...args) {
		DataLoader loader =  DataLoaderFactory.createLoader(Kind.CSV);
		
		loader.setSource(args[0]);
		
		Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());
		
		logger.info("開始");
		try {
			List<Site> list = loader.createList();
			
			List<Site> synclist = Collections.synchronizedList(list);
			
			Collections.shuffle(synclist);
			
			logger.info("読み込みサイズ : " + synclist.size());
			
			Map<String,Long> history = Collections.synchronizedMap(new HashMap<String, Long>());
			
			for(int i = 0 ; i < WORKERS ; i++) {
				AccessController controller = new AccessController(synclist, history);
				Thread th = new Thread(controller);
				th.start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("異常終了", e);
			System.exit(1);
		}
		
		logger.info("終了");
		
	}

}
