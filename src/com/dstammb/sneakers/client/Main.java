package com.dstammb.sneakers.client;



import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Main implements EntryPoint {


		//convention: CountryName, RegionName, Year, Goods, Unit
		ArrayList<ArrayList <String>> data = new ArrayList();
		

		public Main() {
		}
		/*public String echo() {
		return "I've been created";
		
		}*/
	
				
	public void onModuleLoad() {
		/*Label test = new Label(this.echo());
		RootPanel.get().add(test);*/
		Import importer = new Import();
		//ArrayList<ArrayList<String>> importedData=importer.runImport();
		data.addAll(importer.runImport());
		Button visualizeTable = new Button("Table");
		visualizeTable.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {

				VisualizeTable vt = new VisualizeTable();
				FlexTable t = vt.printTable(data);
				RootPanel.get().add(t);
		    }
		  });
		visualizeTable.setStyleName("visualizeTable");
		
		Button visualizeMap = new Button("Map");
		visualizeMap.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {
				RootPanel.get().add(new Label("MapObject"));
		    }
		  });
		visualizeMap.setStyleName("visualizeMap");
		
		Button visualizeCharts = new Button("Charts");
		visualizeCharts.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {
				RootPanel.get().add(new Label("ChartObject"));
		    }
		  });
		visualizeCharts.setStyleName("Charts");
		
		
		HorizontalPanel vizPanel = new HorizontalPanel();
		vizPanel.setWidth("80%");
		vizPanel.setHeight("100%");
		vizPanel.setStyleName("vizPanel");
		vizPanel.add(new Label("AGRAR VISUALIZER"));
		HorizontalPanel settingsPanel = new HorizontalPanel();
		settingsPanel.setWidth("20%");
		settingsPanel.setHeight("100%");
		settingsPanel.setStyleName("settingsPanel");
		settingsPanel.add(new Label("Settings"));
	
		/*for(int i=0;i<importedData.size();i++) {
		this.data.(importedData.get(i));
		}*/
		/*
		MenuBar menu = new MenuBar();
		MenuBar visualization = new MenuBar(true);
		Command cmd = new Command(){
				public void execute() {
				Window.alert("vClicked");
				}
		};
		Command visualizeTest = new Command(){
				public void execute() {
					
					VisualizeTable vt = new VisualizeTable();
					FlexTable t = vt.printTable(data);
					RootPanel.get().add(t);
					Window.alert("to be implemented");
				}
		
		};
		visualization.addItem("Visualize  Table", visualizeTest);
		visualization.addItem("Visualize Map", cmd);
		menu.addItem("Main", cmd);
		menu.addItem("Settings", cmd);
		menu.addItem("Visualization", visualization);
		menu.addItem("Import/Export", cmd);
		menu.addItem("Help", cmd);
		RootPanel.get().add(menu);
	*/
		RootPanel.get().add(vizPanel);
		RootPanel.get().add(settingsPanel);
		RootPanel.get().add(visualizeTable);
		RootPanel.get().add(visualizeMap);
		RootPanel.get().add(visualizeCharts);
	}

}
