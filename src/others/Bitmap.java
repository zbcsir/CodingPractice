package others;

// 位图实现
public class Bitmap {
    private int nBits;
    private char[] bits;

    public Bitmap(int nBits) {
        this.nBits = nBits;
        this.bits = new char[nBits / 16 + 1];
    }

    // 根据待添加的整数元素更新位图
    public void addElem(int e) {
        if (e > nBits) return;
        int byteIdx = e / 16; //Java中char占两个byte，也就是16bit
        int bitIdx = e % 16;
        bits[byteIdx] |= 1 << bitIdx;
    }

    // 基于位图判断一个数是否存在
    public boolean found(int e) {
        if (e > nBits) return false;
        int byteIdx = e / 16;
        int bitIdx = e % 16;
        return (bits[byteIdx] & (1 << bitIdx)) != 0;
    }
}
