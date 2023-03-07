
import java.rmi.Naming;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
    try{
        ITinhToan tt= (ITinhToan)Naming.lookup("rmi://172.16.0.176/TinhToan");
        Scanner s = new Scanner(System.in);
        int kt;
        while (true) {            
            System.out.print("nhap a:");
            int a = Integer.parseInt(s.nextLine());
            System.out.print("nhap b:");
            int b = Integer.parseInt(s.nextLine());
            System.out.print("nhap phep tinh:");
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
            System.out.print("Nhap 0 de thoat:");           
            kt = Integer.parseInt(s.nextLine());
            if(kt == 0){
                break;
	    }
        }
        
    }catch(Exception tt) 
    {
        tt.getStackTrace();
    }
  }

}
