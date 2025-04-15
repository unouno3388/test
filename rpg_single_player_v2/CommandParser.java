public class CommandParser {
    public static Command parse(String input) {
        String inputLower = input.toLowerCase();
        if (inputLower.startsWith("move ")) return new MoveCommand(input.substring(5));
        if (inputLower.equals("attack")) return new AttackCommand();
        if (inputLower.equals("look")) return new LookCommand();
        if (inputLower.equals("use potion")) return new UsePotionCommand();
        if (inputLower.startsWith("skill ")) return new SkillCommand(input.substring(6));
        if (inputLower.equals("exit")) return new ExitCommand();
        if (inputLower.startsWith("equip ")) return new EquipCommand(input.substring(6));
        if (inputLower.startsWith("unequip ")) return new UnequipCommand(input.substring(8));
        if (inputLower.equals("bag")) return new InventoryCommand();
        if (input.equals("equipment")) return new EquipmentCommand();
        if (input.equals("show stats")) return new ShowStatsCommand();
        return null;
    }
}
