package com.cn.zy.nio.com.cn.zy.channel.ex.list;

/**
 * @author: zhangyi
 * @date: 2018/11/30 09:58
 * @description:
 */
public class ListUtils<E> {
    private class Node{
        private E data;
        private Node next;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node() {
        }
    }


    private int lenght;

    private Node head;

    private Node tail;

    private Node point;

    public ListUtils() {
        head  = new Node();
        tail = head;
        lenght = 0;
    }

    /**
     * 从尾部插入数据
     *
     * @param node
     */
    public void add(E node){
        point = new Node(node);
        tail.next = point;
        tail = point;
        lenght++;
    }

    /**
     * 遍历链表
     */
    public void traverse(){
        point = head;
            while(point.next != null){
                System.out.print(point.next.data+"-->");
                point = point.next;
            }
        System.out.println("");
    }

    /**
     * 插入数据
     *
     * @param position
     * @param data
     */
    public void insert(int position,E data){
        if(position > 0 && position < lenght){
            point = move(position);
            Node tempData = new Node(data);
            tempData.next = point.next;
            point.next = tempData;
            lenght++;
        }else{
            System.out.println("无效位置");
        }
    }

    /**
     * 删除某一个节点的元素
     *
     * @param position
     * @return
     */
    public boolean remove(int position){
        if(position < 0){
            return false;
        }else if(position > lenght){
            return false;
        }
        point = move(position);
        Node temp = point.next;
        point.next = temp.next;
        lenght--;
        return true;
    }

    /**
     * 移动位置
     *
     * @param position
     * @return
     */
    public Node move(int position){
        if(position < 0){
            return head;
        }
        if(position >lenght){
            return tail;
        }
        if(position >= 0 && position <= lenght){
            point = head;
            while(point != null) {
                if (position == 0) {
                    break;
                }
                position--;
                point = point.next;
            }
        }
        return point;
    }
    public int getLenght() {
        return lenght;
    }
}
