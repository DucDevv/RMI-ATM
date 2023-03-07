
public class ToHop implements IToHop{

    public long tinhGiaithua(int n){
        long ketqua=1;
        int i;
        for(i = 2; i <= n; i++) {
            ketqua *= i;
        }
        return ketqua;
    }
    @Override
    public long tinhToHop(int k, int n) throws Exception {
        return tinhGiaithua(n)/(tinhGiaithua(k)*tinhGiaithua(n-k));
    }
    
}
