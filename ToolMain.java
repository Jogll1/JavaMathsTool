public class ToolMain {
    public static void main(String[] args) {
        double[] equation1 = {-1, 1};
        double[] equation2 = {-1, 0, 3};
        ShortestDist shortestDist = new ShortestDist(equation1, equation2);

        // shortestDist.printCalcLineDist();
        shortestDist.printCalcLineCurveDist();
    }
}