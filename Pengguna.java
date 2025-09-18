public abstract class Pengguna {
    protected String nama;
    protected String nomorInduk;

    public Pengguna(String nama, String nomorInduk) {
        this.nama = nama;
        this.nomorInduk = nomorInduk;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorInduk() {
        return nomorInduk;
    }

    // Metode abstrak tampilkanDetail
    public abstract void tampilkanDetail();
}