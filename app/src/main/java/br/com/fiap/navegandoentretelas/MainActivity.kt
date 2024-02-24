package br.com.fiap.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
                   val navController = rememberNavController()

                    // Função NavHost, responsável por gerenciar as rotas de telas
                    NavHost(
                        navController = navController,
                        startDestination = "login" // Tela que será aberta na primeira vez
                    ){
                        // Destinos navegáveis
                        composable(route = "login"){ LoginScreen() } // login: identificador único para cada destino
                        composable(route = "menu"){ MenuScreen() }
                        composable(route = "pedidos"){ PedidosScreen() }
                        composable(route = "perfil"){ PerfilScreen() }
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