import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        int port = 4445;
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("Listening on udp port " + port);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (true) {
            socket.receive(packet);
            String s = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("Got from " + packet.getAddress() + ": " + s);
        }
    }
}

