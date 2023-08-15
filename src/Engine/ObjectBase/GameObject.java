package Engine.ObjectBase;

import Engine.Graphics.Renderer;
import Engine.Math.Vector2;
import Engine.SceneManagement.SceneManager;

public abstract class GameObject {
    public Transform transform = new Transform();

    public abstract void start();
    public abstract void fixedUpdate();
    public abstract void update();
    public abstract void render(Renderer renderer);

    protected void instantiate(GameObject object, Vector2 position) {
        instantiate(object, null, position);
    }
    protected void instantiate(GameObject object, GameObject parent, Vector2 position) {
        if (parent != null)
            object.transform.parent = parent.transform;
        object.transform.localPosition = position;

        SceneManager.addGameObjectActiveScene(object);
        object.start();
    }

    protected void destroy(GameObject object) {
        SceneManager.removeGameObjectActiveScene(object);
    }
}
