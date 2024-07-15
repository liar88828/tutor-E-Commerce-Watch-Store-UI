package com.example.e_commerce_watch_store_ui.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_watch_store_ui.R
import com.example.e_commerce_watch_store_ui.data.itemsViewPager
import com.example.e_commerce_watch_store_ui.data.watchItems
import com.example.e_commerce_watch_store_ui.ui.component.SearchBarView
import com.example.e_commerce_watch_store_ui.ui.component.ViewPagerItem
import com.example.e_commerce_watch_store_ui.ui.component.WatchCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	navHostController: NavHostController
) {
	val pagerState = rememberPagerState { itemsViewPager.size }

	Surface(modifier = Modifier.fillMaxSize()) {
		Column(
			modifier = modifier
				.padding(
					horizontal = 32.dp,
				)
				.padding(top = 10.dp)
		) {
			Spacer(modifier = modifier.padding(top = 32.dp))
			SearchBarView()
			Spacer(modifier = modifier.padding(top = 32.dp))
			Column() {
				Text(
					text = "Find your suitable",
					fontSize = 38.sp,
					fontFamily = FontFamily(Font(R.font.raleway_bold))
				)
				Text(
					text = "watch now",
					fontSize = 38.sp,
					fontFamily = FontFamily(Font(R.font.raleway_bold))
				)

				HorizontalPager(
					modifier = modifier.padding(top = 36.dp),
					state = pagerState
				) {
					LazyRow(
						horizontalArrangement = Arrangement.spacedBy(20.dp)
					) {
						items(itemsViewPager) { categoryViewPager ->
							ViewPagerItem(
								isSelected = pagerState.currentPage == itemsViewPager.indexOf(
									categoryViewPager
								),
								item = categoryViewPager
							)
						}
					}
				}
//				Watch Card item
				LazyVerticalGrid(
					columns = GridCells.Fixed(2),
					contentPadding = PaddingValues(bottom = 40.dp, top = 20.dp),
					verticalArrangement = Arrangement.spacedBy(20.dp),
					horizontalArrangement = Arrangement.spacedBy(20.dp)
				) {
					items(watchItems) { watch ->
						WatchCard(watch = watch,
							onClick = { navHostController.navigate("detail") }
						)
					}
				}
			}
		}
	}

}

@Preview
@Composable
private fun HomeScreenPreview() {
	HomeScreen(navHostController = rememberNavController())
}