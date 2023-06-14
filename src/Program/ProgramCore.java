package Program;

public class ProgramCore extends Thread {
    boolean running = true;

    long initialTime = System.nanoTime();

    final double timeU = 1000000000 / 60f;
    final double timeF = 1000000000 / 144f;
    double deltaU = 0, deltaF = 0;
    int ticks = 0, frames = 0;

    long timer = System.currentTimeMillis();

    @Override
    public void run() {
        while (running) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            // Update
            if (deltaU >= 1) {
                // TODO: Gather input and stuff
                gameUpdate();
                gameLateUpdate();

                ticks++;
                deltaU--;
            }

            // Render
            if (deltaF >= 1) {
                gameDraw();

                frames++;
                deltaF--;
            }

            printStats();
        }
    }

    private void printStats() {
        if (System.currentTimeMillis() - timer > 1000) {
            System.out.printf("UPS: %s, FPS: %s%n", ticks, frames);

            frames = 0;
            ticks = 0;
            timer += 1000;
        }
    }

    private void gameStart() {

    }

    private void gameUpdate() {

    }

    private void gameLateUpdate() {

    }

    private void gameDraw() {

    }
}
