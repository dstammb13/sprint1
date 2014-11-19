package com.dstammb.sneakers.client;



import java.util.ArrayList;

import com.dstammb.sneakers.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;

public class Main implements EntryPoint {


		//convention: CountryName, RegionName, Year, Goods, Unit
		ArrayList<ArrayList <String>> data = new ArrayList();
		

		private final ClientServiceAsync clientService = GWT.create(ClientService.class);


		private static final String SERVER_ERROR = "An error occurred while "
				+ "attempting to contact the server. Please check your network "
				+ "connection and try again.";
	
	public void onModuleLoad() {
		
		
	
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		

		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		
		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
				RootPanel.get().add(new Label("sendNameToServer sollte aufgerufen worden sein"));
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				clientService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								RootPanel.get().add(new Label("Server ERROR!!!"));
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								RootPanel.get().add(new Label("Server replies: "+ result));
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}
		
		
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
		MyHandler handler = new MyHandler();
		Button visualizeMap = new Button("Map");
		RootPanel.get().add(dialogBox);
		visualizeMap.addClickHandler(new ClickHandler() {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
				RootPanel.get().add(new Label("sendNameToServer sollte aufgerufen worden sein"));
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				//String textToServer = nameField.getText();
				String textToServer = "Test Test";
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				clientService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								RootPanel.get().add(new Label("Server ERROR!!!"));
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								
								RootPanel.get().add(new Label("Server replies: "+ result));
								dialogBox.setText("Remote Procedure Call");
								dialogBox.setText(result);
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
								
							}
						});
			}
		});
		visualizeMap.setStyleName("visualizeMap");
		
		//should control every handle event
		
		
		
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
		//create setting buttons
		Button choosePopulation = new Button("Population");
			choosePopulation.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					VisualizeTable vt = new VisualizeTable();
					
					FlexTable t = vt.printPopulationTable(data);
					RootPanel.get().add(t);

		    }
		  });
			//googleMaps Test
			
			 Maps.loadMapsApi("", "2", false, new Runnable() {
			      public void run() {
			        DockLayoutPanel map = buildUi();
			        RootPanel.get().add(map);
			      }
			    });
		
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
		
		//Stub
		RootPanel.get().add(dialogVPanel);
	


	

	// Add a handler to send the name to the server
	
}
	public DockLayoutPanel buildUi() {
	    // Open a map centered on Cawker City, KS USA
	    LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);

	    final MapWidget map = new MapWidget(cawkerCity, 2);
	    map.setSize("100%", "100%");
	    // Add some controls for the zoom level
	    map.addControl(new LargeMapControl());

	    final DockLayoutPanel dock = new DockLayoutPanel(Unit.PX);
	    dock.addNorth(map, 500);

	    // Add the map to the HTML host page
	    return dock;

	}
}

