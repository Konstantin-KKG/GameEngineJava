package Application.Pathing;

import Engine.Graphics.Renderer;
import Engine.Math.Vector2;
import Engine.ObjectBase.GameObject;
import Engine.ObjectBase.Transform;

public class NodePath extends GameObject {
    private Node[] nodes;

    public NodePath(Node[] _nodes) {
        nodes = _nodes;
    }

    public Vector2 getPositionAtDistance(float distanceNormalized) {
        float distance = calculatePathTotalDistance() * distanceNormalized;

        double totalDistance = 0;
        Node prevNode = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node curNode = nodes[i];
            double segmentDistance = prevNode.distanceToOtherNode(curNode);

            if (totalDistance + segmentDistance >= distance) {
                // The target position is in the current segment
                double remainingDistance = distance - totalDistance;
                double ratio = remainingDistance / segmentDistance;

                Vector2 prevNodePos = new Vector2(prevNode.position.x, prevNode.position.y);
                Vector2 curNodePos = new Vector2(curNode.position.x, curNode.position.y);

                double x = prevNodePos.x + ratio * (curNodePos.x - prevNodePos.x) + transform.globalPosition().x;
                double y = prevNodePos.y + ratio * (curNodePos.y - prevNodePos.y) + transform.globalPosition().y;
                return new Vector2((float) x, (float) y);
            }

            totalDistance += segmentDistance;
            prevNode = curNode;
        }

        // The distance is beyond the end of the path
        return new Vector2(nodes[(nodes.length - 1)].position.x, nodes[(nodes.length - 1)].position.y).add(transform.globalPosition());
    }

    private float calculatePathTotalDistance() {
        float totalDistance = 0f;

        for (int i = 0; i < nodes.length; i++) {
            Node currentNode = nodes[i];
            Node nextNode;

            if(i+1 < nodes.length)
                nextNode = nodes[i+1];
            else
                return totalDistance;

            totalDistance += currentNode.distanceToOtherNode(nextNode);
        }

        return -1f;
    }

    @Override
    public void start() {

    }

    @Override
    public void fixedUpdate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Renderer renderer) {
        if (true) // Debug draw nodes
            return;

        renderer.setLineWidth(5);
        for (Node node: nodes) {
            renderer.drawCircle(transform, node.position, 5);
        }
        renderer.setLineWidth(1);
    }
}
