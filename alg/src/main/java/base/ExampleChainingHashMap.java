package base;

import java.util.LinkedList;

public class ExampleChainingHashMap {
    static class KVNode {
        int key;
        int value;

        public KVNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KVNode>[] table;//底层存储为链表-数组

    public ExampleChainingHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public int get(int key) {
        int index = hash(key);
        if (table[index] == null) {
            return -1;
        }
        LinkedList<KVNode> list = table[index];
        if (list == null) {
            return -1;
        }
        for (KVNode node : list) {
            if (key == node.key) {
                return node.value;
            }
        }
        return -1;
    }

    /**
     * 存放逻辑。（不考虑扩容）
     * 1.key对应的index，获取list
     * 2.如果list为空，新建
     * 3.list不空，遍历，如果有key，替换，否则加入
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {//不存在对应的链表
            LinkedList<KVNode> list = new LinkedList<>();
            list.addLast(new KVNode(key, value));
            table[index] = list;
        } else {
            LinkedList<KVNode> list = table[index];
            for (KVNode node : list) {//循环list，找到对应的key，就替换
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
            list.addLast(new KVNode(key, value));//未找到，就新增。
        }
    }

    /**
     * 删除逻辑
     * 1.key对应的index，获取list。空返回
     * 2.存在获取list，遍历
     *
     * @param key
     */
    public void delete(int key) {
        LinkedList<KVNode> list = table[hash(key)];
        if (list == null) {
            return;
        }
        // 如果 key 存在，则删除
        // 这个 removeIf 方法是 Java LinkedList 的方法，可以删除满足条件的元素，时间复杂度 O(N)
        list.removeIf(node -> node.key == key);

    }
}
