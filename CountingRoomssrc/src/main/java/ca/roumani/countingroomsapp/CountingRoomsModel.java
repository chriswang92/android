package ca.roumani.countingroomsapp;

/**
 * Created by user on 6/27/17.
 */
public class CountingRoomsModel
{
    private static int buttonPressedCounter;

    private static final int WIDTH = 4;
    private static final int HEIGHT = 5;
    private static int xCoordinate;
    private static int yCoordinate;

    public CountingRoomsModel(){
        CountingRoomsModel.buttonPressedCounter = 0;
        xCoordinate = 0;
        yCoordinate = 0;
    }

    public boolean canGoNorth(){
        if(yCoordinate <= 0){
            return false;
        }
        return true;
    }
    public boolean canGoSouth(){
        if(yCoordinate >= 4){
            return false;
        }
        return true;
    }
    public boolean canGoWest(){
        if(xCoordinate <= 0){
            return false;
        }
        return true;
    }
    public boolean canGoEast(){
        if(xCoordinate >= 3) {
            return false;
        }
        return true;
    }

    public void increNorth(){
        CountingRoomsModel.buttonPressedCounter ++;
        if(canGoNorth()){
            this.yCoordinate --;
        }
    }
    public void increSouth(){
        CountingRoomsModel.buttonPressedCounter ++;
        if(canGoSouth()){
            this.yCoordinate ++;
        }
    }
    public void increWest(){
        CountingRoomsModel.buttonPressedCounter ++;
        if(canGoWest()){
            this.xCoordinate --;
        }
    }
    public void increEast(){
        CountingRoomsModel.buttonPressedCounter ++;
        if(canGoEast()){
            this.xCoordinate ++;
        }
    }
    public String getButtonPressedCounter(){
        return String.format("%d",CountingRoomsModel.buttonPressedCounter);
    }

}
