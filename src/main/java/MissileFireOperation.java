import java.util.Random;

public class MissileFireOperation implements IFireOperation {
    Board board;
    public GridCoordinate execute(GridCoordinate fireLocation) {
        // generate random value and fire
        int x = fireLocation.x + new Random().nextInt(board.size);
        int y = fireLocation.y + new Random().nextInt(board.size);
        GridCoordinate targetLocation = new GridCoordinate(x,y);
        return targetLocation;
    }
}
