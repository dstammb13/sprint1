package com.dstammb.sneakers.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ClientService extends RemoteService {
	public ArrayList<ArrayList<String>> getData(String query);
	public void importPopulationData();
	public ArrayList<ArrayList<String>> getPopulation(String country);
	String greetServer(String name) throws IllegalArgumentException;

}
