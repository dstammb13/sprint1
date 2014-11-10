package com.dstammb.sneakers.client;

import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Main implements EntryPoint {


		//convention: CountryName, RegionName, Year, Goods, Unit
		ArrayList<ArrayList <String>> data = new ArrayList();
		

		public Main() {
		}
		/*public String echo() {
		return "I've been created";
		
		}*/
	
				
		
	@Override
	public void onModuleLoad() {
		/*Label test = new Label(this.echo());
		RootPanel.get().add(test);*/
		Import importer = new Import();
		//ArrayList<ArrayList<String>> importedData=importer.runImport();
		data.addAll(importer.runImport());

		private VerticalPanel vizPanel = new VerticalPanel();
		vizPanel.set(new PopupPanel.PositionCallback() {
	          public void setPosition(int offsetWidth, int offsetHeight) {
		            int left = (Window.getClientWidth() - offsetWidth) / 3;
		            int top = (Window.getClientHeight() - offsetHeight) / 3;
		            p.setPopupPosition(left, top);
		          }
		});
		private VerticalPanel settingsPanel = new VerticalPanel();
		
		/*for(int i=0;i<importedData.size();i++) {
		this.data.(importedData.get(i));
		}*/
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
		
	}

}
