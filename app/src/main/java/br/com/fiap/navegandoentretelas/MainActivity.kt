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
                    // Instância a função rememberNavController(). Guarda o histórico de navegação.
                    val navController =
                        rememberNavController() // variável da classe NavHostController (val -> constante)

                    // Função NavHost, responsável por gerenciar as rotas de telas
                    NavHost(
                        navController = navController, // parâmetro da classe NavHostController. Guarda o histórico de navegação.
                        startDestination = "login" // Tela que será aberta na primeira vez da aplicação (default)
                    ) {
                        // Destinos navegáveis
                        // -- route: identificador único para cada destino. navController: parâmetro da classe NavController
                        composable(route = "login") {
                            LoginScreen(navController = navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(navController = navController)
                        }
                        composable(route = "pedidos") {
                            PedidosScreen(navController = navController)
                        }
                        composable(route = "perfil/{nome}") {
                            // variável nome que será recebido quando o botão perfil da tela de menu for clicado
                            var nome: String? = it.arguments?.getString("nome", "") // it -> argumento recebido na tela de perfil

                            // Chamada da função PerfilScreen para a tela de perfil
                            PerfilScreen(
                                navController = navController,
                                nome = nome!!) // !! -> operador de não nulo (double bang)
                        }
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavegandoEntreTelasTheme {
        /* TODO */
    }
}

 */