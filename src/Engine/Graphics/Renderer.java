package Engine.Graphics;

import Engine.Math.Vector2;
import Engine.ObjectBase.Transform;
import sum.kern.*;

import java.awt.*;

// This object is supposed to only exist ONCE
public class Renderer {
    private Vector2 viewportDimensions = new Vector2(1280, 720);
    public Vector2 viewportPosition = Vector2.zero();

    private Buntstift pen;
    private Bildschirm viewport;

    public Renderer() {
        viewport = new Bildschirm((int)viewportDimensions.x, (int)viewportDimensions.y, true);
        pen = new Buntstift();
    }

    public void clearViewport() {
        pen.setzeFarbe(Color.WHITE);
        pen.setzeLinienbreite(10000);

        pen.bewegeBis(0, viewportDimensions.y / 2);
        pen.runter();
        pen.bewegeBis(viewportDimensions.x, viewportDimensions.y / 2);
        pen.hoch();

        pen.setzeFarbe(Color.BLACK);
        pen.setzeLinienbreite(1);
    }

    public void swapFrameBuffer() {
        viewport.zeichneDich();
    }

    public void setLineWidth(int width) {
        pen.setzeLinienbreite(width);
    }
    public void setColorWidth(Color color) {
        pen.setzeFarbe(color);
    }

    public void drawLine(Transform trans, Vector2 startPos, Vector2 endPos) {
        drawLine(trans, startPos.x, startPos.y, endPos.x, endPos.y);
    }
    public void drawLine(Transform trans, float x, float y, float x2, float y2) {
        Vector2 globalPos = trans.globalPosition();
        Vector2 size = trans.localSize;

        pen.hoch();
        pen.bewegeBis((-viewportPosition.x) + globalPos.x + (x * size.x), (-viewportPosition.y) + globalPos.y + (y * size.y));
        pen.runter();
        pen.bewegeBis((-viewportPosition.x) + globalPos.x + (x2 * size.x), (-viewportPosition.y) + globalPos.y + (y2 * size.y));
        pen.hoch();
    }

    public void drawCircle(Transform trans, Vector2 pos, float radius) {
        drawCircle(trans, pos.x, pos.y, radius);
    }
    public void drawCircle(Transform trans, float x, float y, float radius) {
        Vector2 globalPos = trans.globalPosition();
        Vector2 size = trans.localSize;

        pen.hoch();
        pen.bewegeBis((-viewportPosition.x) + globalPos.x + (x * size.x), (-viewportPosition.y) + globalPos.y + (y * size.y));
        float averageSize = (Math.abs(size.x) + Math.abs(size.y)) / 2;
        pen.zeichneKreis(radius * averageSize);
        pen.runter();
    }
}
