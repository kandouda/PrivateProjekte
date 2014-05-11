package com.example.khaled.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	static private int activeSessions;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		activeSessions--;
	}

	public static int getActiveSessions() {
		return activeSessions;
	}

}
