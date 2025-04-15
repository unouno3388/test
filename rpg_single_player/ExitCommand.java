public class ExitCommand implements Command {
    public void execute(Player player, GameContext context) {
        System.out.println("👋 感謝遊玩！再會，勇者！");
        // 在這裡設置一個標誌，讓遊戲迴圈知道要結束
        // 或者你可以直接使用 System.exit(0); 來終止程式
        // 我會建議使用一個標誌，因為這樣可以更優雅地處理遊戲結束的邏輯
        context.setGameOver(true); // 假設 GameContext 有 setGameOver 方法
    }
}
