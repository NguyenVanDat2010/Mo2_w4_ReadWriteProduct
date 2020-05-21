import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /** Thêm dữ liệu vào file*/
    public void AddDataByStream(String input) {
        try {
            File file = new File(input);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.newLine();


            Product product1 = new Product(5, "Xiaomi X2 Pro", "Xiaomi", 9000000);
            Product product2 = new Product(6, "Iphone 11 pro max", "Apple", 35000000);
            Product product3 = new Product(7, "Samsung Note 11", "Samsung", 25000000);
            Product product4 = new Product(8, "Huawei nova 3i", "Huawei", 7000000);

            bufferedWriter.write(String.valueOf(product1));
            bufferedWriter.write(String.valueOf(product2));
            bufferedWriter.write(String.valueOf(product3));
            bufferedWriter.write(String.valueOf(product4));
            bufferedWriter.close();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (Exception ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

    /** Đọc file dữ liệu bằng inputstream ép sang kiểu char (ko chuyên dùng để đọc file text)*/
    public void ReadDataByCharStream(String input) {
        try {
            BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(input));

            int byteRead;
            while ((byteRead = bufferedReader.read()) != -1) {
                System.out.print((char) byteRead);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void WriteData() throws IOException {
////        String csvFile="product1.csv";
////        File file=new File(csvFile);
//        try {
//            FileOutputStream fos=new FileOutputStream("product1.csv");
//            ObjectOutputStream oos=new ObjectOutputStream(fos);
//
//            Product[]products={
//                    new Product(1,"Xiaomi X2 Pro","Xiaomi",9000000),
//                    new Product(2,"Iphone 11 pro max","Apple",35000000),
//                    new Product(3,"Samsung Note 11","Samsung",25000000),
//                    new Product(4,"Huawei nova 3i","Huawei",7000000)
//            };
//            oos.writeObject(products);
//            fos.close();
//            oos.close();
//        }catch (IOException ex) {
//            System.out.println("Loi ghi file: "+ex);
//        }
//    }

    public static void main(String[] args) throws IOException {
        Main myMain=new Main();
//        myMain.WriteData();
        myMain.ReadDataByCharStream("product.csv");
        myMain.AddDataByStream("product.csv");
    }
}
