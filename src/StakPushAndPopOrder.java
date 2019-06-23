import java.util.Stack;

/**
 * 栈的压入和弹出顺序
 */
public class StakPushAndPopOrder {

    public boolean pushAndPopOrder(int[] data1,int[] data2){
        Stack<Integer> stack=new Stack<>();
        boolean result=false;

        //添加数据到栈中
        for (int item:data1
        ) {
            stack.push(item);
        }
        if (data1.length==data2.length){
            while (!stack.isEmpty()){

                for (int i=0;i<data2.length;i++){
                    if (stack.pop()==data2[i]){
                        result=true;
                    }else {
                        result=false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
