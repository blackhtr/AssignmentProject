package com.trheo.assignmentproject.wiki

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
import com.trheo.assignmentproject.wiki.viewmodel.SearchViewModel
import com.trheo.assignmentproject.wiki.viewmodel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    sharedViewModel: SharedViewModel = hiltViewModel()){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        // 홈 화면
        composable(Screen.Home.route) {
            HomeScreen { query ->
                navController.navigate(Screen.SearchResult.route + "?query=$query")
            }
        }

        // 검색 결과 화면
        composable(
            route = Screen.SearchResult.route + "?query={query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("검색 결과") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                            }
                        }
                    )
                },
                content = { paddingValues -> // paddingValues를 통해 상단 패딩 적용
                    Box(modifier = Modifier.padding(paddingValues)) {
                        val query = backStackEntry.arguments?.getString("query") ?: ""
                        SearchResultScreen(
                            query = query,
                            onImageClick = { result ->
                                sharedViewModel.setImageDetail(result)
                                navController.navigate(Screen.ImageDetail.route)
                            },
                            onWikiClick = { result ->
                                sharedViewModel.setWikiDetail(result)
                                navController.navigate(Screen.WikiDetail.route)
                            }
                        )
                    }
                }
            )

        }

        // 위키 상세 화면
        composable(route = Screen.WikiDetail.route) { backStackEntry ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("위키 상세") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                            }
                        }
                    )
                },
                content = { paddingValues -> // paddingValues를 통해 상단 패딩 적용
                    Box(modifier = Modifier.padding(paddingValues)) {
                        val wikiDetail by sharedViewModel.wikiDetail.collectAsState()
                        wikiDetail?.let{
                            WikiDetailScreen(
                                info = it,
                                onKeywordClick = { keyword ->
                                    // 키워드 클릭 시 검색 결과 화면으로 이동
                                    navController.popBackStack() // 현재 화면 종료
                                    navController.navigate(Screen.SearchResult.route + "?query=$keyword")
                                }
                            )
                        }
                    }
                }
            )
        }
        // ImageDetail 화면
        composable(Screen.ImageDetail.route) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("이미지 상세") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                            }
                        }
                    )
                },
                content = { paddingValues -> // paddingValues를 통해 상단 패딩 적용
                    Box(modifier = Modifier.padding(paddingValues)) {
                        val imageDetail by sharedViewModel.imageDetail.collectAsState()
                        imageDetail?.let { detail ->
                            ImageDetailScreen(info = detail, onTagClick = {
                                navController.popBackStack() // 현재 화면 종료
                                navController.navigate(Screen.SearchResult.route + "?query=$it")
                            })
                        }
                    }
                }
            )

        }
    }
}