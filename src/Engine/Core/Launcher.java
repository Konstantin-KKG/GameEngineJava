package Engine.Core;

public final class Launcher {
    public static Core mainProcess;
    private static Thread mainThread;

    public static void main(String[] args) {
        mainProcess = new Core();
        mainThread = new Thread(mainProcess);

        mainThread.start();
    }
}