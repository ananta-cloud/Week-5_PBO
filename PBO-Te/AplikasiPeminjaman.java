import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiPeminjaman {

    static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    static ArrayList<DapatDipinjam> daftarBarang = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiData();
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            tampilkanMenu();
            System.out.print("Masukkan pilihan Anda: ");
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, silakan masukkan angka.");
                pilihan = -1;
                continue;
            }

            switch (pilihan) {
                case 1:
                    prosesPinjam(scanner);
                    break;
                case 2:
                    prosesKembalikan(scanner);
                    break;
                case 3:
                    lihatStatusSemuaBarang();
                    break;
                case 4:
                    lihatDaftarPengguna();
                    break;
                case 5:
                    tambahBarang(scanner);
                    break;
                case 6:
                    jadwalkanPerawatan(scanner); 
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            if (pilihan != 0) {
                System.out.println("\nTekan Enter untuk kembali ke menu...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("\n===== MENU PEMINJAMAN BARANG =====");
        System.out.println("1. Pinjam Barang");
        System.out.println("2. Kembalikan Barang");
        System.out.println("3. Lihat Status Semua Barang");
        System.out.println("4. Lihat Daftar Pengguna");
        System.out.println("5. Tambah Barang Baru");
        System.out.println("6. Jadwalkan Perawatan Aset");
        System.out.println("0. Keluar");
        System.out.println("====================================");
    }

    public static void inisialisasiData() {
        daftarPengguna.add(new Peminjam("Budi Santoso", "2301001", "1B D3"));
        daftarPengguna.add(new Dosen("Dr. Indah Kurnia", "1985030301", "IF"));
        daftarBarang.add(new Barang("Kabel HDMI 5m"));
        daftarBarang.add(new AsetElektronik("Proyektor Epson EB-S41", "SN882B19X"));
    }

    public static void prosesPinjam(Scanner scanner) {
        System.out.println("\n--- Proses Peminjaman Barang ---");
        System.out.print("Masukkan Nomor Induk (NIM/NIDN) Anda: ");
        String noInduk = scanner.nextLine();

        Pengguna pengguna = cariPengguna(noInduk);

        if (pengguna == null) {
            System.out.println("Nomor Induk tidak terdaftar. Peminjaman tidak dapat dilanjutkan.");
            return;
        }

        System.out.println("Selamat datang, " + pengguna.getNama() + "!");

        System.out.println("\nDaftar barang yang tersedia:");
        ArrayList<DapatDipinjam> barangTersedia = new ArrayList<>();
        for (DapatDipinjam barang : daftarBarang) {
            if (barang.isTersedia()) {
                barangTersedia.add(barang);
                System.out.println("- " + barang.getNamaBarang());
            }
        }
        if (barangTersedia.isEmpty()) {
            System.out.println("Maaf, tidak ada barang yang tersedia untuk dipinjam.");
            return;
        }

        System.out.print("\nKetik nama barang yang ingin dipinjam: ");
        String namaBarangDipinjam = scanner.nextLine();
        boolean barangDitemukan = false;
        for (DapatDipinjam barang : barangTersedia) {
            if (barang.getNamaBarang().equalsIgnoreCase(namaBarangDipinjam)) {
                barang.pinjam(pengguna);
                System.out.println(
                        "\nBerhasil! '" + pengguna.getNama() + "' telah meminjam '" + barang.getNamaBarang() + "'.");
                barangDitemukan = true;
                break;
            }
        }
        if (!barangDitemukan) {
            System.out.println("\nGagal! Barang tidak ditemukan atau sudah dipinjam.");
        }
    }

    public static void jadwalkanPerawatan(Scanner scanner) {
        System.out.println("\n--- Jadwalkan Perawatan Aset Elektronik ---");
        System.out.println("Aset elektronik yang memerlukan perawatan:");

        ArrayList<Maintenance> asetPerluPerawatan = new ArrayList<>();
        for (DapatDipinjam item : daftarBarang) {
            // Cek apakah item ini adalah instance dari PerluPerawatan
            if (item instanceof Maintenance) {
                asetPerluPerawatan.add((Maintenance) item);
                // Kita perlu cast ke Barang untuk mendapatkan nama
                System.out.println("- " + ((Barang) item).getNamaBarang());
            }
        }

        if (asetPerluPerawatan.isEmpty()) {
            System.out.println("Tidak ada aset yang memerlukan perawatan.");
            return;
        }

        System.out.print("\nKetik nama aset yang ingin dijadwalkan perawatannya: ");
        String namaAset = scanner.nextLine();

        boolean ditemukan = false;
        for (Maintenance aset : asetPerluPerawatan) {
            if (((Barang) aset).getNamaBarang().equalsIgnoreCase(namaAset)) {
                // Memanggil metode dari interface Maintenance
                aset.jadwalPerawatan(); 
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Aset tidak ditemukan.");
        }
    }

    public static void prosesKembalikan(Scanner scanner) {
        System.out.println("\n--- Proses Pengembalian Barang ---");
        System.out.print("Masukkan Nomor Induk (NIM/NIDN) Anda untuk verifikasi: ");
        String noInduk = scanner.nextLine();

        Pengguna pengguna = cariPengguna(noInduk);
        if (pengguna == null) {
            System.out.println("\nGagal! Pengguna dengan ID " + noInduk + " tidak ditemukan.");
            return;
        }

        ArrayList<DapatDipinjam> barangDipinjamUser = new ArrayList<>();
        for (DapatDipinjam barang : daftarBarang) {
            if (!barang.isTersedia() && ((Barang) barang).getDipinjamOleh() == pengguna) {
                barangDipinjamUser.add(barang);
            }
        }

        if (barangDipinjamUser.isEmpty()) {
            System.out.println("\n" + pengguna.getNama() + " tidak memiliki barang yang sedang dipinjam.");
            return;
        }

        System.out.println("\nBarang yang Anda pinjam (" + pengguna.getNama() + "):");
        for (int i = 0; i < barangDipinjamUser.size(); i++) {
            System.out.println((i + 1) + ". " + barangDipinjamUser.get(i).getNamaBarang());
        }
        System.out.print("Pilih nomor barang yang ingin dikembalikan: ");
        try {
            int pilihan = Integer.parseInt(scanner.nextLine());
            if (pilihan > 0 && pilihan <= barangDipinjamUser.size()) {
                DapatDipinjam barangDikembalikan = barangDipinjamUser.get(pilihan - 1);
                barangDikembalikan.kembalikan();
                System.out.println("\nBerhasil! '" + barangDikembalikan.getNamaBarang() + "' telah dikembalikan.");
            } else {
                System.out.println("\nPilihan tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input salah, mohon masukkan nomor.");
        }
    }

    public static void lihatStatusSemuaBarang() {
        System.out.println("\n--- Status Semua Barang ---");
        for (DapatDipinjam barang : daftarBarang) {
            System.out.println("- " + barang.getNamaBarang() + " | Status: " + barang.getStatus());
        }
    }

    public static void lihatDaftarPengguna() {
        System.out.println("\n--- Daftar Pengguna Terdaftar ---");
        if (daftarPengguna.isEmpty()) {
            System.out.println("Belum ada pengguna yang terdaftar.");
            return;
        }
        for (Pengguna p : daftarPengguna) {
            p.tampilkanDetail();
        }
    }

    public static void tambahBarang(Scanner scanner) {
        System.out.println("\n--- Tambah Barang Baru ---");
        System.out.print("Masukkan nama barang baru: ");
        String namaBarang = scanner.nextLine();
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            System.out.println("\nGagal! Nama barang tidak boleh kosong.");
            return;
        }
        daftarBarang.add(new Barang(namaBarang));
        System.out.println("\nBerhasil! Barang '" + namaBarang + "' telah ditambahkan.");
    }

    public static Pengguna cariPengguna(String nomorInduk) {
        for (Pengguna p : daftarPengguna) {
            if (p.getNomorInduk().equals(nomorInduk)) {
                return p;
            }
        }
        return null;
    }
}