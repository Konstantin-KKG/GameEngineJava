package Engine.Math;

public class Vector2 {
    public float x, y;

    public Vector2 (float _x, float _y) {
        x = _x;
        y = _y;
    }

    public static Vector2 zero(){
        return new Vector2(0, 0);
    }
    public static Vector2 one(){
        return new Vector2(1, 1);
    }

    // Math functions
    public Vector2 add(Vector2 other) {
        x += other.x;
        y += other.y;
        return this;
    }

    public Vector2 subtract(Vector2 other) {
        x -= other.x;
        y -= other.y;
        return this;
    }

    public Vector2 multiply(Vector2 other) {
        x *= other.x;
        y *= other.y;
        return this;
    }

    public Vector2 divide(Vector2 other) {
        x /= other.x;
        y /= other.y;
        return this;
    }
}
