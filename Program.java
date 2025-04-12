import java.io.*;

class Program {


    public static void main(String[] args) {
        int zooX=0, zooY=0, zooZ=0; 
        int droneX=0, droneY=0, droneZ=0;  
        int maxDistance=0;     
        try {
            BufferedReader br = new BufferedReader(
                new 
                FileReader("C:\\Users\\ngmul\\OneDrive\\Documents\\GitHub\\ENTELECT-HACKATHON\\1.txt"));
            
            String[] zoo = br.readLine().split(",");

            zooX= Integer.parseInt(zoo[0].substring(1));
            zooY= Integer.parseInt(zoo[1]);
            zooZ= Integer.parseInt(zoo[2].substring(0, zoo[2].length()-1));

            String[] drone = br.readLine().split(",");

            droneX= Integer.parseInt(drone[0].substring(1));
            droneY= Integer.parseInt(drone[1]);
            droneZ= Integer.parseInt(drone[2].substring(0, drone[2].length()-1));

            maxDistance = Integer.parseInt(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(zooX);
        System.out.println(zooY);
        System.out.println(zooZ);
        System.out.println();
        System.out.println(droneX);
        System.out.println(droneY);
        System.out.println(droneZ);
        System.out.println();
        System.out.println(maxDistance);

    }
}