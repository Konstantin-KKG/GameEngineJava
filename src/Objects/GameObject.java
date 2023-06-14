package Objects;

import Mathf.Vector2;
import Program.LifetimeManager;

public abstract class GameObject {
    public Transform transform = new Transform();

    public abstract void start();
    public abstract void update();
    public abstract void lateUpdate();

    public abstract void draw();

    private void instantiate(GameObject gameObject, Transform parent, Vector2 position, Vector2 scale, float rotation) {
        if (parent != null)
            gameObject.transform.parent = parent;

        gameObject.transform.position = position;
        gameObject.transform.scale = scale;
        gameObject.transform.rotation = rotation;

        LifetimeManager.AddObjectToScene(gameObject);
    }
}
