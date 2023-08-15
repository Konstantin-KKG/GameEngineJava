package Application.Grass;

import Engine.Graphics.Renderer;
import Engine.Math.MathMisc;
import Engine.Math.Vector2;
import Engine.ObjectBase.GameObject;

import java.util.Random;

public class GrassField extends GameObject {
    Vector2 depthSize;
    int grassBushCount;

    // Trapeze vertices
    Vector2 vertA; // left down
    Vector2 vertB; // right down
    Vector2 vertC; // left up
    Vector2 vertD; // right up

    public GrassField(Vector2 _depthSize, float frontWidth, int _grassBushCount) {
        depthSize = _depthSize;
        grassBushCount = _grassBushCount;

        vertA = new Vector2(-(frontWidth / 2), 0);
        vertB = new Vector2((frontWidth / 2), 0);
        vertC = new Vector2(vertA.x + (depthSize.x / 2), vertA.y - depthSize.y);
        vertD = new Vector2(vertB.x - (depthSize.x / 2), vertB.y - depthSize.y);
    }

    @Override
    public void start() {
        createGrassBushesInTriangle(vertA, vertB, vertC, grassBushCount/2);
        createGrassBushesInTriangle(vertB, vertC, vertD, grassBushCount/2);
    }

    private void createGrassBushesInTriangle(Vector2 pos1, Vector2 pos2, Vector2 pos3, int bushCount) {
        for (int i = 0; i < bushCount; i++) {
            Grass grass = new Grass();
            Vector2 pos = getRandomPointInTriangle(pos1, pos2, pos3);

            instantiate(grass, this, pos);

            float sizeBaseOnDepth = MathMisc.mapRange(-grass.transform.localPosition.y, 0, depthSize.y, 4f, 0.6f);
            grass.transform.localSize = new Vector2(sizeBaseOnDepth, sizeBaseOnDepth);
        }
    }

    private Vector2 getRandomPointInTriangle(Vector2 pos1, Vector2 pos2, Vector2 pos3) {
        // Create a new Random object to generate random numbers
        Random rand = new Random();

        // Generate two random numbers between 0 and 1
        double r1 = rand.nextDouble();
        double r2 = rand.nextDouble();

        // Use the barycentric coordinate system to get a point within the triangle
        double x = (1 - Math.sqrt(r1)) * pos1.x + (Math.sqrt(r1) * (1 - r2)) * pos2.x + (Math.sqrt(r1) * r2) * pos3.x;
        double y = (1 - Math.sqrt(r1)) * pos1.y + (Math.sqrt(r1) * (1 - r2)) * pos2.y + (Math.sqrt(r1) * r2) * pos3.y;

        // Return the point as an array
        return new Vector2((float) x, (float) y);
    }

    @Override
    public void fixedUpdate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Renderer renderer) {
        renderer.drawLine(transform, vertA, vertB);
        renderer.drawLine(transform, vertA, vertC);
        renderer.drawLine(transform, vertD, vertC);
        renderer.drawLine(transform, vertD, vertB);
    }
}
