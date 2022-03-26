import java.util.HashMap;
import java.util.Map;

public class T0013 {
    public static void main(String[] args) {
        String str="MCMXCIV";
        System.out.println(new T0013().romanToInt(str));

    }
    /*
    通过构造switch语句实现
     */
    public int romanToInt(String s) {
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'I':
                    sum++;
                    if(i+1<s.length() && (s.charAt(i+1)=='X'||s.charAt(i+1)=='V' ))
                        sum=sum-2;
                    break;
                case'V':
                    sum+=5;
                    break;
                case'X':
                    sum+=10;
                    if(i+1<s.length() && (s.charAt(i+1)=='L'||s.charAt(i+1)=='C' ))
                        sum-=20;
                    break;
                case 'L':
                    sum+=50;
                    break;
                case'C':
                    sum+=100;
                    if(i+1<s.length() && (s.charAt(i+1)=='D'||s.charAt(i+1)=='M' ))
                        sum-=200;
                    break;
                case'D':
                    sum+=500;
                    break;
                case'M':
                    sum+=1000;
                    break;

            }
        }
        return sum;
    }
}
