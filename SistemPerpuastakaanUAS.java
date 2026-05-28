import java.util.Scanner;

record Buku(String kode, String judul, String penulis, int tahun, boolean tersedia) {}

public class SistemPerpustakaanUTS {

    static Buku[] daftarBuku = new Buku[100];
    static int jumlahBuku = 3;

    public static void main(String[] args) {

        // Data buku sudah tersedia
        daftarBuku[0] = new Buku("B01","Laskar Pelangi","Andrea Hirata",2005,true);
        daftarBuku[1] = new Buku("B02","Bumi Manusia","Pramoedya A.T",1980,false);
        daftarBuku[2] = new Buku("B03","Algoritma","Rinaldi M",2010,true);

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM DATA BUKU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Semua Buku");
            System.out.println("3. Cari Kode Buku");
            System.out.println("4. Tampilkan Buku yang True");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahBuku(input);
                    break;

                case 2:
                    tampilkanSemua();
                    break;

                case 3:
                    cariBuku(input);
                    break;

                case 4:
                    tampilkanTersedia();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }

    static void tambahBuku(Scanner input) {

        System.out.print("Kode Buku: ");
        String kode = input.nextLine();

        System.out.print("Judul: ");
        String judul = input.nextLine();

        System.out.print("Penulis: ");
        String penulis = input.nextLine();

        System.out.print("Tahun: ");
        int tahun = input.nextInt();
        input.nextLine();

        daftarBuku[jumlahBuku] = new Buku(kode, judul, penulis, tahun, true);
        jumlahBuku++;

        System.out.println("Buku berhasil ditambahkan!");
    }

    static void tampilkanSemua() {

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-5s %-6s %-20s %-20s %-6s %-10s\n",
                "No","Kode","Judul","Penulis","Tahun","Status");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < jumlahBuku; i++) {

            Buku b = daftarBuku[i];

            String status;
            if (b.tersedia()) {
                status = "True";
            } else {
                status = "False";
            }

            System.out.printf("%-5d %-6s %-20s %-20s %-6d %-10s\n",
                    (i+1),
                    b.kode(),
                    b.judul(),
                    b.penulis(),
                    b.tahun(),
                    status);
        }

        System.out.println("---------------------------------------------------------------------");
    }

    static void cariBuku(Scanner input) {

        System.out.print("Masukkan kode buku: ");
        String kode = input.nextLine();

        for (int i = 0; i < jumlahBuku; i++) {

            if (daftarBuku[i].kode().equalsIgnoreCase(kode)) {

                Buku b = daftarBuku[i];

                System.out.println("Buku ditemukan:");
                System.out.println(
                        b.kode() + " | " +
                        b.judul() + " | " +
                        b.penulis() + " | " +
                        b.tahun() + " | " +
                        (b.tersedia() ? "True" : "False")
                );
                return;
            }
        }

        System.out.println("Buku tidak ditemukan.");
    }

    static void tampilkanTersedia() {

        System.out.println("\nBuku yang True:");

        for (int i = 0; i < jumlahBuku; i++) {

            if (daftarBuku[i].tersedia()) {

                Buku b = daftarBuku[i];

                System.out.println(
                        b.kode() + " | " +
                        b.judul() + " | " +
                        b.penulis() + " | " +
                        b.tahun() + " | " +
                        (b.tersedia() ? " | True | " : " | False |")
                );
            }
        }
    }
}