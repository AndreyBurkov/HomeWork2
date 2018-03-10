package Task1;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (real == 0.0 && imag == 0.0) return "0";
        if (real == 0.0) return imag + "i";
        if (imag == 0.0) return real + "";
        return real + (imag < 0 ? "-" : "+") + Math.abs(imag) + "i";
    }

    public boolean isReal() {
        return real != 0;
    }

    public boolean isImaginary() {
        return imag != 0;
    }

    public boolean equals(MyComplex another) {
        return real == another.getReal() && imag == another.getImag();
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2.0) + Math.pow(imag, 2.0));
    }

    public double argument() {
        if (real == 0.0 && imag == 0.0)  {
            System.out.println("Не определено для 0+0i");
            return 0.0;
        }
        return Math.acos(real / magnitude());
    }

    public MyComplex add(MyComplex right) {
        real += right.getReal();
        imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.getReal(), imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        real -= right.getReal();
        imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(real - right.getReal(), imag - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        double re = real*right.getReal() - imag*right.getImag();
        double im = imag*right.getReal() + real*right.getImag();
        setValue(re, im);
        return this;
    }

    public MyComplex divide(MyComplex right) {
        if (right.equals(0.0, 0.0)) {
            System.out.println("Деление на 0+i0 невозможно");
            return this;
        }
        double re = (real*right.getReal() + imag*right.getImag()) / (Math.pow(right.getReal(), 2.0) + Math.pow(right.getImag(), 2.0));
        double im = (imag*right.getReal() - real*right.getImag()) / (Math.pow(right.getReal(), 2.0) + Math.pow(right.getImag(), 2.0));
        setValue(re, im);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }
}
