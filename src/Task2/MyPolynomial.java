package Task2;

public class MyPolynomial {
    private double[] coeffs;
    private void arrayTest() { // если при старших членах коэффициенты равны 0, пересоздаем массив
        int length = coeffs.length;
        for (int i = length - 1; i >= 0; i--) {
            if (coeffs[i] != 0.0) break;
            length--;
        }
        if (length == coeffs.length) return;
        double[] arr = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = coeffs[i];
        }
        coeffs = arr;
    }

    public MyPolynomial(double ... coeffs) {
        if (coeffs.length == 0) {
            this.coeffs = new double[1];
            this.coeffs[0] = 0.0;
        }
        else {
            this.coeffs = new double[coeffs.length];
            for (int i = 0; i < coeffs.length; i++) {
                this.coeffs[i] = coeffs[i];
            }
        }
        arrayTest(); // убираем нули при старших коэффициеназ при неправильной инициализации объекта
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        if (coeffs.length == 1) return ((Double)coeffs[0]).toString();
        String result = "";
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {    // если коэффициент не равен 0, то его нужно выводить
                if (coeffs[i] < 0 && i == coeffs.length - 1) // знак '-' перед старшим членом
                    result += "-";
                if (i < coeffs.length - 1) { // для всех членов кроме старшего
                    if (coeffs[i] < 0) result += " - "; // '-' перед отрицательными коэффициентами
                    else result += " + "; // '-' перед положительными коэффициентами
                }
                if (Math.abs(coeffs[i]) != 1.0) result += Math.abs(coeffs[i]);
                else if (i == 0) result += "1.0";
                if (i != 0) result += "x";
                if (i > 1) result += "^" + i;
            }
        }
        return result;
    }

    public double evaluate(double x) {
        // нет описания метода в задании
        return 0.0;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] result = new double[(getDegree() > right.getDegree() ? getDegree() : right.getDegree()) + 1];
        double term;
        for (int i = 0; i < result.length; i++) {
            term = 0.0;
            if (i <= getDegree()) term += coeffs[i];
            if (i <= right.getDegree()) term += right.coeffs[i];
            result[i] = Math.round(term * 100.0) / 100.0;   // округляем до сотых
        }
        MyPolynomial poly = new MyPolynomial(result);
        poly.arrayTest(); // пересоздаем массив, если при старших степенях получились нули
        return poly;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] result = new double[coeffs.length + right.coeffs.length - 1];
        for (int i = 0; i < coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                double temp = Math.round(coeffs[i]*right.coeffs[j] * 100.0) / 100.0; // округляем до сотых
                result[i + j] += temp;
            }
        }
        return new MyPolynomial(result);
    }
}
