package com.example.pertemuan9_pam.view.route

interface DestinasiNavigasi {
	/**
	 * Nama unik untuk menentukan jalur untuk composable
	 */

	val route : String

	/**
	 * String resource id yang berisi judul yang akan di tampilkan halaman
	 */

	val titleRes: Int
}
