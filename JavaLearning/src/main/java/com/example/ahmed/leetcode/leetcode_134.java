package com.example.ahmed.leetcode;

public class leetcode_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int start=i;
            int pos=start;
            int restGas=gas[pos]-cost[pos];
            while(restGas>=0){
                if(pos==start-1 || (start==0 && pos==gas.length-1)){
                    return start;
                }
                pos=(pos<gas.length-1)?pos+1:0;
                restGas=restGas+gas[pos]-cost[pos];
            }
        }

        return -1;
    }

    public  static int solution(int[] gas, int[] cost){

        int n = gas.length;
        int i = 0;

        // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
        while(i < n){
            int sumOfGas  = 0; // 总共加的油
            int SumOfCost = 0; // 总共消费的油
            int count = 0;     // 记录能走过几个站点
            while(count < n){  // 退出循环的条件是走过所有的站点
                int j = (i + count) % n; // 加油站是环形的
                sumOfGas += gas[j];
                SumOfCost += cost[j];
                if(SumOfCost > sumOfGas){ // 如果这个站点发现油不够了
                    break;
                }
                count++; // 这个站点满足情况
            }

            if(count == n){  // 如果能环绕一圈
                return i;
            }else{ // 不行的话 从下一个站点开始 检查
                i = i + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;
    }

    public static void main(String[] args) {
        int gas[]={1,2,3,4,5};
        int cost[]={3,4,5,1,2};
        System.out.println(solution(gas, cost));

    }
}
