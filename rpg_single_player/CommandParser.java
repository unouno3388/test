public class CommandParser {
    public static Command parse(String input) {
        String inputLower = input.toLowerCase(); // Convert input to lowercase
        if (inputLower.startsWith("move ")) return new MoveCommand(input.substring(5));
        if (inputLower.equals("attack")) return new AttackCommand();
        if (inputLower.equals("look")) return new LookCommand();
        if (inputLower.equals("use potion")) return new UsePotionCommand();
        if (inputLower.startsWith("skill ")) return new SkillCommand(input.substring(6));
        if (inputLower.equals("exit")) return new ExitCommand();
        return null;
    }
}
