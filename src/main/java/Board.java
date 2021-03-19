public class Board {
    int size;
    GridCoordinate[][] board;

    public Board(int size){
        this.size = size;
        this.board = createBoard();
    }

    private GridCoordinate[][] createBoard(){
        GridCoordinate[][] board = new GridCoordinate[size][size];
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                board[row][col] = new GridCoordinate(row,col);
            }
        }
        return board;
    }

    public boolean addShipToBoard(Ship ship, Player player){
        GridCoordinate shipCentreCoordinate = ship.centreCoordinate;
        int xCenter = shipCentreCoordinate.x;
        int yCenter = shipCentreCoordinate.y;
        int shipSize = ship.size;
        if(validateShipPlacement(xCenter,yCenter,shipSize)){
            placeShip(ship.shipId, xCenter,yCenter,shipSize,player);
            return true;
        }
        return false;
    }

    public boolean validateShipPlacement(int xCenter, int yCenter, int shipSize){
        int sz = shipSize/2;
        if((xCenter-sz <0 || xCenter + sz >0) || (yCenter-sz <0 || yCenter + sz >0)){
            for(int row = yCenter-sz+1; row<yCenter + sz; row++){
                for(int col = xCenter-sz+1; col<xCenter + sz; col++){
                    if(board[row][col].isOccupied == true){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void placeShip(int shipId, int xCenter, int yCenter, int shipSize, Player player){
        int sz = shipSize/2;
        for(int row = yCenter-sz+1; row<yCenter + sz; row++){
            for(int col = xCenter-sz+1; col<xCenter + sz; col++) {
                GridCoordinate gridCoordinate = board[row][col];
                gridCoordinate.isOccupied = true;
                gridCoordinate.setPlayerAndShip(player.PlayerId, shipId);
            }
        }
    }

    public void removeShip(Ship ship){
        int sz = ship.size/2;
        int yCenter = ship.centreCoordinate.y;
        int xCenter = ship.centreCoordinate.x;
        for(int row = yCenter-sz+1; row<yCenter + sz; row++) {
            for (int col = xCenter - sz + 1; col < xCenter + sz; col++) {
                      board[row][col].isOccupied = false;
            }
        }
        ship.status = ShipStatus.DESTROYED;
    }

    public void displayCurrentBoard(){
        for(int row =0; row< size; row++){
            for(int col =0; col < size; col++){
                GridCoordinate gridCoordinate = board[row][col];
               System.out.println("row is: " + row +" col is: " + col);
               if(gridCoordinate.isOccupied){
                   System.out.println("ShipId is: " + gridCoordinate.ShipId +" Player is: " + gridCoordinate.PlayerId);
               }
               else{
                   System.out.println("Unoccupied grid");
               }
            }
        }
    }
}
