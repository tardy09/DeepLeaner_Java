package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Server implements Runnable{
    //多路复用器管理所有的通道
	private Selector selector;
	//建立缓冲区
	private ByteBuffer readBuffer=ByteBuffer.allocate(1024);
	private ByteBuffer writeBuffer=ByteBuffer.allocate(1024);
	
	public Server(int port) {
		try {
			//打开多路复用器
			this.selector=Selector.open();
			//打开服务器通道
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			//设置服务器通道为false
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(port));
			//把服务器通道注册到多路复用器上，并且监听阻塞事件
			serverSocketChannel.register(this.selector,SelectionKey.OP_ACCEPT);
		   System.out.println("Server start, port :"+port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				//让多路复用器开始监听
				this.selector.select();
				//返回多路复用器已经选择的结果集合
				Iterator<SelectionKey> keys=this.selector.selectedKeys().iterator();
			    //进行遍历
				while(keys.hasNext()){
					//获取一个一个选择的元素
					SelectionKey key=keys.next();
					//直接进行移除
					keys.remove();
					//如果key是有效的
					if(key.isValid()){
						//如果key是阻塞状态
						if(key.isAcceptable()){
							this.accept(key);
						}
						if(key.isReadable()){
							this.read(key);
						}
						if(key.isWritable()){
							
						}
						//写类似
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void read(SelectionKey key) {
		// TODO Auto-generated method stub
		
	}
   /**
    * 通过key就可以获取客户端的socketChanel,进而获取通道上的缓冲（冲刷出来的数据），进而就可以获取数据
    * 进行读写操作
    * 
    * @param key
    */
	private void accept(SelectionKey key) {
		// TODO Auto-generated method stub
		
	}

}
