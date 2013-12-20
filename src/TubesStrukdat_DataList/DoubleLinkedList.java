package TubesStrukdat_DataList;

public class DoubleLinkedList {

    Data first;
    Data last;

    public void insertLast(String penulis, String judul, String id, String properties) {
        Data input = new Data(penulis, judul, id, properties);
        if (isEmpty()) {
            first = input;
        } else {
            last.next = input;
        }
        input.prev = last;
        last = input;
    }

    boolean isEmpty() {
        return (first == null && last == null);
    }

    void display() {
        Data current = first;
        while (current != null) {
            System.out.println(current.Judul + " " + current.Penulis + " " + current.ID + " " + current.Properti);
            current = current.next;
        }
    }

        public void search(String key) {
        Data current = first;       //mulai dari awal list
        boolean found = false;

        while (current != null) {
            found = true;
            if (current.Penulis.contains(key) || current.Judul.contains(key)) {
                System.out.println("ID  \t\t  : " + current.ID + "\n" + "Judul       \t  : " + current.Judul + "\n" + "Penulis      \t : " + current.Penulis + "\n" + "Properti     \t : " + current.Properti);
               //cetak data
                System.out.println("");
            }
            current = current.next; 
            //pindah ke link berikutnya

        }
        if (!found) {
            System.out.println("File Not Found");
        }
        System.out.println("");
    }




}
