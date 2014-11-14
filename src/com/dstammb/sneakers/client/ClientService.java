package com.dstammb.sneakers.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ClientService extends RemoteService {
	public ArrayList<ArrayList<String>> getData(String query);
	public void createTable();

}
