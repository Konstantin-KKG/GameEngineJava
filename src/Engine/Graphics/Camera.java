package Engine.Graphics;

import Engine.Math.Vector2;

public final class Camera {
    private static Renderer renderer;

    public static void SetRenderer(Renderer _renderer) {
        renderer = _renderer;
    }

    public static void MoveCameraBy(Vector2 delta) {
        if (renderer == null) {
            RendererWarningMassage();
            return;
        }

        renderer.viewportPosition.add(delta);
    }

    public static void MoveCameraTo(Vector2 position) {
        if (renderer == null) {
            RendererWarningMassage();
            return;
        }

        renderer.viewportPosition = position;
    }

    public static Vector2 position() {
        if (renderer == null) {
            RendererWarningMassage();
            return Vector2.zero();
        }

        return renderer.viewportPosition;
    }

    private static void RendererWarningMassage() {
        System.out.print("[WARNING]: Camera (renderer var) empty, pls set the renderer by calling Camera.SetRenderer(renderer)");
    }
}
