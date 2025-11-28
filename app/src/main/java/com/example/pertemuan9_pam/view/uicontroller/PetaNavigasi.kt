package com.example.pertemuan9_pam.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan9_pam.view.EntrySiswaScreen
import com.example.pertemuan9_pam.view.HomeScreen
import com.example.pertemuan9_pam.view.route.DestinasiEntry
import com.example.pertemuan9_pam.view.route.DestinasiHome

@Composable
fun SiswaApp(
	navController: NavHostController = rememberNavController(),
	modifier: Modifier
){
	HostNavigasi(navController = navController)
}


