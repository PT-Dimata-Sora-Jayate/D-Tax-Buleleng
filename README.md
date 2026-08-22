## Daftar Isi

- [PROJECT CONFIG](#project-config)
- [SETUP NETBEANS](#setup-netbeans)
- [DATABASE](#database)
- [DEPLOYMENT](#deployment)
- [BACKUP](#backup)

---

## Project Config

**Spesifikasi terkait Java dan Tomcat harus berpasangan**

**Spesifikasi Pertama**
* Java : jdk1.8.xx
* Tomcat : apche-tomcat-6.0.53

**Spesifikasi Kedua**
* Java : jdk1.7.xx atau jdk1.6.xx
* Tomcat : apche-tomcat-6.0.30

**Spesifikasi Database**
* Database : SQL Server

---

## Setup Netbeans

**PATH pos.xml : src/java/com/dimata/example_pos.xml**

1. Tambahkan Tomcat pada bagian server
2. Tambahkan Java pada Java Platform
3. Buat Project Baru dengan memilih Java Web dan Web Application with Existing Sources
4. Atur Server Setting dan Pengaturan Lanjutan
5. Pastikan kembali Source/Binary Format sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Sources)
6. Pastikan kembali Java Platform pada Libraries Project sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Libraries)
7. Pastikan kembali Server sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Run)
8. Atur pos.xml dengan memasukkan IP PUBLIC / Localhost diikuti dengan Port dan Nama Database serta masukkan kredensialnya (Sesuai contoh example_pos.xml)

---

## Database

Database sendiri merupakan milik dari BPKPD/BAKEUDA/Pemerintah Daerah. Dikarenakan data yang bersifat confidental dan sensitif, hingga saat repository ini diupdate/dibuat tidak diberikan kewenangan dan akses untuk melakukan dump baik struktur maupun data dari database yang digunakan oleh D-Tax

---

## Deployment

1. Lakukan proses Build pada Netbeans
2. Melakukan copy terhadap folder web/ pada direktori project/build/ source code project 
3. Melakukan paste pada direktori tomcat tepatnya pada folder webapps/
4. Rename kembali folder tersebut dengan nama sistem (dtaxintegration atau nama lainnya).

---

## Backup

**Jika sewaktu-waktu terdapat kendala pada proses pull github pada repository ini, sudah disiapkan backup berupa zip pada folder Serah Terima Galang pada One Drive Dimata / Google Drive Dimata.**
## Daftar Isi

- [PROJECT CONFIG](#project-config)
- [SETUP NETBEANS](#setup-netbeans)
- [DATABASE](#database)
- [DEPLOYMENT](#deployment)
- [BACKUP](#backup)

---

## Project Config

**Spesifikasi terkait Java dan Tomcat harus berpasangan**

**Spesifikasi Pertama**
* Java : jdk1.8.xx
* Tomcat : apche-tomcat-6.0.53

**Spesifikasi Kedua**
* Java : jdk1.7.xx atau jdk1.6.xx
* Tomcat : apche-tomcat-6.0.30

**Spesifikasi Database**
* Database : Oracle SQL

---

## Setup Netbeans

**PATH pos.xml : src/java/com/dimata/example_pos.xml**

1. Tambahkan Tomcat pada bagian server
2. Tambahkan Java pada Java Platform
3. Buat Project Baru dengan memilih Java Web dan Web Application with Existing Sources
4. Atur Server Setting dan Pengaturan Lanjutan
5. Pastikan kembali Source/Binary Format sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Sources)
6. Pastikan kembali Java Platform pada Libraries Project sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Libraries)
7. Pastikan kembali Server sesuai dengan kombinasi Java dan Tomcat yang digunakan (Klik Kanan Pada Project > Properties > Run)
8. Atur pos.xml dengan memasukkan IP PUBLIC / Localhost diikuti dengan Port dan Nama Database serta masukkan kredensialnya (Sesuai contoh example_pos.xml)

---

## Database

Database sendiri merupakan milik dari BPKPD/BAKEUDA/Pemerintah Daerah. Dikarenakan data yang bersifat confidental dan sensitif, hingga saat repository ini diupdate/dibuat tidak diberikan kewenangan dan akses untuk melakukan dump baik struktur maupun data dari database yang digunakan oleh D-Tax

---

## Deployment

1. Lakukan proses Build pada Netbeans
2. Melakukan copy terhadap folder web/ pada direktori project/build/ source code project 
3. Melakukan paste pada direktori tomcat tepatnya pada folder webapps/
4. Rename kembali folder tersebut dengan nama sistem (dtaxintegration atau nama lainnya).

---

## Backup

**Jika sewaktu-waktu terdapat kendala pada proses pull github pada repository ini, sudah disiapkan backup berupa zip pada folder Serah Terima Galang pada One Drive Dimata / Google Drive Dimata.**
