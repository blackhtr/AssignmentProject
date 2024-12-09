package com.trheo.assignmentproject.wiki

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.trheo.assignmentproject.wiki.ui.HomeScreen
import com.trheo.assignmentproject.wiki.ui.ImageDetailScreen
import com.trheo.assignmentproject.wiki.ui.SearchResultScreen
import com.trheo.assignmentproject.wiki.ui.WikiDetailScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        // 홈 화면
        composable(Screen.Home.route) {
            HomeScreen(onSearch = {

            })
        }

        // 검색 결과 화면
        /*composable(
            route = Screen.SearchResult.route + "?query={query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            val viewModel: SearchViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            LaunchedEffect(query) {
                viewModel.search(query) // 검색어로 데이터 요청
            }
            SearchResultScreen(
                searchResults = state.results,
                onImageClick = { result ->
                    // 이미지 클릭 시 이미지 상세 화면으로 이동
                    navController.navigate(
                        Screen.ImageDetail.createRoute(
                            user = result.title,
                            tags = result.tags.joinToString(","),
                            width = 1920,  // 예시 값
                            height = 1080, // 예시 값
                            views = 1000,  // 예시 값
                            downloads = 500, // 예시 값
                            imageUrl = result.imageUrl ?: ""
                        )
                    )
                },
                onWikiClick = { result ->
                    // 위키 데이터 클릭 시 위키 상세 화면으로 이동
                    navController.navigate(
                        Screen.WikiDetail.createRoute(
                            title = result.title,
                            description = result.description,
                            imageUrl = result.imageUrl,
                            sourceUrl = result.sourceUrl
                        )
                    )
                }
            )
        }

        // 위키 상세 화면
        composable(
            route = Screen.WikiDetail.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType; nullable = true },
                navArgument("sourceUrl") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            WikiDetailScreen(
                title = backStackEntry.arguments?.getString("title") ?: "",
                description = backStackEntry.arguments?.getString("description") ?: "",
                imageUrl = backStackEntry.arguments?.getString("imageUrl"),
                sourceUrl = backStackEntry.arguments?.getString("sourceUrl") ?: "",
                onKeywordClick = { keyword ->
                    // 키워드 클릭 시 검색 결과 화면으로 이동
                    navController.navigate(Screen.SearchResult.route + "?query=$keyword")
                }
            )
        }

        // 이미지 상세 화면
        composable(
            route = Screen.ImageDetail.route,
            arguments = listOf(
                navArgument("user") { type = NavType.StringType },
                navArgument("tags") { type = NavType.StringType },
                navArgument("width") { type = NavType.IntType },
                navArgument("height") { type = NavType.IntType },
                navArgument("views") { type = NavType.IntType },
                navArgument("downloads") { type = NavType.IntType },
                navArgument("imageUrl") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            ImageDetailScreen(
                user = backStackEntry.arguments?.getString("user") ?: "",
                tags = backStackEntry.arguments?.getString("tags")?.split(",") ?: emptyList(),
                size = Pair(
                    backStackEntry.arguments?.getInt("width") ?: 0,
                    backStackEntry.arguments?.getInt("height") ?: 0
                ),
                views = backStackEntry.arguments?.getInt("views") ?: 0,
                downloads = backStackEntry.arguments?.getInt("downloads") ?: 0,
                imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""
            )
        }*/
    }
}