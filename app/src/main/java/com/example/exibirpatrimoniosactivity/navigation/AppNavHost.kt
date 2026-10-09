package com.example.exibirpatrimoniosactivity.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.exibirpatrimoniosactivity.data.PatrimonioMock
import com.example.exibirpatrimoniosactivity.ui.components.BarItem
import com.example.exibirpatrimoniosactivity.ui.components.InvScanBottomBar
import com.example.exibirpatrimoniosactivity.ui.components.InvScanTopBar
import com.example.exibirpatrimoniosactivity.ui.screens.InicioScreen
import com.example.exibirpatrimoniosactivity.ui.screens.PatrimonioScreen
import com.example.exibirpatrimoniosactivity.ui.screens.PerfilScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val rotaAtual = backStackEntry?.destination?.route

    // Itens da barra inferior. "Itens" abre o primeiro patrimônio da lista.
    val itensBarra = remember {
        listOf(
            BarItem(
                rotaPadrao = Rotas.Patrimonio.rota,
                destino = Rotas.Patrimonio.criar(PatrimonioMock.lista.first().id),
                icone = Icons.Default.Menu,
                descricao = "Itens"
            ),
            BarItem(
                rotaPadrao = Rotas.Inicio.rota,
                destino = Rotas.Inicio.rota,
                icone = Icons.Default.Home,
                descricao = "Início"
            ),
            BarItem(
                rotaPadrao = Rotas.Perfil.rota,
                destino = Rotas.Perfil.rota,
                icone = Icons.Default.Apps,
                descricao = "Perfil"
            )
        )
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            InvScanTopBar(
                mensagem = if (rotaAtual == Rotas.Inicio.rota) "Seja bem-vindo!!" else null
            )
        },
        bottomBar = {
            InvScanBottomBar(
                itens = itensBarra,
                rotaAtual = rotaAtual,
                onNavigate = { destino -> navController.navegarPelaBarra(destino) }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rotas.Inicio.rota,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Rotas.Inicio.rota) {
                InicioScreen(
                    onPatrimonioClick = { id ->
                        navController.navigate(Rotas.Patrimonio.criar(id))
                    }
                )
            }

            composable(
                route = Rotas.Patrimonio.rota,
                arguments = listOf(
                    navArgument(ARG_ID_PATRIMONIO) { type = NavType.IntType }
                )
            ) { entry ->
                val id = entry.arguments?.getInt(ARG_ID_PATRIMONIO)
                PatrimonioScreen(patrimonio = id?.let { PatrimonioMock.buscarPorId(it) })
            }

            composable(Rotas.Perfil.rota) {
                PerfilScreen()
            }
        }
    }
}

/** Navegação de barra inferior: não empilha telas repetidas e preserva o estado. */
private fun NavHostController.navegarPelaBarra(destino: String) {
    navigate(destino) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}
