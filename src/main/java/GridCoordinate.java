public class GridCoordinate {

    int x;
    int y;
    boolean isOccupied;
    int PlayerId;
    int ShipId;
    public GridCoordinate(int x, int y){
        this.x =x;
        this.y = y;
        this.isOccupied = false;
    }
    public boolean getOccupiedStatus(){
        return this.isOccupied;
    }

    public void setOccupied() throws Exception{
        if(getOccupiedStatus()){
            throw new Exception("Cannot set status of already set co-ordinate");
        }
        this.isOccupied = true;
    }

    public void setPlayerAndShip(int PlayerId, int ShipId){
        this.PlayerId = PlayerId;
        this.ShipId = ShipId;
    }

}
