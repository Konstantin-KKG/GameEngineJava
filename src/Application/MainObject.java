package Application;

import Application.Grass.GrassField;
import Application.Pathing.Node;
import Application.Pathing.NodePath;
import Engine.Math.Vector2;
import Engine.ObjectBase.GameObject;
import Engine.Graphics.Renderer;
import Engine.SceneManagement.Scene;


// To avoid confusion this object should only exist ONCE at all times!
public class MainObject extends GameObject {
    public Scene defaultScene;

    Node[] nodes = new Node[] {
            new Node(new Vector2(600, -80)),
            new Node(new Vector2(-600, -80)),
            new Node(new Vector2(-760, -150f)),
            new Node(new Vector2(-430f, -225f)),
            new Node(new Vector2(-390f, -230f)),
            new Node(new Vector2(390f, -230f)),
            new Node(new Vector2(430f, -225f)),
            new Node(new Vector2(760, -150f)),
            new Node(new Vector2(600, -80))};
    NodePath nodePath = new NodePath(nodes);

    GrassField grassField = new GrassField(new Vector2(2467.5f, 252), 3322, 1000);
    Dampflok lok = new Dampflok(nodePath, 0.63f, 430, 580, 0.6f, 2f);

    @Override
    public void start() {
        instantiate(grassField, null, new Vector2(1280/2, 660));
        instantiate(nodePath, grassField, Vector2.zero());
        instantiate(lok, null, new Vector2(1280/2, 540));
    }

    @Override
    public void fixedUpdate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Renderer renderer) {

    }
}
