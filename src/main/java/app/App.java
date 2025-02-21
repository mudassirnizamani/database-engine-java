package app;

public class App {
    private static DB dbApp = new DB();

    public static void main(String[] args) {
        dbApp.init();
        Main main = new Main();
        // commandScene(stage);

        try {
            main.processInput(dbApp);
        } catch (Exception e) {
        }
    }

}
