package Mathf;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 zero() {
        return new Vector2(0, 0);
    }

    public static Vector2 one() {
        return new Vector2(1, 1);
    }

    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public Vector2 add(Vector2 a) {
        return new Vector2(x + a.x, y + a.y);
    }

    public static Vector2 subtract(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    public Vector2 subtract(Vector2 a) {
        return new Vector2(x - a.x, y - a.y);
    }

    public static Vector2 multiply(Vector2 a, Vector2 b) {
        return new Vector2(a.x * b.x, a.y * b.y);
    }

    public Vector2 multiply(Vector2 a) {
        return new Vector2(x * a.x, y * a.y);
    }

    public static Vector2 divide(Vector2 a, Vector2 b) {
        return new Vector2(a.x / b.x, a.y / b.y);
    }

    public Vector2 divide(Vector2 a) {
        return new Vector2(x / a.x, y / a.y);
    }
}
