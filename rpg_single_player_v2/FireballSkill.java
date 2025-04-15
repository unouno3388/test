public class FireballSkill implements Skill {
    public String getName() {
        return "火球術";
    }

    public void use(Player player, Monster monster) {
        int fireballDamage = 40; // 火球術傷害
        monster.takeDamage(fireballDamage);
        player.addDamage(fireballDamage); // 累計玩家總傷害
    }
}