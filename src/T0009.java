public class T0009 {
    public static void main(String[] args) {

        int x=-121;
        System.out.println(T0009.isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        x=Math.abs(x);
        int start=x;
        int end=0;
        while(x>0){

            end=end*10+x%10;
            x=x/10;
        }
        if(start==end){
            return true;
        }else

        return false;
    }

}
