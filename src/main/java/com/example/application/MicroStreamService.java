package com.example.application;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

/**
 * 
 * @author Frederik Mortensen
 *
 */
@Service
public class MicroStreamService {

	private static EmbeddedStorageManager storageManager;

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	@PostConstruct
	public void init() {

		logger.info("== Initializing microstream database... ==");

		// Initialize a storage manager ("the database") with purely defaults.
		storageManager = EmbeddedStorage.start();

		if (storageManager.root() == null) {
			DataRoot dataRoot = new DataRoot();
			dataRoot.setUpdated(new Date());
			storageManager.setRoot(dataRoot);
			storageManager.storeRoot();
			logger.info("Initialized data root at " + dataRoot.getUpdated());
		} else {
			DataRoot dataRoot = (DataRoot) storageManager.root();
			logger.info("Loaded data root." + dataRoot.getUpdated());
		}

		logger.info("== Database initialization finished. ==");

	}

	/**
	 * 
	 * @param dataRoot
	 */
	public void update(DataRoot dataRoot) {

	}

	/**
	 * 
	 */
	@PreDestroy
	public void shutdown() {
		logger.info("== Shutting down database... ==");
		storageManager.shutdown();
		logger.info("== Database shutdown finished. ==");

	}

}