import java.text.DecimalFormat;
import java.util.Arrays;

//class to work out the shortest distance between two lines, a line and a curve or two quadratics
public class ShortestDist {
    //calculate the shortest distance between binomials
    //format: y=(ce1)x(^pow)+(ce2)x(^pow-1)+...+(cen-1)x+(cen)
    //each coefficient is a value in an array
    //float[] y = {3, 5 , 0, 3}; = y= 3x^3 + 5x^2 + 3
    double[] equation1;
    double[] equation2;

    public ShortestDist(double[] _equation1, double[] _equation2) {
        this.equation1 = _equation1;
        this.equation2 = _equation2;
    }

    //function to format flaot arrays into readable equations
    private String formatEquation(double[] _equation) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int eqLen = _equation.length;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < eqLen; i++) {
            if(_equation[i] != 0) {
                //append plus
                if (i > 0) {
                    builder.append(" + ");
                }
                
                //append coefficeint, x and power
                if (i < eqLen - 1) {
                    //append coefficient
                    if (Math.abs(_equation[i]) != 1) {
                        builder.append(decimalFormat.format(_equation[i]));
                    }

                    if (_equation[i] == -1) {
                        builder.append('-');
                    }

                    //append x and power
                    builder.append('x');
                    if (eqLen - 1 - i != 1) builder.append('^').append(eqLen - 1 - i);
                }
                else {
                    builder.append(decimalFormat.format(_equation[i]));
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
    private double calcLineDist(double[] _line1, double[] _line2) {
        //make sure both arrays are only of length 2
        double[] line1 = Arrays.copyOfRange(_line1, 0, 2);
        double[] line2 = Arrays.copyOfRange(_line2, 0, 2);

        System.out.println(formatEquation(line1));
        System.out.println(formatEquation(line2));

        //calculate the shortest distance between 2 lines
        if(line1[0] == line2[0]) {
            final double grad = line1[0];
            double dist = (Math.abs(line2[1] - line1[1])) / (Math.sqrt(1 + Math.pow(grad, 2)));
            return dist;
        }

        return 0;
    }

    public void printCalcLineDist() {
        System.out.println("The shortest distance between " + formatEquation(equation1) + " and "
        + formatEquation(equation2) + " is " + calcLineDist(equation1, equation2));
    }

    //function to calculate distance between a line and a curve
    private double calcLineCurveDist(double[] _line, double[] _curve) {
        //curve has to be a quadratic so far
        double[] line = Arrays.copyOfRange(_line, 0, 2);
        double[] curve = Arrays.copyOfRange(_curve, 0, 3);

        double a = line[0];
        double b = line[1];
        double c = curve[0];
        double d = curve[1];
        double e = curve[2];

        //get second line constant
        final double beta = -(((Math.pow(d - a, 2)) / (4 * c)) - e);

        //check if equation has solutions
        final double det = Math.pow(d- a, 2) - 4 * c * (e - b);

        if(det <= 0) {
            //if not, solve using formula
            double[] line1 = line;
            double[] line2 = {line[0], beta};

            double dist = calcLineDist(line1, line2);
            return dist;
        }

        return 0;
    }

    public void printCalcLineCurveDist() {
        System.out.println("The shortest distance between " + formatEquation(equation1) + " and "
        + formatEquation(equation2) + " is " + calcLineCurveDist(equation1, equation2));
    }
}