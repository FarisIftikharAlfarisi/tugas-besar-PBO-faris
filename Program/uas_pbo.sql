-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 06 Agu 2023 pada 13.57
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `anggota_id` int NOT NULL,
  `user` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`anggota_id`, `user`, `password`) VALUES
(1, 'admin', 'asuna');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `buku_id` int NOT NULL,
  `penulis` varchar(100) DEFAULT NULL,
  `penerbit` varchar(100) DEFAULT NULL,
  `isbn` varchar(100) DEFAULT NULL,
  `judul` varchar(100) DEFAULT NULL,
  `tahunterbit` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`buku_id`, `penulis`, `penerbit`, `isbn`, `judul`, `tahunterbit`) VALUES
(1, 'John Doe', 'Penerbit A', '978-1234567890', 'Judul Buku A', '2025-12-11'),
(2, 'Jane Smith', 'Penerbit B', '978-9876543210', 'Judul Buku B', '2021-11-22'),
(3, 'Michael Johnson', 'Penerbit A', '978-5678901234', 'Judul Buku C', '2023-04-10'),
(4, 'Sarah Williams', 'Penerbit C', '978-0987654321', 'Judul Buku D', '2020-07-05'),
(6, 'Emily Davis', 'Penerbit A', '978-3456789012', 'Judul Buku F', '2022-09-20'),
(7, 'David Martin', 'Penerbit C', '978-4567890123', 'Judul Buku G', '2021-12-30'),
(9, 'Daniel Anderson', 'Penerbit A', '978-7890123456', 'Judul Buku I', '2023-06-17'),
(10, 'Susan Martinez', 'Penerbit D', '978-8901234568', 'Judul Buku J', '2020-03-25'),
(11, 'qweq', 'weq', 'eqwe', 'asdqw', '2023-07-03'),
(13, 'qwe', 'asdqweq', 'qweqwe', 'qweqwe', '2023-07-31'),
(15, 'John Doe', 'Penerbit A', '978-12345678901', 'Judul Buku A', '2022-01-15'),
(18, 'John Doe', 'Penerbit A', '978-123456789011', 'Judul Buku A', '2025-12-11'),
(19, 'wawan', 'wawan', 'wawan', 'wawan', '2023-07-31'),
(20, 'faris', 'faris', 'faris', 'faris', '2023-07-30'),
(22, 'faris12312', 'faris123123', 'farisqweqw', 'faris123123', '2023-07-27'),
(23, 'Rifqi', 'Ridwan', '10010018', 'komang', '2023-08-30');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `mahasiswa_id` int NOT NULL,
  `nim` varchar(100) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jurusan` varchar(100) DEFAULT NULL,
  `kelas` varchar(100) DEFAULT NULL,
  `nomortelepon` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `tanggallahir` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`mahasiswa_id`, `nim`, `nama`, `jurusan`, `kelas`, `nomortelepon`, `alamat`, `tanggallahir`) VALUES
(1, '20230001', 'Mahasiswa A', 'Teknik Informatika', 'TI-01', '081234567890', 'Jl. Contoh No. 1', '2000-05-10'),
(2, '20230002', 'Mahasiswa B', 'Sistem Informasi', 'SI-02', '087654321098', 'Jl. Percobaan No. 2', '1999-12-18'),
(3, '20230003', 'Mahasiswa C', 'Teknik Elektro', 'TE-03', '085678901234', 'Jl. Uji Coba No. 3', '2001-07-03'),
(4, '20230004', 'Mahasiswa D', 'Teknik Kimia', 'TK-04', '081122334455', 'Jl. Tes No. 4', '2002-10-22'),
(5, '20230005', 'Mahasiswa E', 'Teknik Industri', 'TI-05', '089876543210', 'Jl. Percobaan No. 5', '2000-08-08'),
(6, '20230006', 'Mahasiswa F', 'Akuntansi', 'AK-06', '082345678901', 'Jl. Uji Coba No. 6', '2001-01-30'),
(7, '20230007', 'Mahasiswa G', 'Manajemen', 'MN-07', '088765432109', 'Jl. Contoh No. 7', '1999-11-14'),
(8, '20230008', 'Mahasiswa H', 'Hukum', 'HK-08', '083434343434', 'Jl. Uji Coba No. 8', '2002-04-07'),
(9, '20230009', 'Mahasiswa I', 'Psikologi', 'PSI-09', '081234509876', 'Jl. Percobaan No. 9', '2001-09-29'),
(10, '20230010', 'Mahasiswa J', 'Teknik Mesin', 'TM-10', '085678906543', 'Jl. Contoh No. 10', '2003-02-11'),
(15, '2023001012', 'Mahasiswa Jq', 'Teknik Mesinqwe', 'TM-10qwe', '0856789065431123123', 'Jl. Contoh No. 10qweqwe', '1997-02-05'),
(16, '10122200043', 'Rangga', 'Teknik Informatika', 'IF-02', '087654342', 'Dago', '2001-08-04');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjam`
--

CREATE TABLE `peminjam` (
  `peminjam_id` int NOT NULL,
  `buku_id` int DEFAULT NULL,
  `mahasiswa_id` int DEFAULT NULL,
  `tanggalpeminjam` date DEFAULT NULL,
  `tanggalpengembalian` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `peminjam`
--

INSERT INTO `peminjam` (`peminjam_id`, `buku_id`, `mahasiswa_id`, `tanggalpeminjam`, `tanggalpengembalian`, `status`) VALUES
(21, 1, 2, '2023-07-05', '2023-07-20', 0),
(22, 3, 1, '2023-06-15', '2023-07-10', 1),
(24, 4, 5, '2023-07-10', '2023-07-25', 1),
(26, 6, 8, '2023-06-30', '2023-07-20', 1),
(29, 9, 4, '2023-07-03', '2023-07-17', 1),
(30, 10, 10, '2023-07-20', '2023-08-05', 0),
(31, 19, 1, '2023-07-30', '2023-07-31', 0),
(32, 20, 1, '2023-07-30', '2022-07-29', 1),
(33, 20, 10, '2023-07-30', '2026-07-31', 1),
(34, 23, 16, '2023-08-01', '2023-08-31', 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`anggota_id`),
  ADD UNIQUE KEY `user` (`user`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`buku_id`),
  ADD UNIQUE KEY `isbn` (`isbn`);

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`mahasiswa_id`),
  ADD UNIQUE KEY `nim` (`nim`);

--
-- Indeks untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  ADD PRIMARY KEY (`peminjam_id`),
  ADD KEY `buku_id` (`buku_id`),
  ADD KEY `mahasiswa_id` (`mahasiswa_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `anggota`
--
ALTER TABLE `anggota`
  MODIFY `anggota_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `buku_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `mahasiswa_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  MODIFY `peminjam_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  ADD CONSTRAINT `peminjam_ibfk_1` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`buku_id`),
  ADD CONSTRAINT `peminjam_ibfk_2` FOREIGN KEY (`mahasiswa_id`) REFERENCES `mahasiswa` (`mahasiswa_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
