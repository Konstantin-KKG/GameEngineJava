package Application;

import Application.Pathing.NodePath;
import Engine.Graphics.Renderer;
import Engine.Math.MathMisc;
import Engine.Math.Vector2;
import Engine.ObjectBase.GameObject;

public class Dampflok extends GameObject {
    NodePath pathToFollow;
    float speed;

    float maxDepthHeight;
    float minDepthHeight;
    float maxDepthSize;
    float minDepthSize;

    public Dampflok(NodePath _pathToFollow, float _speed, float _maxDepthHeight, float _minDepthHeight, float _maxDepthSize, float _minDepthSize) {
        pathToFollow = _pathToFollow;
        speed = _speed;
        maxDepthHeight = _maxDepthHeight;
        minDepthHeight = _minDepthHeight;
        maxDepthSize = _maxDepthSize;
        minDepthSize = _minDepthSize;
    }

    @Override
    public void start() {

    }

    float currentPosAlongPath = 0f;
    float xSizeManipulator = 1f;
    float currentSpeedMultiplier = 1f;
    @Override
    public void fixedUpdate() {
        transform.localPosition = pathToFollow.getPositionAtDistance(currentPosAlongPath);

        // Depth size fake
        float size = MathMisc.mapRange(transform.localPosition.y, minDepthHeight, maxDepthHeight, minDepthSize, maxDepthSize);

        // Orientation fake
        if (currentPosAlongPath > 0.45f && currentPosAlongPath < 0.475f)
            xSizeManipulator = -1f;

        if (currentPosAlongPath > 0.95f && currentPosAlongPath < 0.96f)
            xSizeManipulator = 1f;

        // Apply size
        transform.localSize = new Vector2(size * xSizeManipulator, size * 0.9f);

        // Fake slower speed in distance
        if (currentPosAlongPath > 0.55f && currentPosAlongPath < 0.62f) {
            currentSpeedMultiplier = MathMisc.mapRange(currentPosAlongPath, 0.55f, 0.62f, 1, 0.6f);
        }

        if (currentPosAlongPath > 0.85f && currentPosAlongPath < 0.92f) {
            currentSpeedMultiplier = MathMisc.mapRange(currentPosAlongPath, 0.85f, 0.92f, 0.6f, 1);
        }

        if(currentPosAlongPath > 1f)
            currentPosAlongPath = 0;
        currentPosAlongPath += (speed / 1000) * currentSpeedMultiplier;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Renderer renderer) {
        int xOffset = -120/2;
        int yOffset = -150;

        renderer.setLineWidth(2);

        renderer.drawLine(transform, xOffset,             yOffset + 164,   xOffset + 30,   yOffset + 164);
        renderer.drawLine(transform, xOffset,             yOffset + 164,   xOffset + 30,   yOffset + 134);
        renderer.drawLine(transform, xOffset + 30,     yOffset + 154,   xOffset + 115,  yOffset + 154);
        renderer.drawLine(transform, xOffset + 115,    yOffset + 154,   xOffset + 115,  yOffset + 84);
        renderer.drawLine(transform, xOffset + 115,    yOffset + 84,    xOffset + 85,   yOffset + 84);
        renderer.drawLine(transform, xOffset + 85,     yOffset + 84,    xOffset + 85,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 85,     yOffset + 114,   xOffset + 75,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 75,     yOffset + 114,   xOffset + 75,   yOffset + 104);
        renderer.drawLine(transform, xOffset + 75,     yOffset + 104,   xOffset + 65,   yOffset + 104);
        renderer.drawLine(transform, xOffset + 65,     yOffset + 104,   xOffset + 65,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 65,     yOffset + 114,   xOffset + 55,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 55,     yOffset + 114,   xOffset + 55,   yOffset + 94);
        renderer.drawLine(transform, xOffset + 55,     yOffset + 94,    xOffset + 45,   yOffset + 94);
        renderer.drawLine(transform, xOffset + 45,     yOffset + 94,    xOffset + 45,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 45,     yOffset + 114,   xOffset + 30,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 30,     yOffset + 114,   xOffset + 30,   yOffset + 164);
        renderer.drawLine(transform, xOffset + 115,    yOffset + 150,   xOffset + 120,  yOffset + 150);
        renderer.drawLine(transform, xOffset + 120,    yOffset + 147,   xOffset + 120,  yOffset + 153);
        renderer.drawLine(transform, xOffset + 110,    yOffset + 89,    xOffset + 90,   yOffset + 89);
        renderer.drawLine(transform, xOffset + 110,    yOffset + 89,    xOffset + 110,  yOffset + 114);
        renderer.drawLine(transform, xOffset + 110,    yOffset + 114,   xOffset + 90,   yOffset + 114);
        renderer.drawLine(transform, xOffset + 90,     yOffset + 114,   xOffset + 90,   yOffset + 89);

        renderer.drawCircle(transform, new Vector2(xOffset + 35, yOffset + 159), 5);
        renderer.drawCircle(transform, new Vector2(xOffset + 105, yOffset + 159), 5);
    }
}
