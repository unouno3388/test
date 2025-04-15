public class LookCommand implements Command {
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 取得當前房間
        System.out.println("【房間】： " + currentRoom.getName()); // 印出房間名稱
        System.out.println("【描述】： " + currentRoom.getDescription()); // 印出房間描述lo
        if (currentRoom.getMonster() != null && currentRoom.getMonster().isAlive()) {
            System.out.println("【怪物】： " + currentRoom.getMonster().getName() + " (HP: " + currentRoom.getMonster().getHp() + ")"); // 印出怪物資訊
        }
        if (currentRoom.hasPotion()) {
            System.out.println("【道具】： 治療藥水"); // 印出道具資訊
        }
    }
}