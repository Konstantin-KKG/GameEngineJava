package Engine.ObjectBase;

import Engine.Math.Vector2;

public class Transform {
    public Vector2 localPosition = Vector2.zero();
    public Vector2 localSize = Vector2.one();
    public Transform parent = null;

    public Vector2 globalPosition() {
        Vector2 pos = Vector2.zero();
        findGlobalPosStep(pos);

        return pos;
    }

    private void findGlobalPosStep(Vector2 vec) {
        vec.add(localPosition);

        if (parent != null) {
            parent.findGlobalPosStep(vec);
        }
    }
}
