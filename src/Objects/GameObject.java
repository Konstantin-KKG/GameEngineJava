package Objects;

public abstract class GameObject {
    public Transform transform = new Transform();

    protected abstract void start();
    protected abstract void update();
    protected abstract void lateUpdate();

    protected abstract void draw();
}
