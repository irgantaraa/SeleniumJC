# Otomasi Web Table menggunakan Selenium

Repositori ini mendemonstrasikan cara menggunakan **Selenium** untuk mengotomatisasi interaksi dengan komponen web table yang tersedia di [demoqa.com/webtables](https://demoqa.com/webtables). Tujuannya adalah melakukan operasi seperti menambah, mengedit, menghapus, dan mencari data di dalam web table.

## Fitur

- **Tambah Data Baru**: Mengotomatisasi proses menambah entri baru ke dalam web table.
- **Edit Data**: Skrip untuk mencari dan memperbarui data yang sudah ada berdasarkan kondisi yang didefinisikan pengguna.
- **Hapus Data**: Mengotomatisasi fungsi penghapusan data.
- **Cari Data**: Menerapkan kemampuan pencarian untuk menemukan data tertentu berdasarkan kriteria.
- **Validasi Data Tabel**: Memverifikasi apakah data yang benar ada atau telah diperbarui di dalam tabel.

## Alat dan Teknologi

- **Selenium WebDriver**: Mengotomatisasi interaksi dengan browser.
- **Java**: Bahasa pemrograman yang digunakan untuk skrip otomatisasi.
- **Firefox (GeckoDriver)** atau **Chrome (ChromeDriver)**: WebDriver untuk menjalankan tes di Firefox atau Chrome.
- **JUnit/TestNG**: Kerangka kerja pengujian untuk menjalankan dan memverifikasi tes (opsional).

## Memulai

### Prasyarat

- **Java** diinstal di komputer Anda. Anda dapat mengunduhnya dari [sini](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Selenium WebDriver** diinstal. Ikuti instruksi dari [situs resmi](https://www.selenium.dev/).
- **GeckoDriver** (untuk Firefox) atau **ChromeDriver** (untuk Chrome) diinstal:
  - Unduh **GeckoDriver** dari [sini](https://github.com/mozilla/geckodriver/releases).
  - Unduh **ChromeDriver** dari [sini](https://sites.google.com/chromium.org/driver/).
- Tambahkan `GeckoDriver` atau `ChromeDriver` ke PATH sistem Anda.

### Instalasi

1. Clone repositori ini:

   ```bash
   git clone https://github.com/<your-username>/web-table-automation.git
   cd web-table-automation
   ```

2. Tambahkan library **Selenium** ke proyek Anda:

   - Unduh Selenium Java bindings dari [sini](https://www.selenium.dev/downloads/).
   - Sertakan file `.jar` ke dalam build path proyek Anda.

3. Siapkan WebDriver yang sesuai:
   - Unduh dan ekstrak **GeckoDriver** atau **ChromeDriver**.
   - Tempatkan di direktori yang ada dalam PATH sistem Anda.

### Menjalankan Skrip Otomasi

Anda dapat menjalankan skrip pengujian dengan langkah-langkah berikut:

1. **Tambah Data**:

   Untuk menambahkan data ke dalam tabel, skrip otomatis akan mengklik tombol `Add`, mengisi kolom formulir (nama depan, nama belakang, usia, gaji, departemen), dan mengirimkan formulir.

2. **Edit Data**:

   Untuk mengedit data yang ada, skrip akan mencari data berdasarkan kolom tertentu (seperti nama atau email), mengklik tombol `Edit`, mengubah datanya, dan menyimpan perubahan.

3. **Hapus Data**:

   Skrip akan menemukan data yang diinginkan berdasarkan kriteria tertentu dan mengklik tombol `Delete` untuk menghapusnya dari tabel.

4. **Cari Data**:

   Fitur pencarian diotomatisasi dengan memasukkan kata kunci pencarian di kotak pencarian dan memverifikasi hasil yang difilter.

```java
// Contoh kode untuk menambah data baru ke dalam web table
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  // atau ChromeDriver

public class WebTableAutomation {
    public static void main(String[] args) {
        // Untuk Firefox
        System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
        WebDriver driver = new FirefoxDriver();
        
        // Untuk Chrome
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        // WebDriver driver = new ChromeDriver();
        
        driver.get("https://demoqa.com/webtables");

        // Klik tombol Add
        driver.findElement(By.id("addNewRecordButton")).click();

        // Isi form
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("5000");
        driver.findElement(By.id("department")).sendKeys("Engineering");

        // Kirim form
        driver.findElement(By.id("submit")).click();
    }
}
```

### Menggunakan ChromeDriver

Untuk menggunakan **ChromeDriver** sebagai pengganti **GeckoDriver**, ikuti langkah-langkah ini:

1. Unduh **ChromeDriver** dari [situs resmi](https://sites.google.com/chromium.org/driver/).
2. Siapkan **ChromeDriver** dengan menambahkan path-nya ke variabel lingkungan sistem atau dengan menentukan lokasinya di kode:

   ```java
   System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
   WebDriver driver = new ChromeDriver();
   ```

3. Komentari atau hapus pengaturan **GeckoDriver** dan gunakan baris **ChromeDriver** untuk menjalankan skrip otomatisasi di Google Chrome.

### Menjalankan Tes

Anda bisa mengintegrasikan **JUnit** atau **TestNG** untuk mengotomatisasi dan memverifikasi kasus uji. Untuk menjalankan tes:

- Jika menggunakan **JUnit**:
  ```bash
  mvn test
  ```

## Troubleshooting

- **WebDriver tidak ditemukan**: Pastikan Anda telah menambahkan path `GeckoDriver` atau `ChromeDriver` ke PATH sistem Anda.
- **Elemen tidak bisa diakses**: Gunakan `WebDriverWait` untuk memastikan elemen telah dimuat sebelum berinteraksi dengannya.

## Kontribusi

Silakan buka issue atau kirim pull request jika Anda menemukan bug atau memiliki saran perbaikan.

## Lisensi

Proyek ini dilisensikan di bawah lisensi MIT.
