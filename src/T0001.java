import java.util.Arrays;
import java.util.HashMap;

public class T0001 {
    public static void main(String[] args) {
        T0001 t=new T0001();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(t.twoSum(nums,target)));
    }
    /*
    采用hashMap的数据结构对数据进行存储，利用target-nums[i]对hashMap进行顶点爆破，避免了对原有数据的第二次循环
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }else{
                hashMap.put(nums[i],i );
            }
        }
        return null;
    }
}
