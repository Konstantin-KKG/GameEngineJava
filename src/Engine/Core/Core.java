package Engine.Core;

import Application.MainObject;
import Engine.Graphics.Camera;
import Engine.ObjectBase.GameObject;
import Engine.Graphics.Renderer;
import Engine.SceneManagement.Scene;
import Engine.SceneManagement.SceneManager;

public class Core implements Runnable {
    private boolean running;
    public final int UPDATE_PER_MINUTE = 60;
    private final double UPDATE_STEP = 1.0d/UPDATE_PER_MINUTE;

    private long nextStatTime;
    private int fps, ups;

    private final Renderer RENDERER = new Renderer();

    @Override
    public void run() {
        running = true;
        nextStatTime = System.currentTimeMillis() + 1000;

        coreLoop();
    }

    private void coreLoop() {
        double accumulator = 0;
        long currentTime, lastTime = System.currentTimeMillis();

        // Setup a default scene & a default object
        Scene defaultScene = new Scene();
        SceneManager.loadScene(defaultScene);
        MainObject firstObject = new MainObject();

        firstObject.defaultScene = defaultScene;
        SceneManager.addGameObjectActiveScene(firstObject);

        // Camera setup
        Camera.SetRenderer(RENDERER);

        // Time setup
        Time.calcBeginTime();

        // Start
        startCall();

        while (running){
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSec = (currentTime - lastTime) / 1000d;
            accumulator += lastRenderTimeInSec;
            lastTime = currentTime;

            while (accumulator > UPDATE_STEP){
                // Update
                fixedUpdateCall();
                accumulator -= UPDATE_STEP;
            }

            // Render
            renderCall();
            Time.calcDeltaTime();
            updateCall();

            printStats();
        }
    }

    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime){
            System.out.printf("FPS: %d, UPS: %d, DeltaTime: %f%n", fps, ups, Time.deltaTime());
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void startCall() {
        GameObject[] gameObjects = SceneManager.getAllGameObjectsActiveScene();
        for (GameObject object: gameObjects) {
            object.start();
        }
    }

    private void fixedUpdateCall() {
        GameObject[] gameObjects = SceneManager.getAllGameObjectsActiveScene();
        for (GameObject object: gameObjects) {
            object.fixedUpdate();
        }
        ups++;
    }

    private void updateCall() {
        GameObject[] gameObjects = SceneManager.getAllGameObjectsActiveScene();
        for (GameObject object: gameObjects) {
            object.update();
        }
    }

    private void renderCall() {
        RENDERER.clearViewport();

        GameObject[] gameObjects = SceneManager.getAllGameObjectsActiveScene();
        for (GameObject object: gameObjects) {
            object.render(RENDERER);
        }

        RENDERER.swapFrameBuffer();
        fps++;
    }
}
