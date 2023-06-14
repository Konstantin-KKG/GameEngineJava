package Objects;

import Mathf.Vector2;

public class Transform {
    public Transform parent;

    public Vector2 position;
    public Vector2 scale;
    public float rotation;

    public Transform() {
        parent = null;

        position = Vector2.zero();
        scale = Vector2.zero();
        rotation = 0;
    }

    public Transform(Vector2 position, Vector2 scale, float rotation) {
        parent = null;

        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public Transform(Transform parent, Vector2 position, Vector2 scale, float rotation) {
        this.parent = parent;

        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public Vector2 getGlobalPosition() {
        if (parent == null)
            return position;
        else
            return parent.getGlobalPosition().add(position);
    }

    public Vector2 getGlobalScale() {
        if (parent == null)
            return scale;
        else
            return parent.getGlobalScale().add(scale);
    }

    public float getGlobalRotation() {
        if (parent == null)
            return rotation;
        else
            return parent.rotation + rotation;
    }
}
