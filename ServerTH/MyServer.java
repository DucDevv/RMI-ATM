
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;


public class MyServer {
    public static void main(String[] args) {
    try{
        ToHop th = new ToHop();
        //TinhToan tt= new TinhToan();
        //Quang ba doi tuong tt de may khach co the goi phuong thuc trong tt
        UnicastRemoteObject.exportObject(th);
        //Dang ky 1 dia chi de may khach truy cap vao doi tuong tt
       // Naming.bind("rmi://localhost/TinhToan",tt);
       Naming.bind("rmi://localhost/ToHop",th);
        System.out.print("Da cho may khach goi den:");
    }catch(Exception tt)   { 
        tt.printStackTrace();    
    }
  }

}
