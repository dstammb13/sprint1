package com.dstammb.sneakers.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Import implements IO {
	
public ArrayList<ArrayList<String>> runImport() {
	String csvFile = "/home/nw21/Dokumente/HS_2014/Software_Engenieering/Class02/population 1990-2011.csv";
	BufferedReader br = null;
	String line = "";
    String csvSplitBy = "\\,";
    ArrayList< ArrayList<String> > wholeList =new ArrayList();
    try {
        
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
        	/*for(int i=0;i<dataLine.length;i++) {
        		RootPanel.get().add(new Label(dataLine.[i]));
        	}*/
        	//ArrayList<String> dataLine = new ArrayList();
           // for(int i=0;i<dataLine.length; i++) {
            	//dataLine.add(dataLine[i]);
            	//RootPanel.get().add(new Label(dataLine.get(i)));
            //}
            
 
            ArrayList<String> toBeInserted = new ArrayList();

            toBeInserted.add(dataLine[3]);
            toBeInserted.add("NULL");
            toBeInserted.add(dataLine[8]);
            toBeInserted.add(dataLine[10]);
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
 return wholeList;
}
}
