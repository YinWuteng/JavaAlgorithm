/**
 * 删除链表中的倒数第k的节点
 * 常规解法遍历，
 * 较优解法，用来个值来控制间距
 * 倒数第k个，则顺数第k-1个
 */
public class DeleteKLinkNode {

  public static LinkNode deleteKLinkNode(LinkNode parent,int k){
      //校验条件合法性
      if (parent==null || k<1)return null;

      //倒数第k个节点,从头开启两个值，相隔k-1的间距
      //判断链表长度是否符合
      int start=0;
      int end;
      LinkNode startNode=parent;
      LinkNode endNode=parent;
      for (end=0;end<k-1;end++){
        if (endNode.next==null){
            throw new RuntimeException("k值太大");
        }else {
            endNode=endNode.next;
        }
      }
      //如果长度合格,end的指针走到空时，则start在倒数第k个位置
      while (!(endNode.next==null)){
          startNode=startNode.next;
          endNode=endNode.next;
      }
      return startNode;
  }
}
