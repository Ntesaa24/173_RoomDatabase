package com.example.pertemuan9_pam.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pertemuan9_pam.repositori.RepositoriSiswa
import com.example.pertemuan9_pam.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel()
{
	/**
	 * Berisi status Siswa saat ini
	 */
	var uiStateSiswa by mutableStateOf(UIStateSiswa())
		private set
	private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean
	{
		return with(uiState) {
			nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
		}
	}

fun updateUIState(detailSiswa: DetailSiswa){
	uiStateSiswa =
		UIStateSiswa(detailSiswa = detailSiswa, isEntryValid =
		validasiInput(detailSiswa))
}

/** Fungsi untuk menyimpan data yang di-entry*/
suspend fun saveSiswa(){
	if (validasiInput()){
		repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
	}
}
}

/**
* mewaikili Status UI untuk siswa
*/

data class UIStateSiswa(
val detailSiswa: DetailSiswa = DetailSiswa(),
val isEntryValid: Boolean = false
)

data class DetailSiswa(
val id : Int = 0,
val nama: String = "",
val alamat: String = "",
val telpon: String = "",
)

/** Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */

fun DetailSiswa.toSiswa(): Siswa = Siswa(
id = id,
nama = nama,
alamat = alamat,
telpon = telpon
)

fun Siswa.toUIStateSiswa(isEntryValid: Boolean = false): UIStateSiswa =
UIStateSiswa(
	detailSiswa = this.toDetailSiswa(),
	isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
id = id,
nama = nama,
alamat = alamat,
telpon = telpon
)
