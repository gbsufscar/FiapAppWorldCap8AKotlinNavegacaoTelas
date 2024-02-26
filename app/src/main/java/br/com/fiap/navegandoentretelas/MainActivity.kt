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
import androidx.navigation.navArgument
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

                        // Rota para a tela de login
                        composable(route = "login") {
                            LoginScreen(navController = navController)
                        }

                        // Rota para a tela de menu
                        composable(route = "menu") {
                            MenuScreen(navController = navController)
                        }

                        // Rota para a tela de pedidos
                        /*
                        Argumentos opcionais. Exemplo: pedidos?numero=5656. Não passando valor para o número, será exibido "sem valor".
                        Argumento número recebido da tela de menu quando o botão pedidos for clicado.
                        listOf -> lista de argumentos. Um deles é o número do pedido que será recebido.
                         */
                        composable(route = "pedidos?numero={numero}",
                            arguments = listOf(navArgument(name = "numero") {
                                defaultValue = "sem valor" // valor padrão
                            }
                            )
                        ) {
                            PedidosScreen(
                                navController = navController,
                                numero = it.arguments?.getString("numero")!!
                            )
                        }

                        // Rota para a tela de perfil
                        composable(route = "perfil/{nome}") {
                            // variável nome que será recebido quando o botão perfil da tela de menu for clicado
                            var nome: String? =
                                it.arguments?.getString( // it -> argumento recebido na tela de menu
                                    "nome",
                                    ""
                                )

                            // Chamada da função PerfilScreen para a tela de perfil
                            PerfilScreen(
                                navController = navController,
                                nome = nome!!
                            ) // !! -> operador de não nulo (double bang)
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