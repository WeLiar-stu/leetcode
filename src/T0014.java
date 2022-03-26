public class T0014 {
    public static void main(String[] args) {

        String[] strs=new String[]{"ab","a"};
        T0014 m=new T0014();
        System.out.println(m.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {

        for (int i = 0; i < strs[0].length(); i++) {
            char c=strs[0].charAt(i);
            for (int j= 0; j < strs.length; j++) {
                if(i>=strs[j].length() ||strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
