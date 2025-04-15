public class UnequipCommand implements Command {
    private String itemName;

    public UnequipCommand(String itemName) {
        this.itemName = itemName;
    }

    public void execute(Player player, GameContext context) {
        Item itemToUnequip = player.findEquippedItem(itemName);
        if (itemToUnequip != null) {
            player.unequipItem(itemToUnequip);
        } else {
            System.out.println("你沒有裝備 " + itemName + "。");
        }
    }
}
