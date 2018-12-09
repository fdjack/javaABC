package com.cn.zy.nio.com.cn.zy.channel.ex.list;

import lombok.Data;

/**
 * 简单单链表实现
 *
 * @author: zhangyi
 * @date: 2018/11/30 09:58
 * @description:
 */
public class ListUtils<E> {

    @Data
    private class Node{
        private E data;
        private Node next;

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
     * 节点添加
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
     * 遍历节点
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
     * 插入节点
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
            System.out.println("位置非法");
        }
    }

    /**
     * 移除节点
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
     * 移除指定节点
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
