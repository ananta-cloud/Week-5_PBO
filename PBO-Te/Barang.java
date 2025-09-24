public class Barang implements DapatDipinjam {
    protected String namaBarang;
    protected boolean tersedia;
    protected Pengguna dipinjamOleh;

    public Barang(String namaBarang) {
        this.namaBarang = namaBarang;
        this.tersedia = true;
        this.dipinjamOleh = null;
    }

    @Override
    public void pinjam(Pengguna peminjam) {
        if (this.tersedia) {
            this.tersedia = false;
            this.dipinjamOleh = peminjam;
        }
    }

    @Override
    public void kembalikan() {
        this.tersedia = true;
        this.dipinjamOleh = null;
    }

    @Override
    public String getNamaBarang() {
        return namaBarang;
    }

    @Override
    public boolean isTersedia() {
        return tersedia;
    }

    public Pengguna getDipinjamOleh() {
        return dipinjamOleh;
    }

    @Override
    public String getStatus() {
        if (tersedia) {
            return "Tersedia";
        } else {
            return 
            "Dipinjam oleh: " + this.dipinjamOleh.getNama() + 
            " (ID: " + this.dipinjamOleh.getNomorInduk() + ")";
        }
    }
}