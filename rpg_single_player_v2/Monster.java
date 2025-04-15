import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String name;
    private int hp;
    private int attack;
    private List<Item> drops = new ArrayList<>(); // 新增掉落物品列表

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.drops = new ArrayList<>(); // 初始化掉落物品列表
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public void addDrop(Item item) { // 新增增加掉落物品的方法
        drops.add(item);
    }

    public List<Item> getDrops() { // 新增取得掉落物品列表的方法
        return drops;
    }
}