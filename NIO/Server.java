package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Server implements Runnable{
    //��·�������������е�ͨ��
	private Selector selector;
	//����������
	private ByteBuffer readBuffer=ByteBuffer.allocate(1024);
	private ByteBuffer writeBuffer=ByteBuffer.allocate(1024);
	
	public Server(int port) {
		try {
			//�򿪶�·������
			this.selector=Selector.open();
			//�򿪷�����ͨ��
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			//���÷�����ͨ��Ϊfalse
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(port));
			//�ѷ�����ͨ��ע�ᵽ��·�������ϣ����Ҽ��������¼�
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
				//�ö�·��������ʼ����
				this.selector.select();
				//���ض�·�������Ѿ�ѡ��Ľ������
				Iterator<SelectionKey> keys=this.selector.selectedKeys().iterator();
			    //���б���
				while(keys.hasNext()){
					//��ȡһ��һ��ѡ���Ԫ��
					SelectionKey key=keys.next();
					//ֱ�ӽ����Ƴ�
					keys.remove();
					//���key����Ч��
					if(key.isValid()){
						//���key������״̬
						if(key.isAcceptable()){
							this.accept(key);
						}
						if(key.isReadable()){
							this.read(key);
						}
						if(key.isWritable()){
							
						}
						//д����
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
    * ͨ��key�Ϳ��Ի�ȡ�ͻ��˵�socketChanel,������ȡͨ���ϵĻ��壨��ˢ���������ݣ��������Ϳ��Ի�ȡ����
    * ���ж�д����
    * 
    * @param key
    */
	private void accept(SelectionKey key) {
		// TODO Auto-generated method stub
		
	}

}
