public class GameInitializer {
    public static GameContext init() {
        Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
        Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
        forest.setExit("north", temple);
        temple.setExit("south", forest);
        Player player = new Player("勇者", 100, 15, 5);
        // 創建物品
        Item sword = new Item("鐵劍", "一把鋒利的鐵劍", 5, 0);
        Item shield = new Item("木盾", "一面堅固的木盾", 0, 5);
        //Item potion = new Item("治療藥水", "回復少量生命值", 0, 0, 20); // 給藥水設定價格

        // 讓玩家初始就擁有
        player.addItemToInventory(sword);
        player.addItemToInventory(shield);
        //player.addItemToInventory(potion); // 將藥水加入初始背包

        // 給怪物增加掉落物品
        Monster goblin = forest.getMonster();
        goblin.addDrop(new Item("哥布林之牙", "可以用來交易", 0, 0, 5)); // 給哥布林牙齒設定價格
        goblin.addDrop(new Item("破爛布甲", "稍微提供保護", 0, 1, 10)); // 給破爛布甲設定價格

        Monster warrior = temple.getMonster();
        warrior.addDrop(new Item("生鏽的劍", "一把生鏽的劍", 2, 0, 15));

        return new GameContext(player, forest);
    }
}