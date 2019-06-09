package others;

// λͼʵ��
public class Bitmap {
    private int nBits;
    private char[] bits;

    public Bitmap(int nBits) {
        this.nBits = nBits;
        this.bits = new char[nBits / 16 + 1];
    }

    // ���ݴ���ӵ�����Ԫ�ظ���λͼ
    public void addElem(int e) {
        if (e > nBits) return;
        int byteIdx = e / 16; //Java��charռ����byte��Ҳ����16bit
        int bitIdx = e % 16;
        bits[byteIdx] |= 1 << bitIdx;
    }

    // ����λͼ�ж�һ�����Ƿ����
    public boolean found(int e) {
        if (e > nBits) return false;
        int byteIdx = e / 16;
        int bitIdx = e % 16;
        return (bits[byteIdx] & (1 << bitIdx)) != 0;
    }
}
