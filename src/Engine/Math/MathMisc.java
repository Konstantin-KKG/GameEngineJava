package Engine.Math;

public final class MathMisc {
    public static float mapRange(float oldValue, float oldMin, float oldMax, float newMin, float newMax) {
        float oldRange = oldMax - oldMin;
        float newRange = newMax - newMin;

        return ((oldValue - oldMin) * newRange / oldRange) + newMin;
    }
}
