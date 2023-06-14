import Program.ProgramCore;

public class Main {
    public static ProgramCore mainThread;

    public static void main(String[] args) {
        System.out.println("Creating Program Thread");

        mainThread = new ProgramCore();
        mainThread.start();

        System.out.println("Program Thread Started");
    }
}