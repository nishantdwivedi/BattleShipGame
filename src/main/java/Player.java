import java.util.List;
import java.util.Random;

public class Player {
    int PlayerId;
    String name;
    List<Ship> ships;

    public Player(String name){
        this.PlayerId = new Random().nextInt(1000);
        this.name  = name;
    }

    public List<Ship> getAllShips(){
        return ships;
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    public int getCurrentShipCount(){
        return ships.size();
    }
}
