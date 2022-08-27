package com.example.application;

import java.util.Date;

/**
 * Root class for all objects that will be serialized with microstream.
 * 
 * @author frederik.mortensen
 */
public class DataRoot {

	private Date updated;

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
