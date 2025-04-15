public class ShowAttackCommand implements Command { // 新增類別
    public void execute(Player player, GameContext context) {
        player.displayAttack();
    }
}
