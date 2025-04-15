public class InventoryCommand implements Command {
    public void execute(Player player, GameContext context) {
        player.displayInventory();
    }
}