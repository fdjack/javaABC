package algorithm;

import org.junit.Test;

import java.util.BitSet;

/**
 *
 *
 * @author: zhangyi
 * @date: 2018/12/7 09:55
 * @description:
 */
public class BitMapDemo {

    @Test
    public void bitMap(){
        BitSet bitSet1 = new BitSet();
        bitSet1.set(1);
        bitSet1.set(2);
        bitSet1.set(3);
        BitSet bitSet2 = new BitSet();
        bitSet2.set(4);
        bitSet2.set(1);
        bitSet2.set(6);
        bitSet1.xor(bitSet2);
        System.out.println(bitSet1.toString());
        bitSet1.clear(2);
        System.out.println(bitSet1.get(2));
    }

    @Test
    public void bit() {
        for(int i = 0; i < 200; i++) {
            System.out.println(i+">> 6 = "+(i >> 7));
            System.out.println(i + "<< 2 = "+(i<<2));
        }
    }


    @Test
    public void buffer(){
        int i = 64>>6;
        System.out.println(i);
    }
}
