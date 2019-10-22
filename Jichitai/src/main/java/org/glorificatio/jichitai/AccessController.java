package org.glorificatio.jichitai;

import java.util.List;
import java.util.Map;

import org.glorificatio.jichitai.hp.Site;
import org.glorificatio.jichitai.http.AccessException;
import org.glorificatio.jichitai.http.HttpAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessController implements Runnable {
	
	private Map<String,Long> accessHistory = null;
	
	private List<Site> accessList = null;

	public AccessController(List<Site> accessList  ,Map<String,Long> accessHistory ) {
		this.accessHistory = accessHistory;
		this.accessList = accessList;
	}

	@Override
	public void run() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		while(true) {
			Site site = null;
			synchronized (accessList) {
				if(accessList.size() <= 0) {
					logger.info("終了");
					return;
				}
				
				site = accessList.remove(0);
				
				String pref = site.getPref();
				
				Long lastacess = accessHistory.get(pref);
				
				long now = System.currentTimeMillis();
				
				if(lastacess != null && (now - lastacess) <= (1000*30)) {
					accessList.add(site);
					logger.debug(pref + "であるため後回し");
					continue;
				}
				
				accessHistory.put(pref, now);
			}
			logger.info(site.getPref() + " " + site.getCity());
			String url = site.getUrl();
			
			HttpAccess ac = new HttpAccess();
			try {
				ac.access(url);
			} catch (AccessException e1) {
				e1.printStackTrace();
				//TODO:例外が出た場合は結果に何かを残す
			}
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			
		}
		
	}

}
