import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    /* 1  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
    判断数组中是否含有该整数。*/
    public boolean Find(int target, int [][] array) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    /* 2  请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
    则经过替换之后的字符串为We%20Are%20Happy。*/
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();     //如果不创建新的对象保存结果就会打乱原对象的长度
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                newStr.append("%20");
            }else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }


    /* 3  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


    /* 3  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,}2,4,7,3,5,6,8
    和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        return null;
    }


    /*   求旋转数组的最小数字*/
    public int minNumberInRotateArray(int [] array){
        if (array == null || array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (array[left] >= array[right]){
            if (right - left <= 1){
                mid = right;
                break;
            }
            mid = (left + right)/ 2;
            if (array[left] == array[mid] && array[mid] ==array[right]){
                if (array[left + 1] != array[right - 1]){
                    mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
                }else {
                    left++;
                    right--;
                }
            }else {
                if (array[left] <= array[mid]){
                    left = mid;
                }else {
                    right = mid;
                }
            }
        }
        return array[mid];
    }


    /*输出斐波那契数列的第n项*/
    public long fibonacci(int n){
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if (n == 0){
            return preTwo;
        }
        if (n == 1){
            return preOne;
        }
        for (int i = 2; i <= n; i++){
            result  = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }


    /*输入一个整数，输出该数二进制表示中1的个数，其中补码用负数表示*/
    public int Numberof1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n -1) & n;
        }
        return count;
    }


    /*给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不能使用函数库，不用考虑大数问题。*/
    public double Power(double base, int exponent){
        double res = 0;
        if (equal(base, 0)){
            return 0;
        }
        if (exponent == 0){
            return 1.0;
        }
        if (exponent > 0){
            res = mutiply(base, exponent);
        }else {
            res = mutiply(1/base, -exponent);
        }
        return res;
    }
    public double mutiply(double base, int e){
        double sum = 1;
        for (int i = 0; i < e; i++){
            sum = sum * base;
        }
        return sum;
    }
    public boolean equal(double a, double b){
        if (a - b < 0.000001 && a - b  > -0.000001){
            return true;
        }
        return false;
    }



    /*输入数字n，按顺序打印从1到最大的n位数十进制数，比如：输入3，打印出1到999*/
    /*考虑大数问题，使用字符串或者数组实现*/
    public void printToMaxOfNDigits(int n){
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }
    private void printArray(int[] array, int n){
        for (int i = 0; i < 10; i++){
            if (n != array.length){
                array[n] = i;
                printArray(array, n+1);
            }else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++){
                    if (array[j] != 0){
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    }else {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}
