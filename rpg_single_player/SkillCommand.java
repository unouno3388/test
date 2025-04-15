public class SkillCommand implements Command {
    private String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName;
    }

    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Monster monster = currentRoom.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以攻擊的目標！");
            return;
        }

        Skill skill = null;
        if (skillName.equals("fireball")) {
            skill = new FireballSkill();
        }

        if (skill != null) {
            System.out.println("🔥 你施放了【" + skill.getName() + "】！");
            skill.use(player, monster); // 使用技能
            if (!monster.isAlive()) {
                System.out.println(monster.getName() + " 被你燒成灰燼了！");
                player.addKill();
            } else {
                int monsterDamage = monster.getAttack();
                player.takeDamage(monsterDamage);
                System.out.println(monster.getName() + " 反擊你，造成 " + monsterDamage + " 傷害！");
            }

            // 狀態更新
            System.out.println("=== 狀態更新 ===");
            System.out.println("你的 HP： " + player.getHp());
            System.out.println(monster.getName() + " HP： " + monster.getHp());
            System.out.println("總傷害： " + player.getTotalDamage() + "，擊殺數： " + player.getKillCount());

        } else {
            System.out.println("你不會這個技能！");
        }
    }
}