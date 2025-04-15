public class GameContext {
    private Player player;
    private Room currentRoom;
    private boolean gameOver = false; // 新增 gameOver 標誌

    public GameContext(Player player, Room startRoom) {
        this.player = player;
        this.currentRoom = startRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public boolean isGameOver() {  // 新增 getter
        return gameOver;
    }

    public void setGameOver(boolean gameOver) { // 新增 setter
        this.gameOver = gameOver;
    }
}