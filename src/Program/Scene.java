package Program;

import Objects.GameObject;

import java.util.ArrayList;

public class Scene {
    public ArrayList<GameObject> gameObjects = new ArrayList<>();

    public void AddObject(GameObject object) {
        gameObjects.add(object);
        object.start();
    }

    public void RemoveObject(GameObject object) {
        gameObjects.remove(object);
    }

    public ArrayList<GameObject> GetObjectList() {
        return gameObjects;
    }
}
