/**
 * 输入数字n ,按顺序打印从1到n位最大十进制的数值
 */
public class Print1ToN {

    public static void main(String[] args){

    }

    public static void print1ToN(int n){
        if (n<1)
        {throw new RuntimeException("输入数字不合法");}
        //设定一个数组用于存储数据
        int[] arr=new int[n];
        print1ToN(0,arr);
    }

    /**
     * 输入数字n，按打印顺序打印出从1最大的n为十进制数
     * @param n
     * @param arr
     */
    public static void print1ToN(int n,int[] arr){
      if (n>=arr.length){
          printArray(arr);
      }else {
          for (int i=0;i<=9;i++){
              arr[n]=i;
              print1ToN(n+1,arr);
          }
      }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素
     * @param arr
     */
    public static void printArray(int[] arr){

        int index=0;
        while (index<=arr.length && arr[index]!=0){
            index++;
        }

        //从第一个非0值开始输出
        for (int i=index;i<=arr.length;i++){
            System.out.print(arr[index]);
        }
        //条件成立说明数组中有非零元素，所以需要换行
        if (index<arr.length)
            System.out.println();

    }
}
