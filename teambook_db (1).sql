-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 25 Mei 2015 pada 11.35
-- Versi Server: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `teambook_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE IF NOT EXISTS `akun` (
`id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `provinsi` varchar(200) NOT NULL,
  `kota` varchar(200) NOT NULL,
  `kode_pos` varchar(11) NOT NULL,
  `alamat_shipping` varchar(1000) NOT NULL,
  `alamat_default` varchar(1000) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`id`, `nama`, `password`, `email`, `phone`, `provinsi`, `kota`, `kode_pos`, `alamat_shipping`, `alamat_default`, `isAdmin`) VALUES
(2, 'admin', 'admin', 'admin@teambook.com', '0', '', '', '0', '0', '', 1),
(3, 'ulil', '1234', 'ulil@ulil.com', '0', '', '', '0', '0', '', 0),
(11, 'afifun', '1234', 'afifun@gmail.com', '123123123', 'jawa barat', 'depok', '16424', 'Fakultas Ilmu Komputer Universitas Indonesia', 'Fakultas Ilmu Komputer Universitas Indonesia', 0),
(12, 'ajanfasdf', 'aifdifasdf', 'adfda@sdjfna.com', '123123123', 'gskglksmdg', 'nsnfjgnsg', 'snglksjdng', 'lsnmglskmg', 'sjnfjgnsjdfgnsjkld', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bukti_transfer`
--

CREATE TABLE IF NOT EXISTS `bukti_transfer` (
`id` int(11) NOT NULL,
  `id_checkout` bigint(20) NOT NULL,
  `gambar_path` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
`id` int(11) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `judul` varchar(200) DEFAULT NULL,
  `author` varchar(200) NOT NULL,
  `penerbit` varchar(200) NOT NULL,
  `publish_date` date NOT NULL,
  `kategori` varchar(100) DEFAULT NULL,
  `deskripsi` varchar(500) DEFAULT NULL,
  `gambar` text NOT NULL,
  `harga` double NOT NULL,
  `stok` int(11) NOT NULL,
  `berat` double NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id`, `isbn`, `judul`, `author`, `penerbit`, `publish_date`, `kategori`, `deskripsi`, `gambar`, `harga`, `stok`, `berat`) VALUES
(1, '19872019281', 'Bahasa Indonesia', 'afifun', 'afifun', '2015-04-10', 'Non Fiksi', 'Buku ini merupakan buku bahasa indonesia', 'images/buku/19872019281.jpg', 48000, 0, 0),
(2, '89798712018281', 'Matematika', 'adas', 'asdasd', '2015-04-15', 'Non Fiksi', 'Buku ini merupakan buku matematika', 'images/buku/89798712018281.jpg', 75000, 0, 0),
(3, '12987192837198', 'Laskar Pelangi', 'afifun', 'afifun', '2015-04-18', 'Fiksi', 'Buku ini merupakan buku Novel Laskar Pelangi', 'images/buku/12987192837198.jpg', 90000, 0, 0),
(6, '1231231234121', 'mkamdaaf', 'adfadf', 'afadf', '2015-05-17', 'Fiksi', 'adfadfa', 'images/buku/1231231234121.jpg', 1000000, 12, 12.3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku_keranjang`
--

CREATE TABLE IF NOT EXISTS `buku_keranjang` (
`id` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `id_keranjang` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku_order`
--

CREATE TABLE IF NOT EXISTS `buku_order` (
`id` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `id_checkout` bigint(20) NOT NULL,
  `kuantitas` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data untuk tabel `buku_order`
--

INSERT INTO `buku_order` (`id`, `id_buku`, `id_checkout`, `kuantitas`) VALUES
(17, 1, 111654226150, 1),
(18, 2, 111654226150, 1),
(19, 2, 111432474606180, 1),
(20, 3, 111432474606180, 1),
(21, 1, 111432474829411, 1),
(22, 2, 111432474829411, 1),
(23, 3, 111432474829411, 1),
(24, 2, 31432480480840, 1),
(25, 6, 31432480480840, 1),
(26, 1, 31432480480840, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `checkout`
--

CREATE TABLE IF NOT EXISTS `checkout` (
  `id` bigint(20) NOT NULL DEFAULT '123123',
  `id_akun` int(11) NOT NULL,
  `nama_kurir` varchar(100) NOT NULL,
  `jenis_paket` varchar(100) NOT NULL,
  `biaya_pengiriman` double NOT NULL,
  `bank` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `keranjang`
--

CREATE TABLE IF NOT EXISTS `keranjang` (
`id_keranjang` int(11) NOT NULL,
  `id_akun` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `keranjang`
--

INSERT INTO `keranjang` (`id_keranjang`, `id_akun`) VALUES
(2, 2),
(3, 3),
(5, 11),
(6, 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `bukti_transfer`
--
ALTER TABLE `bukti_transfer`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku_keranjang`
--
ALTER TABLE `buku_keranjang`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku_order`
--
ALTER TABLE `buku_order`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
 ADD PRIMARY KEY (`id_keranjang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `bukti_transfer`
--
ALTER TABLE `bukti_transfer`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `buku_keranjang`
--
ALTER TABLE `buku_keranjang`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `buku_order`
--
ALTER TABLE `buku_order`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `keranjang`
--
ALTER TABLE `keranjang`
MODIFY `id_keranjang` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
