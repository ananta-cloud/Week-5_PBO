public class Peminjam extends Pengguna {
    private String kelas;

    public Peminjam(String nama, String nim, String kelas) {
        super(nama, nim);
        this.kelas = kelas;
    }
    
    public String getKelas() {
        return kelas;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println(
            "- Nama: " + getNama() + 
            ", NIM: " + getNomorInduk() +
            ", Kelas: " + this.kelas);
    }
} 