package frakes_paganini_wegner;

public class Driving extends State{



    @Override
    public void move() {
        double x = vehicle.getX();
        double y = vehicle.getY();

        if(y > 225){
            vehicle.setY(y - 10);
        }

        if(x < 250){
            vehicle.setX(x + 10);
        }


        changeState(x, y);


    }

    @Override
    public void changeState(double x, double y) {
        if(x >= 250 && y <= 225){
            vehicle.changeState(nextState);
        }
    }
}
