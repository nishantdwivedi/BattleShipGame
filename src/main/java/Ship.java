import java.util.Random;

public class Ship {
    int shipId;
    int size;
    GridCoordinate centreCoordinate;
    ShipStatus status;

    public Ship(int size, GridCoordinate centreCoordinate){
        this.shipId = new Random().nextInt(1000);
        this.centreCoordinate = centreCoordinate;
        this.size = size;
        this.status = ShipStatus.OPERATIONAL;
    }

    public int getSize() {
        return size;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) throws Exception{
        if(this.status.equals(ShipStatus.DESTROYED)){
            throw new Exception("Cannot set the status of a destroyed ship");
        }
        this.status = status;
    }

    public GridCoordinate getCentreCoordinate() {
        return centreCoordinate;
    }

    public void destroyShip(){
        this.status = ShipStatus.DESTROYED;
    }

}
