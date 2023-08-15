package Application.Grass;

import Engine.Core.Time;
import Engine.Graphics.Renderer;
import Engine.Math.Vector2;
import Engine.ObjectBase.GameObject;

public class Grass extends GameObject {
    @Override
    public void start() {
        transform.localSize = new Vector2(2, 2);
    }

    @Override
    public void fixedUpdate() {

    }

    float grassAnimTime;
    float animTimeSin;

    @Override
    public void update() {
        grassAnimTime += Time.deltaTime() * 3;
        animTimeSin = (float) Math.sin(grassAnimTime) * 2f;
    }

    @Override
    public void render(Renderer renderer) {
        Vector2 vertA = new Vector2(3f + animTimeSin * 0.08f, -0f);
        Vector2 vertB = new Vector2(7.8f + animTimeSin, -9f);
        Vector2 vertC = new Vector2(1.8f + animTimeSin * 0.2f, -4.3f);
        Vector2 vertD = new Vector2(0f + animTimeSin * 1.3f, -16.5f);
        Vector2 vertE = new Vector2(-2f + animTimeSin * 0.2f, -4.2f);
        Vector2 vertF = new Vector2(-8f + animTimeSin, -10f);
        Vector2 vertG = new Vector2(-4f + animTimeSin * 0.08f, -0f);

        renderer.drawLine(transform, vertA, vertB);
        renderer.drawLine(transform, vertB, vertC);
        renderer.drawLine(transform, vertC, vertD);
        renderer.drawLine(transform, vertD, vertE);
        renderer.drawLine(transform, vertE, vertF);
        renderer.drawLine(transform, vertF, vertG);
    }
}
