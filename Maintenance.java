import java.time.LocalDate;

public interface Maintenance {
    void jadwalPerawatan();
    LocalDate getTanggalPerawatanTerakhir();
}