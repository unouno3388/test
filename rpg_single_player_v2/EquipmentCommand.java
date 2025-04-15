public class EquipmentCommand implements Command {
    public void execute(Player player, GameContext context) {
        player.displayEquipment();
    }
}
