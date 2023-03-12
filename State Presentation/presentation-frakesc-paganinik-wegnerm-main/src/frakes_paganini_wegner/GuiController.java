package frakes_paganini_wegner;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

public class GuiController {

    @FXML
    private GridPane driversPane;

    @FXML
    private Pane displayPane;

    @FXML
    private TextField input;

    // The three states
    private Driving driving = new Driving();
    private Flying flying = new Flying();
    private Boating boating = new Boating();

    private int howMany = 1;


    // Starting vehicle
    private Vehicle vehicle = new Vehicle(new Image("jpgs/car.jpg"), driving, 10, 350);

    // Box for vehicle
    private Pane vehicleImageBox = new VBox();


    /**
     * Initialize function to get everything ready to go
     */
    @FXML
    public void initialize(){
        // Setup for state pattern
        driving.setVehicle(vehicle);
        flying.setVehicle(vehicle);
        boating.setVehicle(vehicle);

        // setting next states
        driving.setNextState(boating);
        boating.setNextState(flying);
        flying.setNextState(driving);

        // Weird javafx things
        displayPane.setFocusTraversable(true);
        driversPane.setFocusTraversable(true);
        input.setFocusTraversable(false);


        // Background beach
        BackgroundImage myBI= new BackgroundImage(new Image("jpgs/beach.png",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        driversPane.setBackground(new Background(myBI));

        // Displaying the vehicle in drive mode
        displayVehicle();





    }

    /**
     * registering right arrow keys
     * @param keyEvent
     */
    @FXML
    public void moveVehicle(KeyEvent keyEvent){

        if (keyEvent.getCode() == KeyCode.RIGHT){
            vehicle.move();
        }
        displayVehicle();

    }

    /**
     * Displaying the vehicle in Javafx
     */
    public void displayVehicle(){
        displayPane.getChildren().clear();
        vehicleImageBox.getChildren().clear();
        System.out.println(vehicle.getX() + ", " + vehicle.getY());
        vehicleImageBox.setLayoutX(vehicle.getX());
        vehicleImageBox.setLayoutY(vehicle.getY());
        displayPane.getChildren().add(vehicleImageBox);
        ImageView vehicleImage = new ImageView(vehicle.getImage());
        vehicleImage.setPreserveRatio(true);
        vehicleImage.setFitWidth(50.0);
        vehicleImageBox.getChildren().add(vehicleImage);
        Label vehicleLabel = new Label(vehicle.getLabel());
        vehicleImageBox.getChildren().add(vehicleLabel);
    }


    public void howManyVehicles(ActionEvent actionEvent) {
        howMany = Integer.parseInt(input.getText());
        for(int i = 0; i < howMany; i++){
            // Vehicle vehicle = new Vehicle();
        }

    }
}
