package br.com.fiap.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import br.com.fiap.navegandoentretelas.screens.LoginScreen
import br.com.fiap.navegandoentretelas.screens.MenuScreen
import br.com.fiap.navegandoentretelas.screens.PedidosScreen
import br.com.fiap.navegandoentretelas.screens.PerfilScreen
import br.com.fiap.navegandoentretelas.ui.theme.NavegandoEntreTelasTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
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
                    val navController = rememberAnimatedNavController()

                    // Função AnimatedNavHost, responsável por gerenciar as rotas e as transições de telas
                    AnimatedNavHost(
                        navController = navController, // parâmetro da classe NavHostController. Guarda o histórico de navegação.
                        startDestination = "login", // Tela que será aberta na primeira vez da aplicação (default)
                        exitTrasition = {
                            slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.Start,
                                animationSpec = tween(3000)
                            )
                        }
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
                        /*
                        Sobre os Argumentos, leia-se: "Quem quiser acionar a rota
                        deverá passar os argumentos na chamada para poder ser recuperado e utilizados".
                         */
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") {
                                    type = NavType.StringType
                                },
                                navArgument("idade") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            var nome: String? = it.arguments?.getString("nome", "")
                            var idade: Int? = it.arguments?.getInt("idade", 0)
                            // Chamada da função PerfilScreen para a tela de perfil
                            PerfilScreen(
                                navController,
                                nome!!,
                                idade!!
                            ) // !! -> operador de não nulo (double bang)
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