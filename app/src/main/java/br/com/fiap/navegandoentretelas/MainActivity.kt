package br.com.fiap.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.navegandoentretelas.screens.LoginScreen
import br.com.fiap.navegandoentretelas.screens.MenuScreen
import br.com.fiap.navegandoentretelas.screens.PedidosScreen
import br.com.fiap.navegandoentretelas.screens.PerfilScreen
import br.com.fiap.navegandoentretelas.ui.theme.NavegandoEntreTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegandoEntreTelasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Instância a função rememberNavController()
                   val navController = rememberNavController() // variável da classe NavHostController

                    // Função NavHost, responsável por gerenciar as rotas de telas
                    NavHost(
                        navController = navController,
                        startDestination = "login" // Tela que será aberta na primeira vez da aplicação (default)
                    ){
                        // Destinos navegáveis
                        // -- route: identificador único para cada destino. navController: parâmetro da classe NavController
                        composable(route = "login"){ LoginScreen(navController = navController) }
                        composable(route = "menu"){ MenuScreen(navController = navController) }
                        composable(route = "pedidos"){ PedidosScreen(navController = navController) }
                        composable(route = "perfil"){ PerfilScreen(navController = navController) }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavegandoEntreTelasTheme {
        /* TODO */
    }
}