public class Player {
    private String name;
    private int hp;
    private int attack;
    private int killCount = 0;
    private int totalDamage = 0;

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // 新增 setName 方法
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

    public int getAttack() {
        return attack;
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
}