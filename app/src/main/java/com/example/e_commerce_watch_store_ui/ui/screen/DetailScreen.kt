package com.example.e_commerce_watch_store_ui.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_watch_store_ui.R
import com.example.e_commerce_watch_store_ui.model.CategoryViewPager
import com.example.e_commerce_watch_store_ui.ui.component.ViewPagerItem
import com.example.e_commerce_watch_store_ui.ui.theme.BluePrimary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier,onClickBack: () -> Unit) {
	val itemsViewPager = listOf(
		CategoryViewPager(name = "Detail"),
		CategoryViewPager(name = "Review")
	)
	val pagerState = rememberPagerState {
		itemsViewPager.size
	}
	val buttonGradient = Brush.verticalGradient(
		colors = listOf(
			Color(0xFF9575CD),
			Color(0xFF673AB7),
		)
	)

	Surface(modifier = modifier) {
		Column(
			modifier = modifier
				.fillMaxSize()
				.padding(top = 24.dp)
		) {
			TopBar(
				modifier = modifier
					.padding(horizontal = 16.dp, vertical = 16.dp),
				onClickBack = onClickBack
			)

			Image(
				modifier = modifier
					.fillMaxWidth()
					.height(320.dp)
					.padding(top = 16.dp),
				painter = painterResource(id = R.drawable.img_detail_screen),
				contentDescription = "Image Detail"
			)

			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Column(modifier = modifier.weight(1f)) {
					Text(
						text = "Apple Watch Series 7",
						fontFamily = FontFamily(Font(R.font.raleway_bold)),
						fontSize = 20.sp
					)
					Text(
						modifier = modifier.padding(top = 6.dp),
						text = "(With solo loop)",
						fontFamily = FontFamily(Font(R.font.raleway_light)),
						fontSize = 12.sp
					)
				}
				Text(
					text = "$445",
					fontFamily = FontFamily(Font(R.font.raleway_bold)),
					color = BluePrimary,
					fontSize = 24.sp
				)
			}


			HorizontalPager(
				state = pagerState,
				modifier = modifier
					.padding(top = 36.dp)
					.padding(horizontal = 16.dp)
			) {
				LazyRow(
					horizontalArrangement = Arrangement.spacedBy(20.dp)
				) {
					items(itemsViewPager) { categoryViewPager ->
						ViewPagerItem(
							isSelected = pagerState.currentPage == itemsViewPager.indexOf(
								categoryViewPager
							), item = categoryViewPager
						)
					}
				}
			}
//			Description
			Spacer(
				modifier = modifier
					.height(8.dp)
			)
			Column(
				modifier = modifier.padding(horizontal = 16.dp),
				verticalArrangement = Arrangement.spacedBy(50.dp)
			) {
				Text(
					text = "Ac venenatis iaculis faucibus ultrices magnis nullam. \n" +
							"Primis mus sit lacus risus. \n" +
							"Tincidunt blandit semper mollis pharetra diam.",
					fontFamily = FontFamily(Font(R.font.raleway_light))
				)
				Button(
					onClick = {},
					modifier = modifier
						.fillMaxWidth()
						.background(
							brush = buttonGradient,
							shape = RoundedCornerShape(8.dp)
						),
					colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
				) {
					Text(text = "Add to Cart")
				}
			}
		}
	}
}

@Composable
fun TopBar(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
	Row(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Image(
			modifier = modifier.clickable { onClickBack() },
			imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Icon back"
		)
		Image(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Icon favorite")
	}

}

@Preview
@Composable
private fun DetailScreenPrev() {
	DetailScreen(onClickBack = {})

}