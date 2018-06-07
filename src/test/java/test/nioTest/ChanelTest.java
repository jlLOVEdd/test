package test.nioTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 18:09 2018/4/27
 */
public class ChanelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("C:/Users/js170830xlr/Desktop/1.txt", "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            int readnum = channel.read(byteBuffer);
            while (readnum != -1) {
                System.out.println("read+" + readnum);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                readnum = channel.read(byteBuffer);
            }
            randomAccessFile.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
