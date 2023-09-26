public class ToolMain {
    public static void main(String[] args) {
        float[] equation1 = {2, 3, 5};
        float[] equation2 = {1, 3};
        ShortestDist shortestDist = new ShortestDist(equation1, equation2);

        shortestDist.printBothEquations();
    }
}