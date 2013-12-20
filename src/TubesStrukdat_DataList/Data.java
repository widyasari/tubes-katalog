package TubesStrukdat_DataList;

public class Data {

    public String Penulis;  // data item
    public String Judul;
    public String ID;
    public String Properti;

    Data next;      // next link
    Data prev;      // prev link

    public Data(String Penulis, String Judul, String ID, String Properti) {   // konstruktor
        this.Penulis = Penulis;     // inisialisasi data
        this.Judul = Judul;
        this.ID = ID;
        this.Properti = Properti;
    }
}
