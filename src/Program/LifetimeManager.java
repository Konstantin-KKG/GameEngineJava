package Program;

import Objects.GameObject;

import java.util.ArrayList;

public class LifetimeManager {
    public static Scene testScene = new Scene();

    public static void AddObjectToScene(GameObject object) {
        testScene.AddObject(object);
        object.start();
    }

    public static void RemoveObjectFromScene(GameObject object) {
        testScene.RemoveObject(object);
    }

    // TODO: Collect gameObjects of active scenes
}
