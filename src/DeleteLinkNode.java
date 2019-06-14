/**
 * O(1)时间内删除链表节点
 * 需要该节点是否为最后一个节点？
 */
public class DeleteLinkNode {


    public LinkNode deleteLinkNode(LinkNode parent, LinkNode target) {

        // 检验输入合法性

        if (parent == null || target == null) return null;
        //当删除节点为头节点时
        if (parent == target) {
            return parent.next;
        }
        //当删除节点为尾节点时
        if (target.next == null) {
            //找出待删除元素的前驱
            LinkNode tmp = parent;
            while (tmp.next != target) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            //删除的为中间节点
            //将右下一个节点的值，赋值给当前值
            target.value = target.next.value;
            target.next = target.next.next;
        }
        return parent;
    }
}
