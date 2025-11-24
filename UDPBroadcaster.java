import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
public class UDPBroadcaster {
    public static void main(String[] args) throws Exception {
        String msg = args.length>0 ? args[0] : "Hello There";
        int port = 4445;
        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);
        byte[] buf = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("255.255.255.255"), port);
        socket.send(packet);
        System.out.println("Message broadcasted: " + msg);
        socket.close();
    }
}

