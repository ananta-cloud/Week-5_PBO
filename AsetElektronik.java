// File: AsetElektronik.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// AsetElektronik MEWARISI sifat dari Barang (extends)
// MENGADOPSI perilaku tambahan dari Maintenance (implements).
public class AsetElektronik extends Barang implements Maintenance {
    private String nomorSeri;
    private LocalDate tanggalPerawatanTerakhir;

    public AsetElektronik(String namaBarang, String nomorSeri) {
        super(namaBarang);
        this.nomorSeri = nomorSeri;
        this.tanggalPerawatanTerakhir = null; 
    }

    // Meng-override getStatus untuk menambahkan info Nomor Seri
    @Override
    public String getStatus() {
        String statusDasar = super.getStatus();
        String infoPerawatan;
        if (tanggalPerawatanTerakhir != null) {
            infoPerawatan = ", dirawat pada " + tanggalPerawatanTerakhir.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } else {
            infoPerawatan = ", belum pernah dirawat";
        }
        return statusDasar + " [SN: " + this.nomorSeri + infoPerawatan + "]";
    }

    // Implementasi metode dari interface Maintenance
    @Override
    public void jadwalPerawatan() {
        this.tanggalPerawatanTerakhir = LocalDate.now();
        System.out.println("Perawatan untuk '" + getNamaBarang() + "' (SN: " + this.nomorSeri + ") telah dijadwalkan hari ini.");
    }
    @Override
    public LocalDate getTanggalPerawatanTerakhir() {
        return this.tanggalPerawatanTerakhir;
    }
}