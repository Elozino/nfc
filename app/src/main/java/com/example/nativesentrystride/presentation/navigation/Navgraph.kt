package com.example.nativesentrystride.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nativesentrystride.presentation.auth.Login
import com.example.nativesentrystride.presentation.scan.Scan

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {
        composable(route = "Login") {
            Login(navController)
        }

        composable(route = "Scan") {
            Scan(navController)
        }
    }

}

