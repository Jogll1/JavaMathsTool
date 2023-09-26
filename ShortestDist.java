import java.text.DecimalFormat;
import java.util.Arrays;

//class to work out the shortest distance between two lines, a line and a curve or two quadratics
public class ShortestDist {
    //calculate the shortest distance between binomials
    //format: y=(ce1)x(^pow)+(ce2)x(^pow-1)+...+(cen-1)x+(cen)
    //each coefficient is a value in an array
    //float[] y = {3, 5 , 0, 3}; = y= 3x^3 + 5x^2 + 3
    float[] equation1;
    float[] equation2;

    public ShortestDist(float[] _equation1, float[] _equation2) {
        this.equation1 = _equation1;
        this.equation2 = _equation2;
    }

    //function to format flaot arrays into readable equations
    private String formatEquation(float[] _equation) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int eqLen = _equation.length;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < eqLen; i++) {
            if(_equation[i] != 0) {
                //append plus
                if (i > 0) {
                    builder.append(" + ");
                }

                //append coefficient
                if (_equation[i] != 1) {
                    builder.append(decimalFormat.format(_equation[i]));
                }

                //append x and power
                if (i < eqLen - 1) {
                    builder.append('x');
                    if (eqLen - 1 - i != 1) builder.append('^').append(eqLen - 1 - i);
                }
            }
        }

        String output = builder.toString();
        return output;
    }

    public void printBothEquations() {
        System.out.println("y = " + formatEquation(equation1));
        System.out.println("y = " + formatEquation(equation2));
    }

    //function to get the distance between two lines
    private double calcLineDist(float[] _line1, float[] _line2) {
        //make sure both arrays are only of length 2
        float[] line1 = Arrays.copyOfRange(_line1, 0, 2);
        float[] line2 = Arrays.copyOfRange(_line2, 0, 2);

        //calculate the shortest distance between 2 lines
        if(line1[0] == line2[0]) {
            final float grad = line1[0];
            double dist = (Math.abs(line2[1] - line1[1])) / (Math.sqrt(1 + Math.pow(grad, 2)));
            return dist;
        }

        return 0;
    }

    public void printCalcLineDist() {
        System.out.println("The distance between " + formatEquation(equation1) + " and "
        + formatEquation(equation2) + " is " + calcLineDist(equation1, equation2));
    }

    //function to calculate distance between a line and a curve
    public double calcLineCurveDist(float[] _line, float[] _curve) {
        //curve has to be a quadratic so far
        float[] line = Arrays.copyOfRange(_line, 0, 2);
        float[] curve = Arrays.copyOfRange(_curve, 0, 3);

        float[] line1 = line;
        // double[] line2 = {line[0], -(Math.pow(curve[1] - line[0], 2) / (4 * curve[0]) - curve[2])};

        // double dist = calcLineDist(line1, line2);
        return 0;
    }
}