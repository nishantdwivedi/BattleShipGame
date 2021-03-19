import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    List<Player> Players;
    Board gameBoard;

    public void init(int boardSize, int numberOfPlayers){
        this.gameBoard = new Board(boardSize);
        this.Players = getAllPlayers();
    }

    private List<Player> getAllPlayers(){
        // manual input can be provided in this method
        return new ArrayList<Player>();
    }


    void playGame(){
        while(true){
            Players.forEach( player ->{
                IFireOperation fire = new TorpedoFireOperation();
                List<Ship> ship = player.ships;
                //choose random ship and fire from it
                GridCoordinate fireCoordinate = fire.execute(ship.get(new Random().nextInt()).centreCoordinate);
                // check if it's hit
                if(gameBoard.board[fireCoordinate.x][fireCoordinate.y].isOccupied){
                    int shipId = gameBoard.board[fireCoordinate.x][fireCoordinate.y].ShipId;
                    List<Ship> ships = player.ships;
                    Ship shipToDestroy = null;
                    for(Ship s: ships){
                        if(s.shipId == shipId){
                            shipToDestroy = s;
                        }
                    }
                    //remove the ship from the board
                    gameBoard.removeShip(shipToDestroy);
                    // remove the ship from player List

                    if(player.ships.size() == 0){
                        System.out.println("Player :"+ player.name+ " lost the game");
                    }
            }
        }
            );
        }
    }

}
