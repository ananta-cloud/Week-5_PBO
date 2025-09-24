// Dosen adalah jenis Pengguna lain untuk menunjukkan fleksibilitas.
public class Dosen extends Pengguna {
    private String kodeDosen;

    public Dosen(String nama, String nidn, String kodeDosen) {
        // Mengirim nama dan NIDN ke konstruktor Pengguna
        super(nama, nidn); 
        this.kodeDosen = kodeDosen;
    }
    
    public String getKodeDosen() {
        return kodeDosen;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println(
            "- Nama: " + getNama() + 
            ", NIDN: " + getNomorInduk() + 
            ", Kode: " + this.kodeDosen);
    }
}