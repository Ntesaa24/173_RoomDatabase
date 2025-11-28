package com.example.pertemuan9_pam.repositori

import com.example.pertemuan9_pam.room.Siswa
import com.example.pertemuan9_pam.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface  RepositoriSiswa {
	fun getAllSiswaStream(): Flow<List<Siswa>>
	suspend fun insertSiswa(siswa: Siswa)
}

