import java.text.DecimalFormat;

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
        System.out.println(formatEquation(equation1));
        System.out.println(formatEquation(equation2));
    }
}
