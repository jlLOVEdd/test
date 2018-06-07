package test.nioTest;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.RandomAccess;




public class NioChanel {

	public NioChanel() {
	}
	public static void main(String[] args) {
		try {
			String RowData = "this is a currenttime:"+System.currentTimeMillis();
			ByteBuffer buf = ByteBuffer.allocate(1000);
				buf.clear();
		
				buf.put(RowData.getBytes());
			
				buf.flip();
			
			
				while(buf.hasRemaining()){
					 System.out.print((char)buf.get());
				}
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
