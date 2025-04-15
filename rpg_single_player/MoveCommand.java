public class MoveCommand implements Command {
    private String destination; // 移動的目的地（例如："north", "south"）

    public MoveCommand(String destination) {
        this.destination = destination.trim(); // 去除目的地字串前後的空白
    }

    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 取得玩家目前所在的房間
        Room nextRoom = currentRoom.getExit(destination); // 嘗試取得目標方向的房間

        if (nextRoom != null) { // 如果目標方向有房間
            context.setCurrentRoom(nextRoom); // 更新 GameContext，讓玩家進入新房間
            System.out.println("你移動到了： " + nextRoom.getName()); // 印出新房間的名稱
            System.out.println("你看到： " + nextRoom.getMonster().getName() + " (HP: " + nextRoom.getMonster().getHp() + ")"); // 印出新房間中怪物的資訊
            System.out.println("可用方向： " + nextRoom.getExitString()); // 印出新房間可移動的方向
        } else { // 如果目標方向沒有房間
            System.out.println("無法往 " + destination + " 移動。"); // 印出無法移動的訊息
        }
    }
}