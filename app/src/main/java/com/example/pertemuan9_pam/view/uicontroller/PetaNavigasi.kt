package com.example.pertemuan9_pam.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan9_pam.DetailSiswaScreen
import com.example.pertemuan9_pam.view.EntrySiswaScreen
import com.example.pertemuan9_pam.view.HomeScreen
import com.example.pertemuan9_pam.view.route.DestinasiDetaillSiswa
import com.example.pertemuan9_pam.view.route.DestinasiDetaillSiswa.itemIdArg
import com.example.pertemuan9_pam.view.route.DestinasiEntry
import com.example.pertemuan9_pam.view.route.DestinasiHome

@Composable
fun SiswaApp(
	navController: NavHostController = rememberNavController(),
	modifier: Modifier
){
	HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
	navController: NavHostController,
	modifier: Modifier = Modifier
){
	NavHost(
		navController = navController, startDestination = DestinasiHome.route,
		modifier = modifier
	) {
		composable(DestinasiHome.route) {
			HomeScreen(
				navigateToItemEntry = {
					navController.navigate(DestinasiEntry.route)
				},
				navigateToItemUpdate = {
					navController.navigate("${DestinasiDetaillSiswa.route}/${it}")
				}
			)
		}

		composable(DestinasiEntry.route) {
			EntrySiswaScreen(
				navigateBack = { navController.popBackStack() }
			)
		}
		composable(
			route = DestinasiDetaillSiswa.routeWithArgs,
			arguments = listOf(navArgument(itemIdArg) {
				type = NavType.IntType
			})
		) {
			DetailSiswaScreen(
				navigateToEditItem = { navController.navigate("${DestinasiEditSiswa.route}/$it")},
				navigateBack = {navController.navigateUp() })
		}
		composable (route = DestinasiEditSiswa.routeWithArgs,
			arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg){
				type= NavType.IntType })){
			EditSiswaScreen(
				navigateBack = {navController.popBackStack()},
				onNavigateUp = {navController.navigateUp()})
		}
	}
}
