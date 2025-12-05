package com.example.pertemuan9_pam.view.route

import com.example.pertemuan9_pam.R

object DestinasiDetaillSiswa: DestinasiNavigasi{
	override val route = "detail_siswa"
	override val titleRes = R.string.detail_siswa
	const val itemIdArg = "idSiswa"
	val routeWithArgs = "$route/{$itemIdArg}"

}
