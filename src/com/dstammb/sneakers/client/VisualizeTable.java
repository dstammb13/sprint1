package com.dstammb.sneakers.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class VisualizeTable extends Visualization {
	public FlexTable printTable(ArrayList<ArrayList<String>> data) {
	FlexTable t = new FlexTable();
	int row = 0;
	int column = 0;
	t.setText(row,column,"country");
	t.setText(row, ++column,"region");
	t.setText(row, ++column, "year");
	t.setText(row, ++column, "goods");
	t.setText(row, ++column, "data");
	t.setText(row, ++column, "unit");
	column = 0;
	
	int from=0;
	int numElements=20;
	for(int i=from;i<from+numElements;i++) {
		row = fillRow(t, row, data.get(i));
	}
	
	return t;
	}/*
	public PopupPanel visualizePopup(Array) {
		FlexTable t;
		t = printTable(data);
		PopupPanel p = new PopupPanel();
		p = createPopup();
		p.add(t);
		return p;
	}
	public PopupPanel createPopup() {
		final PopupPanel p = new PopupPanel();
		p.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
	          public void setPosition(int offsetWidth, int offsetHeight) {
		            int left = (Window.getClientWidth() - offsetWidth) / 3;
		            int top = (Window.getClientHeight() - offsetHeight) / 3;
		            p.setPopupPosition(left, top);
		          }
		});
		return p;
	}*/
	public int fillRow(FlexTable t, int row, ArrayList<String> data) {
		
		int column = 0;
		t.setText(++row, column, data.get(0));
		t.setText(row, ++column, data.get(1));
		t.setText(row, ++column, data.get(2));
		t.setText(row, ++column, data.get(3));
		t.setText(row, ++column, "v.getData()");
		t.setText(row, ++column, data.get(4));
		return row;
	}
	
	}
	


