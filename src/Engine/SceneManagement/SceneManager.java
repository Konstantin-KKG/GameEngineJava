package Engine.SceneManagement;

import Engine.ObjectBase.GameObject;

public final class SceneManager {
    private static Scene activeScene; // Empty default scene

    public static void loadScene(Scene scene) {
        activeScene = scene;
        System.out.println("Loaded scene!");
    }

    public static void addGameObjectActiveScene(GameObject object) {
        activeScene.allGameObjects.add(object);
    }

    public static void removeGameObjectActiveScene(GameObject object) {
        activeScene.allGameObjects.remove(object);
    }

    public static GameObject[] getAllGameObjectsActiveScene() {
        GameObject[] gameObjects = new GameObject[activeScene.allGameObjects.size()];
        gameObjects = activeScene.allGameObjects.toArray(gameObjects);

        return gameObjects;
    }
}
