package frakes_paganini_wegner;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Vehicle {
    private Image image;
    private State state;
    private double x;
    private double y;
    private String label;

    private Pane vehicleImageBox;
    private double distanceTraveled;

    /**
     * Vehicle constructor
     * @param image Image for the vehicle
     * @param state Which state is it in
     * @param x coordinate
     * @param y coordinate
     */
    public Vehicle(Image image, State state, double x, double y) {
        this.image = image;
        this.state = state;
        this.x = x;
        this.y = y;
    }

    /**
     * Calling state.move to move vehicle
     */
    public void move(){
        state.move();
    }

    /**
     * Changing state to specified state
     * @param state
     */
    public void changeState(State state) {
        this.state = state;
    }

    /**
     * Nice boolean to know if vehicle is driving
     * @return isDriving
     */
    public boolean isDriving(){
        if (state instanceof Driving){
            return true;
        }
        return false;
    }

    /**
     * Boolean to know if vehicle is flying
     * @return isFlying
     */
    public boolean isFlying() {
        if (state instanceof Flying){
            return true;
        }
        return false;
    }

    /**
     * Boolean to know if vehicle is boating
     * @return isBoating
     */
    public boolean isBoating() {
        if (state instanceof Boating){
            return true;
        }
        return false;
    }

    public double incrementDistance(double x) {
        distanceTraveled = distanceTraveled + x;
        return distanceTraveled;
    }

    /**
     * X coordinate
     * @return X
     */
    public double getX() {
        return x;
    }

    /**
     * Y coordinate
     * @return Y
     */
    public double getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public Pane getVehicleImageBox() {
        return vehicleImageBox;
    }

    /**
     * Depending on state returns that specific picture
     * @return Image of vehicle
     */
    public Image getImage() {
        if(isBoating()){
            image = new Image("jpgs/boat.jpg");
        } else if (isDriving()){
            image = new Image("jpgs/car.jpg");
        } else if (isFlying()){
            image = new Image("jpgs/airplane.jpg");
        }
        return image;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Setter for X
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter for Y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    public void setVehicleImageBox(Pane imageBox) {
        vehicleImageBox = imageBox;
    }

    public String getLabel() {
        if(isBoating()){
            label = "Boating";
        } else if (isDriving()){
            label = "Driving";
        } else if (isFlying()){
            label = "Flying";
        }
        return label;
    }
}
