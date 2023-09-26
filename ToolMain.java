public class ToolMain {
    public static void main(String[] args) {
        float[] equation1 = {-1, 4};
        float[] equation2 = {-1, 0, 3};
        ShortestDist shortestDist = new ShortestDist(equation1, equation2);

        // shortestDist.printCalcLineDist();
        System.out.println(shortestDist.calcLineCurveDist(equation1, equation2));
    }
}