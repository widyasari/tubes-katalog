package TubesStrukdat_DataList;
import java.io.*;
import java.util.*;

public class DLLApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList DLL = new DoubleLinkedList();

        String file;

        //membuat list baru
        //memasukan 4 item

        String strLine, strings = "";
        boolean start = false;
        String Penulis = null, Judul = null, ID = null, Properti = null;

        file = ("GUTINDEX.ALL");
        try {
            if (file != null) {
                BufferedReader br = new BufferedReader(new FileReader(new File(file)));
                //membaca file per baris
                while ((strLine = br.readLine()) != null) {
                    if (strLine.equals("TITLE and AUTHOR                                                     ETEXT NO.")) {
                        start = true;
                        continue;
                    }
                    if (strLine.equalsIgnoreCase("<==End of GUTINDEX.ALL==>")) {
                        break;
                    }
                    if (start) {
                        if (strLine.length() != 0) {
                            //memisahkan judul dan penulis dengan ID
                            String[] arr1 = strLine.split("[ ]{3,}");
                            if (arr1.length > 0) {
                                if (arr1.length > 1) {
                                    ID = arr1[1];
                                }
                                strings = strings + arr1[0];
                            }
                        } else {
                            Properti = "";
                            if (strings.length() != 0) {
                                String[] arr2 = strings.split(", by ");
                                if (arr2.length > 1) {
                                    int index = arr2[1].indexOf("[");           //mencari posisi
                                    if (index >= 0) {                           //jika ditemukan, ada propertiesnya
                                        Penulis = arr2[1].substring(0, index);  //ambil string dari index 0 sampai menemukan karakter "["
                                        Properti = arr2[1].substring(index);//ambil string di mulai dari karakter "["
                                    } else {
                                        Penulis = arr2[1];
                                        Properti = "tidak tersedia";
                                    }
                                }
                                Judul = arr2[0];
                                DLL.insertLast(Penulis, Judul, ID, Properti);
                            }
                            strings = "";
                            Penulis = "";
                            Judul = "";
                            ID = "";
                            Properti = "";
                        }
                    }
                }
            }
        } catch (IOException e) {   //Catch exception
            for (StackTraceElement i : e.getStackTrace()) {
                System.err.println(i.toString());
            }
            System.err.println("Error: " + e);
        }

        System.out.print("Cari Judul Buku/Penulis : ");
        String input = scanner.nextLine();
        System.out.println(" ");
        DLL.search(input);

     }
}
