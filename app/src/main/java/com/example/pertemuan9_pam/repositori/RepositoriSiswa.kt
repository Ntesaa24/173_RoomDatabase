package com.example.pertemuan9_pam.repositori

import com.example.pertemuan9_pam.room.Siswa
import com.example.pertemuan9_pam.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface  RepositoriSiswa {
	fun getAllSiswaStream(): Flow<List<Siswa>>
	suspend fun insertSiswa(siswa: Siswa)
	//edit 1 tambah 3 fungsi berikut
	fun getSiswaStream(id: Int): Flow<Siswa?>
	suspend fun deleteSiswa(siswa: Siswa)
	suspend fun updateSiswa(siswa: Siswa)
}

class OffLinedRepositoriSiswa(
	private val  siswaDao: SiswaDao
): RepositoriSiswa {
	override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
	override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

	//edit 2 tambah 3 overide berikut
	override fun getSiswaStream(id: Int): Flow<Siswa?> =siswaDao.getSiswa(id)
	override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
	override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
	}
