public class AttackCommand implements Command {
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Monster monster = currentRoom.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以攻擊的目標！");
            return;
        }

        // 玩家攻擊怪物
        int playerDamage = player.getAttack();
        monster.takeDamage(playerDamage);
        player.addDamage(playerDamage);
        System.out.println("你對 " + monster.getName() + " 造成了 " + playerDamage + " 傷害！");

        // 怪物反擊（如果還活著）
        if (monster.isAlive()) {
            int monsterDamage = monster.getAttack();
            player.takeDamage(monsterDamage);
            System.out.println(monster.getName() + " 反擊你，造成 " + monsterDamage + " 傷害！");
        } else {
            System.out.println(monster.getName() + " 被你擊敗了！");
            player.addKill();

            // Add monster's drops to player's inventory
            if (!monster.getDrops().isEmpty()) {
                System.out.println("你獲得了：");
                for (Item item : monster.getDrops()) {
                    player.addItemToInventory(item);
                    System.out.println("- " + item.getName());
                }
            }
        }

        // 狀態更新
        System.out.println("=== 狀態更新 ===");
        System.out.println("你的 HP： " + player.getHp());
        System.out.println(monster.getName() + " HP： " + monster.getHp());
        System.out.println("總傷害： " + player.getTotalDamage() + "，擊殺數： " + player.getKillCount());
    }
}