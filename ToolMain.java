public class ToolMain {
    public static void main(String[] args) {
        float[] equation1 = {1, 3};
        float[] equation2 = {1, 4};
        ShortestDist shortestDist = new ShortestDist(equation1, equation2);

        shortestDist.printCalcLineDist();
    }
}