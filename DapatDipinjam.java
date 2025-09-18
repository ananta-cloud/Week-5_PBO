public interface DapatDipinjam {
    void pinjam(Pengguna peminjam);
    void kembalikan();
    boolean isTersedia();
    String getStatus();
    String getNamaBarang();
}