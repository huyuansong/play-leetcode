import java.util.Arrays;

public class MyVector<Item> {

    private Item[] data;
    private int size;       // 存储数组中的元素个数  size索引没有元素 ，size-1 是最后一个元素
    private int capacity;   // 存储数组中可以容纳的最大的元素个数

    public MyVector(){
        data = (Item[])new Object[100];
        size = 0;
        capacity = 100;
    }

    // 平均复杂度为 O(1)
    public void push_back(Item e){

        if(size == capacity)
            resize(2 * capacity);

        data[size++] = e;
    }

    // 平均复杂度为 O(1)
    public Item pop_back(){

        if(size <= 0)
            throw new IllegalArgumentException("can not pop back for empty vector.");

        size --;  // 元素并没有被删除，只是size位置的元素被认为是没有意义的数据了，外界也无法访问
        return data[size]; 
    }

    // 复杂度为 O(n)
    private void resize(int newCapacity){

        assert newCapacity >= size;
        Item[] newData = (Item[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];

        data = newData;  // 指向新数组内存
        capacity = newCapacity;
    }

    // 注意：Java语言由于JVM内部机制的因素，测量的性能时间有可能是跳跃不稳定的。
    public static void main(String[] args) {

        for( int i = 10 ; i <= 26 ; i ++ ){

            int n = (int)Math.pow(2,i);

            long startTime = System.nanoTime();
            MyVector<Integer> vec = new MyVector<Integer>();
            for(int num = 0 ; num < n ; num ++){
                vec.push_back(num);
            }
            long endTime = System.nanoTime();

            System.out.print(n + " operations: \t");
            System.out.println((endTime - startTime) + " 微妙");
        }
    }
}
