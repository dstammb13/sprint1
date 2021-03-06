package com.dstammb.sneakers.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClientServiceAsync {

	void getData(String query,
			AsyncCallback<ArrayList<ArrayList<String>>> callback);
	
	void importPopulationData(AsyncCallback<Void> callback);

	void getPopulation(String country,
			AsyncCallback<ArrayList<ArrayList<String>>> callback);
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
