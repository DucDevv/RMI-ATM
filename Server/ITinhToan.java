
import java.rmi.Remote;


public interface ITinhToan extends Remote{
    public int Cong(int a, int b) throws Exception;
    public int Tru(int a, int b) throws Exception;
    public int Nhan(int a, int b) throws Exception;
    public double Chia(int a, int b) throws Exception;
}
