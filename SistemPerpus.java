import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SistemPerpus {
    static Scanner input = new Scanner(System.in);

    // Struktur data
    static int[] id = new int[100];
    static String[] nama = new String[100];
    static String[] kategori = new String[100];
    static int [] jumlah = new int[100];
    static int jumlahData = 0;
    static int counterTambah = 0;
    static int counterEdit   = 0;
    static int counterHapus  = 0;
    static String statusTerakhir = "Sistem dimulai";

    public static void main(String[] args) {

        // Inisialisasi data awal buku
        id[0]=1;  nama[0]="Matematika Dasar";       kategori[0]="Sains";     jumlah[0]=15;
        id[1]=2;  nama[1]="Fisika Modern";           kategori[1]="Sains";     jumlah[1]=8;
        id[2]=3;  nama[2]="Kimia Organik";           kategori[2]="Sains";     jumlah[2]=12;
        id[3]=4;  nama[3]="Biologi Sel";             kategori[3]="Sains";     jumlah[3]=20;
        id[4]=5;  nama[4]="Statistika Terapan";      kategori[4]="Sains";     jumlah[4]=6;
        id[5]=6;  nama[5]="Kalkulus Lanjut";         kategori[5]="Sains";     jumlah[5]=9;
        id[6]=7;  nama[6]="Pemrograman Java";        kategori[6]="Teknologi"; jumlah[6]=25;
        id[7]=8;  nama[7]="Basis Data";              kategori[7]="Teknologi"; jumlah[7]=18;
        id[8]=9;  nama[8]="Jaringan Komputer";       kategori[8]="Teknologi"; jumlah[8]=11;
        id[9]=10; nama[9]="Kecerdasan Buatan";       kategori[9]="Teknologi"; jumlah[9]=30;
        id[10]=11; nama[10]="Struktur Data";         kategori[10]="Teknologi"; jumlah[10]=14;
        id[11]=12; nama[11]="Keamanan Siber";        kategori[11]="Teknologi"; jumlah[11]=7;
        id[12]=13; nama[12]="Algoritma Pemrograman"; kategori[12]="Teknologi"; jumlah[12]=22;
        id[13]=14; nama[13]="Sejarah Indonesia";     kategori[13]="Sejarah";  jumlah[13]=10;
        id[14]=15; nama[14]="Sejarah Dunia";         kategori[14]="Sejarah";  jumlah[14]=13;
        id[15]=16; nama[15]="Perang Dunia II";       kategori[15]="Sejarah";  jumlah[15]=8;
        id[16]=17; nama[16]="Revolusi Industri";     kategori[16]="Sejarah";  jumlah[16]=5;
        id[17]=18; nama[17]="Sejarah Islam";         kategori[17]="Sejarah";  jumlah[17]=16;
        id[18]=19; nama[18]="Dinasti Ming";          kategori[18]="Sejarah";  jumlah[18]=4;
        id[19]=20; nama[19]="Kolonialisme Eropa";    kategori[19]="Sejarah";  jumlah[19]=9;
        id[20]=21; nama[20]="Sejarah Romawi";        kategori[20]="Sejarah";  jumlah[20]=11;
        id[21]=22; nama[21]="Bahasa Indonesia";      kategori[21]="Bahasa";   jumlah[21]=17;
        id[22]=23; nama[22]="Bahasa Inggris";        kategori[22]="Bahasa";   jumlah[22]=23;
        id[23]=24; nama[23]="Bahasa Jepang";         kategori[23]="Bahasa";   jumlah[23]=14;
        id[24]=25; nama[24]="Linguistik Umum";       kategori[24]="Bahasa";   jumlah[24]=6;
        id[25]=26; nama[25]="Sastra Indonesia";      kategori[25]="Bahasa";   jumlah[25]=10;
        id[26]=27; nama[26]="Tata Bahasa Inggris";   kategori[26]="Bahasa";   jumlah[26]=19;
        id[27]=28; nama[27]="Bahasa Arab";           kategori[27]="Bahasa";   jumlah[27]=8;
        id[28]=29; nama[28]="Pengantar Linguistik";  kategori[28]="Bahasa";   jumlah[28]=12;
        id[29]=30; nama[29]="Semantik dan Pragmatik"; kategori[29]="Bahasa";  jumlah[29]=5;
        jumlahData = 30;
    
    int pilih;
    do {
        System.out.println("\n=================================================");
        System.out.println("         SISTEM PERPUSTAKAAN DIGITAL");
        System.out.println("=================================================");
        System.out.println("1. CRUD");
        System.out.println("2. SEARCHING");
        System.out.println("3. SORTING");
        System.out.println("4. ADDITIONAL FEATURES");
        System.out.println("0. KELUAR");
        System.out.println("=================================================");
        System.out.print("Pilih menu: ");

        pilih = input.nextInt();

        switch (pilih) {
            case 1:
                menuCRUD(); break;
            case 2:
                menuSearching(); break;
            case 3:
                menuSorting(); break;
            case 4:
                menuFiturTambahan(); break;
            case 0:
                System.out.println("\n=================================================");    
                System.out.println("Thank You!\n");
                break;  
            default:
                System.out.println("\n=================================================");
                System.out.println("Pilihan tidak valid!\n");
            }

        } while (pilih != 0);
    }

static void menuCRUD() {
    int pilih;

    do {
        System.out.println("\n======== MENU CRUD ==========");
        System.out.println("1. Tambah Data");
        System.out.println("2. Tampilkan Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Hapus Data");
        System.out.println("0. Kembali");
        System.out.println("=============================");
        System.out.print("Pilih menu: ");
        pilih = input.nextInt();

        switch (pilih) {
            case 1:
                tambahData();
                break;
            case 2:
                tampilData();
                break;
            case 3:
                editData();
                break;
            case 4:
                hapusData();
                break;
                case 0:
                System.out.println("\n=============================");
                System.out.println("Kembali ke menu utama");
                break;
            default:
                System.out.println("\n=============================");
                System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    static void menuSearching() {
        int pilih;

        do {
            System.out.println("\n====== MENU SEARCHING =======");
            System.out.println("1. Cari Nama Buku");
            System.out.println("2. Cari ID Buku");
            System.out.println("3. Cari Kategori");
            System.out.println("0. Kembali");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    cariNama();
                    break;
                case 2:
                    cariID();
                    break;
                case 3:
                    cariKategori();
                    break;
                case 0:
                    System.out.println("\n=============================");
                    System.out.println("Kembali ke menu utama");
                    break;
                default:
                    System.out.println("\n=============================");
                    System.out.println("Pilihan tidak valid!");
                }

            } while (pilih != 0);
    }

    static void menuSorting() {
        int pilih;

        do {
            System.out.println("\n======= MENU SORTING ========");
            System.out.println("1. Sort ID");
            System.out.println("2. Sort Nama");
            System.out.println("3. Sort Jumlah Buku");
            System.out.println("0. Kembali");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    sortID();
                    break;
                case 2:
                    sortNama();
                    break;
                case 3:
                    sortJumlahDescending();
                    break;
                case 0:
                    System.out.println("\n=============================");
                    System.out.println("Kembali ke menu utama");
                    break;
                default:
                    System.out.println("\n=============================");
                    System.out.println("Pilihan tidak valid!");
                }

            } while (pilih != 0);
    }

    static void menuFiturTambahan() {
        int pilih;

        do {
            System.out.println("\n=== ADDITIONAL FEATURES ===");
            System.out.println("1. Statistik Data");
            System.out.println("2. Simpan Data ke File");
            System.out.println("3. Load Data dari File");
            System.out.println("4. Status Sistem");
            System.out.println("0. Kembali");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    tampilStatistik();
                    break;
                case 2:
                    simpanData();
                    break;
                case 3:
                    loadData();
                    break;
                case 4:
                    tampilStatusCounter();
                    break;
                case 0:
                    System.out.println("\n=============================");
                    System.out.println("Kembali ke menu utama");
                    break;
                default:
                    System.out.println("\n=============================");
                    System.out.println("Pilihan tidak valid!");
                }   

            } while (pilih != 0);
    }   

    // Method menambahkan data buku baru 
    static void tambahData() {

        System.out.println("\n=================================");
        System.out.println("         TAMBAH DATA BUKU");
        System.out.println("=================================");

        // Boundary handling jika kapasitas array penuh
        if (jumlahData >= id.length) {
            System.out.println("Kapasitas penyimpanan penuh");
            return;
        }

        System.out.print("Masukkan ID Buku      : ");

        // Boundary handling ID duplikat
        int idBaru = input.nextInt();

        if (linearSearchID(idBaru) != -1) {
            System.out.println("ID sudah digunakan");
            return;
        }

        id[jumlahData] = idBaru;
        input.nextLine();

        System.out.print("Masukkan Nama Buku    : ");
        nama[jumlahData] = input.nextLine();

        System.out.print("Masukkan Kategori     : ");
        kategori[jumlahData] = input.nextLine();

        System.out.print("Masukkan Jumlah Buku  : ");

        // Boundary handling jumlah negatif
        int jumlahBuku = input.nextInt();

        if (jumlahBuku < 0) {
            System.out.println("Jumlah buku tidak boleh negatif");
            return;
        }

        jumlah[jumlahData] = jumlahBuku;
        jumlahData++;

        System.out.println("=================================");
        System.out.println("Data berhasil ditambahkan");
        System.out.println("=================================");
    }   

    // Method menampilkan seluruh data buku
    static void tampilData() {

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("\n=================================");
            System.out.println("        DATA MASIH KOSONG");
            System.out.println("=================================");
            return;
        }

        System.out.println("\n========================================================================");
        System.out.println("                            DAFTAR DATA BUKU");
        System.out.println("========================================================================");
        System.out.printf("| %-4s | %-30s | %-15s | %-10s |\n",
                "ID", "NAMA BUKU", "KATEGORI", "JUMLAH");
        System.out.println("------------------------------------------------------------------------");

            for (int i = 0; i < jumlahData; i++) {
                System.out.printf("| %-4d | %-30s | %-15s | %-10d |\n",
                        id[i], nama[i], kategori[i], jumlah[i]);
            }

        System.out.println("========================================================================");
        System.out.println("Total Data : " + jumlahData + " buku");
    }

    // Method mengubah data buku berdasarkan ID
    static void editData() {

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("Data kosong");
            return;
        } 

        System.out.print("Masukkan ID yang ingin diedit: ");
        int key = input.nextInt();
        int index = linearSearchID(key);

        if (index != -1) {
            input.nextLine();
            System.out.print("Nama baru: ");
            nama[index] = input.nextLine();
            System.out.print("Kategori baru: ");
            kategori[index] = input.nextLine();
            System.out.print("Jumlah baru: ");
            jumlah[index] = input.nextInt();
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method menghapus data buku berdasarkan ID
    static void hapusData() {

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("Data kosong");
            return;
        }

        System.out.println("\n=================================");
        System.out.println("         HAPUS DATA BUKU");
        System.out.println("=================================");

        System.out.print("Masukkan ID Buku : ");
        int key = input.nextInt();

        int index = linearSearchID(key);

        if (index != -1) {

            System.out.println("---------------------------------");
            System.out.println("Data yang akan dihapus:");
            System.out.println("---------------------------------");
            System.out.println("ID       : " + id[index]);
            System.out.println("Nama     : " + nama[index]);
            System.out.println("Kategori : " + kategori[index]);
            System.out.println("Jumlah   : " + jumlah[index]);

            for (int i = index; i < jumlahData - 1; i++) {
                id[i] = id[i + 1];
                nama[i] = nama[i + 1];
                kategori[i] = kategori[i + 1];
                jumlah[i] = jumlah[i + 1];
            }

            jumlahData--;

            System.out.println("=================================");
            System.out.println("Data berhasil dihapus");
            System.out.println("=================================");

        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method Linear Search untuk mencari buku berdasarkan nama
    static void cariNama() {
        input.nextLine();

        System.out.print("Masukkan nama: ");
        String key = input.nextLine();

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("Data kosong");
            return;
        }

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (nama[i].equalsIgnoreCase(key)) {
                System.out.println("Ditemukan: " + id[i] + " | " + nama[i] + " | " + kategori[i] + " | " + jumlah[i]);
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method Binary Search untuk mencari buku berdasarkan ID
    static void cariID() {

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("Data kosong");
            return;
        }

        bubbleSortID();
        System.out.print("Masukkan ID: ");
        int key = input.nextInt();
        int hasil = binarySearch(key);

        if (hasil != -1) {
            System.out.println("Ditemukan: " + id[hasil] + " | " + nama[hasil] + " | " + kategori[hasil] + " | " + jumlah[hasil]);
        } else {
            System.out.println("Tidak ditemukan");
        }
    }

    // Method Linear Search untuk mencari buku berdasarkan kategori
    static void cariKategori() {
        input.nextLine();

        // Boundary handling data kosong
        if (jumlahData == 0) {
            System.out.println("Data kosong");
            return;
        }

        System.out.print("Masukkan kategori: ");
        String key = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (kategori[i].equalsIgnoreCase(key)) {

                System.out.println(
                        id[i] + " | " +
                        nama[i] + " | " +
                        kategori[i] + " | " +
                        jumlah[i]
                );

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kategori tidak ditemukan");
        }
    }

    // Method Bubble Sort untuk mengurutkan ID secara ascending
    static void sortID() {
        bubbleSortID();

        if (jumlahData == 0) {
         System.out.println("Data kosong.");
         return;
        }

        System.out.println("=== Data Setelah Diurutkan ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            ); 
        }
    }

    // Method Selection Sort untuk mengurutkan nama buku A-Z
    static void sortNama() {
        selectionSortNama();

        if (jumlahData == 0) {
         System.out.println("Data kosong.");
         return;
        }

        System.out.println("=== Data Setelah Diurutkan (A-Z) ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            ); 
        }
    }

    static void sortJumlahDescending() {
        bubleSortDesc();

        if (jumlahData == 0) {
            System.out.println("Data kosong.");
            return;
        }

        System.out.println("=== Data Setelah Diurutkan (Descending) ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            );
        }
    }

    // Kumpulan method SORTING

    // Bubble Sort ascending berdasarkan ID buku
    static void bubbleSortID() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - 1 - i; j++) {
                if (id[j] > id[j + 1]) {
                    // tukar semua atribut
                    swap(j, j + 1);
                }
            }
        }
    }

    // Selection Sort ascending berdasarkan nama buku
    static void selectionSortNama() {
        for (int i = 0; i < jumlahData - 1; i++) {
        int minIndex = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (nama[j].compareToIgnoreCase(nama[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }

    // Bubble Sort descending berdasarkan jumlah buku
    static void bubleSortDesc() {

        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - 1 - i; j++) {
                if (jumlah[j] < jumlah[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // Kumpulan method SEARCHING

    // Binary Search untuk mencari ID buku
    static int binarySearch(int key) {
        int low = 0, high = jumlahData - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (id[mid] == key) return mid;
            else if (id[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Linear Search untuk mencari posisi ID buku
    static int linearSearchID(int key) {
        for (int i = 0; i < jumlahData; i++) {
            if (id[i] == key) return i;
        }
        return -1;
    }

    // Method untuk menukar seluruh atribut data buku
    static void swap(int a, int b) {
        int tempId = id[a];
        id[a] = id[b];
        id[b] = tempId;

        String tempNama = nama[a];
        nama[a] = nama[b];
        nama[b] = tempNama;

        String tempKategori = kategori[a];
        kategori[a] = kategori[b];
        kategori[b] = tempKategori;

        int tempJumlah = jumlah[a];
        jumlah[a] = jumlah[b];
        jumlah[b] = tempJumlah;
    }

static void tampilStatusCounter() {
        System.out.println("\n------------------------------------------");
        System.out.println("  STATUS SISTEM PERPUSTAKAAN");
        System.out.println("------------------------------------------");
        System.out.println("  Status Terakhir : " + statusTerakhir);
        System.out.println("  Total Data      : " + jumlahData + " buku");
        System.out.println("  [+] Tambah      : " + counterTambah + " kali");
        System.out.println("  [~] Edit        : " + counterEdit   + " kali");
        System.out.println("  [-] Hapus       : " + counterHapus  + " kali");
        System.out.println("------------------------------------------");
    }
 
    // [FITUR 2] Statistik data: total, tersedia, per kategori, min/max
    static void tampilStatistik() {
        if (jumlahData == 0) {
            System.out.println("Data kosong, tidak ada statistik.");
            return;
        }
 
        int totalStok    = 0;
        int maxJumlah    = jumlah[0];
        int minJumlah    = jumlah[0];
        String bukuTerbanyak  = nama[0];
        String bukuTersedikit = nama[0];
 
        for (int i = 0; i < jumlahData; i++) {
            totalStok += jumlah[i];
            if (jumlah[i] > maxJumlah) { maxJumlah = jumlah[i]; bukuTerbanyak  = nama[i]; }
            if (jumlah[i] < minJumlah) { minJumlah = jumlah[i]; bukuTersedikit = nama[i]; }
        }
 
        double rataRata = (double) totalStok / jumlahData;
 
        System.out.println("\n========================================");
        System.out.println("       STATISTIK DATA PERPUSTAKAAN");
        System.out.println("========================================");
        System.out.printf("  Total Judul Buku   : %d buku%n",             jumlahData);
        System.out.printf("  Total Stok Seluruh : %d eksemplar%n",        totalStok);
        System.out.printf("  Rata-rata Stok     : %.2f eksemplar/judul%n", rataRata);
        System.out.printf("  Stok Terbanyak     : %s (%d)%n",  bukuTerbanyak,  maxJumlah);
        System.out.printf("  Stok Tersedikit    : %s (%d)%n",  bukuTersedikit, minJumlah);
 
        // Statistik per kategori
        String[] kategoriUnik = {"Sains", "Teknologi", "Sejarah", "Bahasa"};
        System.out.println("\n--- Statistik per Kategori ---");
        System.out.printf("  %-12s | %-7s | %-12s | %-8s%n",
                "Kategori", "Judul", "Total Stok", "Rata-rata");
        System.out.println("  " + "-".repeat(50));
 
        for (String kat : kategoriUnik) {
            int jmlJudul = 0, stokKat = 0;
            for (int i = 0; i < jumlahData; i++) {
                if (kategori[i].equalsIgnoreCase(kat)) { jmlJudul++; stokKat += jumlah[i]; }
            }
            if (jmlJudul > 0) {
                System.out.printf("  %-12s | %-7d | %-12d | %.2f%n",
                        kat, jmlJudul, stokKat, (double) stokKat / jmlJudul);
            }
        }
 
        // Ketersediaan stok
        int tersedia = 0, habis = 0;
        for (int i = 0; i < jumlahData; i++) {
            if (jumlah[i] > 0) tersedia++; else habis++;
        }
        System.out.println("\n--- Ketersediaan Stok ---");
        System.out.printf("  Tersedia (stok > 0) : %d judul%n", tersedia);
        System.out.printf("  Habis   (stok = 0)  : %d judul%n", habis);
        System.out.println("========================================");
 
        statusTerakhir = "Statistik data ditampilkan";
    }
 
    // [FITUR 3A] Simpan seluruh data buku ke file teks
    static void simpanData() {
        String namaFile = "data_perpus.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile));
            bw.write("# DATA PERPUSTAKAAN");    bw.newLine();
            bw.write("# Format: ID|NAMA|KATEGORI|JUMLAH"); bw.newLine();
            bw.write("# Total data: " + jumlahData); bw.newLine();
 
            for (int i = 0; i < jumlahData; i++) {
                bw.write(id[i] + "|" + nama[i] + "|" + kategori[i] + "|" + jumlah[i]);
                bw.newLine();
            }
            bw.close();
 
            System.out.println("[OK] Data berhasil disimpan ke: " + namaFile);
            System.out.println("     Total " + jumlahData + " buku tersimpan.");
            statusTerakhir = "Data disimpan ke " + namaFile + " (" + jumlahData + " buku)";
 
        } catch (IOException e) {
            System.out.println("[ERROR] Gagal menyimpan file: " + e.getMessage());
            statusTerakhir = "Gagal simpan data ke file";
        }
    }
 
    // [FITUR 3B] Load data buku dari file teks
    static void loadData() {
        String namaFile = "data_perpus.txt";
 
        if (!new File(namaFile).exists()) {
            System.out.println("[ERROR] File tidak ditemukan: " + namaFile);
            System.out.println("        Buat file terlebih dahulu lewat menu Simpan Data.");
            statusTerakhir = "Gagal load: file tidak ditemukan";
            return;
        }
 
        System.out.println("[PERINGATAN] Load data akan menggantikan data yang ada saat ini!");
        System.out.print("Lanjutkan? (1=Ya / 0=Tidak): ");
        int konfirmasi = input.nextInt();
        if (konfirmasi != 1) {
            System.out.println("Load data dibatalkan.");
            return;
        }
 
        try {
            BufferedReader br = new BufferedReader(new FileReader(namaFile));
            int jumlahBaru = 0;
            String line;
 
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    id[jumlahBaru]       = Integer.parseInt(parts[0].trim());
                    nama[jumlahBaru]     = parts[1].trim();
                    kategori[jumlahBaru] = parts[2].trim();
                    jumlah[jumlahBaru]   = Integer.parseInt(parts[3].trim());
                    jumlahBaru++;
                    if (jumlahBaru >= 100) {
                        System.out.println("[INFO] Kapasitas maksimal (100) tercapai.");
                        break;
                    }
                }
            }
            br.close();
            jumlahData = jumlahBaru;
 
            System.out.println("[OK] Data berhasil dimuat dari: " + namaFile);
            System.out.println("     Total " + jumlahData + " buku berhasil dimuat.");
            statusTerakhir = "Data dimuat dari " + namaFile + " (" + jumlahData + " buku)";
 
        } catch (IOException e) {
            System.out.println("[ERROR] Gagal membaca file: " + e.getMessage());
            statusTerakhir = "Gagal load data dari file";
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Format file tidak valid: " + e.getMessage());
            statusTerakhir = "Gagal load: format file tidak valid";
        }
    }
}