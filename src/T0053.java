public class T0053 {
    /*
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    子数组 是数组中的一个连续部分。
     */
    public static void main(String[] args) {
        T0053 h = new T0053();

        System.out.println(h.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /*
    主体思想是利用一种滚动数组的思想，依次求出以nums[i]结尾的最大子数组和
    在以前遇到这个算法的时候，常常困惑的一点是在以怎么保证以不同nums[i]结尾的连续性
    后来发现，该算法的基本思想就是以包含结尾数组的最大子数组和来递进
    不用考虑该算法的数组连续问题

     */
    public int maxSubArray(int[] nums) {


        //temp表示以nums[i]结尾的连续子数组的最大和

        int temp = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            max = Math.max(max, temp);
        }

        return max;


    }
}
