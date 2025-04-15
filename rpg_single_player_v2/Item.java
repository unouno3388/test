public class Item {
    private String name;
    private String description;
    private int attackBonus;
    private int defenseBonus;
    private int price; // 新增價格

    public Item(String name, String description, int attackBonus, int defenseBonus) { // 修改建構子
        this(name, description, attackBonus, defenseBonus, 0); // 預設價格為 0
    }
    public Item(String name, String description, int attackBonus, int defenseBonus, int price) {
        this.name = name;
        this.description = description;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getPrice() { // 新增 price 的 getter
        return price;
    }
}