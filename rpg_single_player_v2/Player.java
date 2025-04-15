import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private int hp;
    private int baseAttack;
    private int attack;
    private int defense;
    private int killCount = 0;
    private int totalDamage = 0;
    private List<Item> equipment = new ArrayList<>();
    private List<Item> inventory = new ArrayList<>(); // 玩家的背包

    public Player(String name, int hp, int baseAttack, int defense) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
        this.attack = baseAttack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void addKill() {
        killCount++;
    }

    public void addDamage(int dmg) {
        totalDamage += dmg;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void equipItem(Item item) {
        if (inventory.contains(item)) {
            equipment.add(item);
            inventory.remove(item); // 從背包中移除
            attack += item.getAttackBonus();
            defense += item.getDefenseBonus();
            System.out.println("你裝備了 " + item.getName() + "！");
        } else {
            System.out.println("你沒有 " + item.getName() + " 在背包中。");
        }
    }

    public void unequipItem(Item item) {
        if (equipment.contains(item)) {
            equipment.remove(item);
            inventory.add(item); // 放回背包
            attack -= item.getAttackBonus();
            defense -= item.getDefenseBonus();
            System.out.println("你卸下了 " + item.getName() + "。");
        } else {
            System.out.println("你沒有裝備 " + item.getName() + "。");
        }
    }

    public void displayEquipment() {
        if (equipment.isEmpty()) {
            System.out.println("你沒有裝備任何物品。");
        } else {
            System.out.println("你裝備了：");
            for (Item item : equipment) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("你的背包是空的。");
        } else {
            System.out.println("你的背包裡有：");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription() + " (價格: " + item.getPrice() + ")"); // 顯示價格
            }
        }
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println("你獲得了 " + item.getName() + "！");
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item findEquippedItem(String itemName) {
        for (Item item : equipment) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public void displayAttack() { // 新增顯示攻擊力的方法
        System.out.println("你的當前攻擊力為：" + attack);
    }
    public void displayStats() { // 修改後的顯示所有數值的方法
        System.out.println("=== 角色狀態 ===");
        System.out.println("名稱： " + name);
        System.out.println("HP： " + hp);
        System.out.println("基礎攻擊力： " + baseAttack);
        System.out.println("當前攻擊力： " + attack);
        System.out.println("防禦力： " + defense);
        System.out.println("擊殺數： " + killCount);
        System.out.println("總傷害： " + totalDamage);
        System.out.println("==============");
    }
}