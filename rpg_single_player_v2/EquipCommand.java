public class EquipCommand implements Command {
    private String itemName;

    public EquipCommand(String itemName) {
        this.itemName = itemName;
    }

    public void execute(Player player, GameContext context) {
        Item itemToEquip = player.findItemInInventory(itemName);
        if (itemToEquip != null) {
            player.equipItem(itemToEquip);
        } else {
            System.out.println("你沒有 " + itemName + " 在背包中。");
        }
    }
}
