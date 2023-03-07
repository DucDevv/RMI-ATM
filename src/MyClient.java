
import java.rmi.Naming;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
    try{
        ITinhToan tt= (ITinhToan)Naming.lookup("rmi://localhost/TinhToan");
        Scanner s = new Scanner(System.in);
        int kt;
        while (true) {            
            System.out.println("nhap a:");
            int a = Integer.parseInt(s.nextLine());
            System.out.println("nhap b:");
            int b = Integer.parseInt(s.nextLine());
            System.out.println("nhap phep tinh:");
            String pt = s.nextLine();
            if(pt.equals("+")){
                System.out.println("KQ:"+tt.Cong(a,b) );
            }
            if(pt.equals("-")){
                System.out.println("KQ:"+tt.Tru(a,b) );
            }
            if(pt.equals("*")){
                System.out.println("KQ:"+tt.Nhan(a,b) );
            }
            if(pt.equals("/")){
                System.out.println("KQ:"+tt.Chia(a,b) );
            }
            System.out.println("Nhập 0 để thoát:");           
            kt = Integer.parseInt(s.nextLine());
            if(kt == 0)
                break;
        }
        
    }catch(Exception tt) 
    {
        tt.getStackTrace();
    }
  }

}
