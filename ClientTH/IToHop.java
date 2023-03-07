import java.rmi.Remote;
public interface IToHop extends  Remote{
    public long tinhToHop(int k, int n) throws Exception; 
}
