public class UsePotionCommand implements Command {
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        if (currentRoom.hasPotion()) {
            player.takeDamage(-30); // Healing is negative damage
            currentRoom.removePotion();
            System.out.println("你喝下治療藥水，回復 30 HP！");
            System.out.println("你的 HP： " + player.getHp());
        } else {
            System.out.println("這裡沒有治療藥水。");
        }
    }
}