package com.dstammb.sneakers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dstammb.sneakers.client.VisualizeTable;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.FlexTable;


/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class sprint1test extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.dstamm.sneakers.Sprint1";
  }
  
  public void testfillRowTest() {
	  	//setup local comparator
		FlexTable t = new FlexTable();
		  ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		int row = 0;
		int column = 0;
		t.setText(row,column,"country");
		t.setText(row, ++column,"region");
		t.setText(row, ++column, "year");
		t.setText(row, ++column, "goods");
		t.setText(row, ++column, "data");
		t.setText(row, ++column, "unit");
		column = 0;
		
		column = 0;
		t.setText(++row, column, "Armenia");
		t.setText(row, ++column, "OA");
		t.setText(row, ++column, "1992");
		t.setText(row, ++column, "3449.00");
		t.setText(row, ++column, "v.getData()");
		t.setText(row, ++column, "1");
		
		ArrayList<String> line1 = new ArrayList<String>();
		Collections.addAll(line1,"OA","Annual population","1","Armenia","511","Total Population - Both sexes","3010","Population - Est. & Proj.","1992","1000","3449.00","","Official data");
		
		//setup foreign method enviornment
		FlexTable t2 = new FlexTable();
		row = 0;
		column = 0;
		t2.setText(row,column,"country");
		t2.setText(row, ++column,"region");
		t2.setText(row, ++column, "year");
		t2.setText(row, ++column, "goods");
		t2.setText(row, ++column, "data");
		t2.setText(row, ++column, "unit");
		column = 0;
		
		assertEquals(t,t2);
  }
  
  
  public void testprintTableTest()
  {
	  FlexTable t = new FlexTable();
	  ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	  
		int row = 0;
		int column = 0;
		t.setText(row,column,"country");
		t.setText(row, ++column,"region");
		t.setText(row, ++column, "year");
		t.setText(row, ++column, "goods");
		t.setText(row, ++column, "data");
		t.setText(row, ++column, "unit");
		column = 0;
		
		int from = 0;
		int numElements = 2;
		
		
		ArrayList<String> line1 = new ArrayList<String>();
		Collections.addAll(line1,"OA","Annual population","1","Armenia","511","Total Population - Both sexes","3010","Population - Est. & Proj.","1992","1000","3449.00","","Official data");
		
		ArrayList<String> line2 = new ArrayList<String>();
		Collections.addAll(line2,"OA","Annual population","1","Armenia","511","Total Population - Both sexes","3010","Population - Est. & Proj.","1993","1000","3370.00","","Official data");
	
				
		data.add(line1);
		data.add(line2);
		
		column = 0;
		
		t.setText(++row, column, line1.get(0));
		t.setText(row, ++column, line1.get(1));
		t.setText(row, ++column, line1.get(2));
		t.setText(row, ++column, line1.get(3));
		t.setText(row, ++column, "v.getData()");
		t.setText(row, ++column, line1.get(4));

		
		column = 0;
		
		t.setText(++row, column, line2.get(0));
		t.setText(row, ++column, line2.get(1));
		t.setText(row, ++column, line2.get(2));
		t.setText(row, ++column, line2.get(3));
		t.setText(row, ++column, "v.getData()");
		t.setText(row, ++column, line2.get(4));
		
		
		VisualizeTable vt = new VisualizeTable();
		FlexTable t2 = vt.printTable(data);
		
		assertEquals(t, t2 );		
  }
  
  
}

