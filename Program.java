import java.io.*;
import java.util.*;

class DataPoint {
    int x, y, z;
    char type;

    DataPoint(int x, int y, int z, char type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + "," + type + ")";
    }
}

class Enclosure {
    int x, y, z;
    double p;
    char type;

    Enclosure(int x, int y, int z,double p,char type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.p = p;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + "," + p + ","+ type + ")";
    }
}

class Deadzone {
    int x, y, r;

    Deadzone(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + r +")";
    }
}

class Program {



        int zooX=0, zooY=0, zooZ=0; 
        int droneX=0, droneY=0, droneZ=0;  
        int maxDistance=0;    
        
        List<DataPoint> storages = new ArrayList<>();
        List<Enclosure> enclosures = new ArrayList<>();
        List<Deadzone> deadzones = new ArrayList<>();
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

            String storage = br.readLine();

            storage = storage.substring(1, storage.length() - 1); // chop off [ and ]
        
            // Split into individual tuples
            String[] parts = storage.split("\\),\\(");
    

            for (String part : parts) {
                part = part.replace("(", "").replace(")", "");
                String[] elements = part.split(",");
                
                int x = Integer.parseInt(elements[0]);
                int y = Integer.parseInt(elements[1]);
                int z = Integer.parseInt(elements[2]);
                char type = elements[3].charAt(0);

                storages.add(new DataPoint(x, y, z, type));
            } 

            // Read enclosures

            String enclosure = br.readLine();

            enclosure = enclosure.substring(1, enclosure.length() - 1); // chop off [ and ]
        
            // Split into individual tuples
            String[] encs = enclosure.split("\\),\\(");
    
            
            for (String part : encs) {
                part = part.replace("(", "").replace(")", "");
                String[] elements = part.split(",");
                
                int x = Integer.parseInt(elements[0]);
                int y = Integer.parseInt(elements[1]);
                int z = Integer.parseInt(elements[2]);
                double p = Double.parseDouble(elements[3]);
                char type = elements[4].charAt(0);

                enclosures.add(new Enclosure(x, y, z, p, type));

                }

            //DEADZONES


                String dz = br.readLine();
                if (dz.equals("[]")) {
                    System.out.println("No deadzones");
                }else
                {
                    
                dz = dz.substring(1, dz.length() - 1); // chop off [ and ]
            
                // Split into individual tuples
                String[] dzs = dz.split("\\),\\(");
        
    
                for (String par : dzs) {
                    par = par.replace("(", "").replace(")", "");
                    String[] elements = par.split(",");
                    
                    int x = Integer.parseInt(elements[0]);
                    int y = Integer.parseInt(elements[1]);
                    int r = Integer.parseInt(elements[2]);
    
                    deadzones.add(new Deadzone(x, y, r));
                } 
                }

             

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
        System.out.println();
        
        for (DataPoint point : storages) {
            System.out.println(point);
        }
        System.out.println();
        for (Enclosure point : enclosures) {
            System.out.println(point);
        }
        System.out.println();
        for (Deadzone point : deadzones) {
            System.out.println(point);
        }


    }
}