package com.example.pertemuan9_pam.view.route

import com.example.pertemuan9_pam.R

object DestinasiEditSiswa : DestinasiNavigasi{
	override val route = "item_edit"
	override val titleRes = R.string.edit_siswa
	const val itemIdArg = "idSiswa"
	val routeWithArgs = "$route/{$itemIdArg}"
}
