import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        // 讓玩家輸入名稱
        System.out.print("請輸入你的名字：");
        String playerName = scanner.nextLine();
        context.getPlayer().setName(playerName); // 設定玩家名稱

        System.out.println("👾 [ 遊戲開始！歡迎 " + context.getPlayer().getName() + " 勇者！ ]");
        System.out.println("你目前在：" + context.getCurrentRoom().getName());
        System.out.println(context.getCurrentRoom().getDescription());
        
        while (context.getPlayer().isAlive() && !context.isGameOver()) {
            System.out.print("> ");
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
            }
        }
        if (!context.getPlayer().isAlive()) {
            System.out.println("你已死亡，遊戲結束。");
        }
        scanner.close();
    }
}