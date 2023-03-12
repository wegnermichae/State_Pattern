package frakes_paganini_wegner;

public class Boating extends State{



    @Override
    public void move() {
        double x = vehicle.getX();
        double y = vehicle.getY();



        if(x < 550){
            vehicle.setX(x + 4);
        }

        changeState(x, y);


    }

    @Override
    public void changeState(double x, double y) {
        if(x >= 550){
            vehicle.changeState(nextState);
        }
    }
}
