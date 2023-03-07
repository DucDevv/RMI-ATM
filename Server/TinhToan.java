

public class TinhToan implements ITinhToan{

    @Override
    public int Cong(int a, int b) throws Exception {
        System.out.println("a + b =" +(a+b));
        return (a+b);
    }

    @Override
    public int Tru(int a, int b) throws Exception {
       System.out.println("a - b =" +(a-b));
       return (a-b);
    }

    @Override
    public int Nhan(int a, int b) throws Exception {
        System.out.println("a * b =" +(a*b));
        return (a*b);
    }

    @Override
    public double Chia(int a, int b) throws Exception {
        System.out.println("a / b =" +(a/b));
        return (double)a/b;
    }
    
}
