package com.dstammb.sneakers.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.dstammb.sneakers.client.ClientService;
import com.dstammb.sneakers.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;





public class ClientServiceImpl extends RemoteServiceServlet implements ClientService
	{
	ArrayList<ArrayList<String>> data;
	//Constructor
	public ClientServiceImpl() {};
	//get Data (maybe to be ommitted)
	public ArrayList<ArrayList<String>> getData(String data){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		return result;
	}
	
	//getPopulationData
	public ArrayList<ArrayList<String>> getPopulation(String country) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(int i=0;i<data.size();++i) {
			if(data.get(i).get(3) == country ) {
				result.add(data.get(i));
			}
		}
		return result;
	}
	
	/*
	public ArrayList<ArrayList<String>> getData(ArrayList<ArrayList<String>> query) {
		//tobe Implemented
		
		/*
		 * 
		 * query: list of filters
		 * filter: what, from, to
		 * 
		 * Example: (country,Armenia,NULL),(year,1990,1991),(exports,90000,NULL)
		 * 
		 * /
		
		ArrayList<String> result = new ArrayList<String>();
		switch(what) {
			case "country":
				//from is the country id, wanted: all information related to countries
				
				//TODO: iterate through data to return lines with country
				for(int i=0;i<data.size();++i) {
					if(1==1/*country.id==from* /) {
						result.add(data[i]);
					}
				}
			break;
			case "year":
				//what: year
				boolean countryFound=false;
				for(int i=0;i<result.size();++i) {
					if(1==1/*line contains year* /) {
						result.add(data[i]);
						countryFound=true;
					} else if(countryFound) {
						break;
					}
				}
			break;
			case "exports":
				
			break;
		}
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<ArrayList<String>> wholeList = new ArrayList<ArrayList<String>>();
		return wholeList;
	} */
	
	public void importPopulationData() {

		String csvFile = "com.dstammb.war.sprint1.gwt.population 1990-2011.csv";
		String line = "";
	    String csvSplitBy = "\\,";
	    ArrayList< ArrayList<String> > wholeList =new ArrayList();
	    BufferedReader br = null;
	    
	    try {     
	    	//foreignData=makeRPCCall();
	    br = new BufferedReader(new FileReader(csvFile));
	    
	        int numColumns=0;
	        int j=0;
	        while ((line = br.readLine()) != null && line.length()!=0 && j!=0) {
	        	
	                // use comma as separator
	        	String[] dataLine = line.split(csvSplitBy);
	        	if(j==0) {
	        		numColumns=dataLine.length;
	        	} else {
	        		if(numColumns!=dataLine.length) {
	        			break;
	        		}
	        	}
	        	/*
	        	for(int i=0;i<dataLine.length;i++) {
	        		//RootPanel.get().add(new Label(dataLine[i]));
	        	}
	        	ArrayList<String> dataLine = new ArrayList();
	            for(int i=0;i<dataLine.length; i++) {
	            	dataLine.add(dataLine[i]);
	            	RootPanel.get().add(new Label(dataLine.get(i)));
	            }*/
	            
	 
	            ArrayList<String> toBeInserted = new ArrayList();
	            
	            //Country
	            toBeInserted.add(dataLine[3]);
	            //
	            toBeInserted.add("NULL");
	            //Year
	            toBeInserted.add(dataLine[8]);
	            //Value or Population
	            toBeInserted.add(dataLine[10]);
	            //Country ID
	            toBeInserted.add(dataLine[2]);
	            
	            wholeList.add(toBeInserted);
	            j++;
	        }
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    data=wholeList;

	}
	public String greetServer(String input) throws IllegalArgumentException {
	

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}


}
