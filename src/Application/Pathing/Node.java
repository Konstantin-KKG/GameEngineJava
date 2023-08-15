package Application.Pathing;

import Engine.Math.Vector2;

public class Node {
    public Vector2 position;

    public Node(Vector2 _position) {
        position = _position;
    }

    public float distanceToOtherNode(Node other) {
        float dx = other.position.x - position.x;
        float dy = other.position.y - position.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
