package com.example.e_commerce_watch_store_ui.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_watch_store_ui.R
import com.example.e_commerce_watch_store_ui.model.CategoryViewPager
import com.example.e_commerce_watch_store_ui.ui.theme.BluePrimary
import com.example.e_commerce_watch_store_ui.ui.theme.ColorInActivePager

@Composable
fun ViewPagerItem(
	modifier: Modifier = Modifier,
	isSelected: Boolean,
	item: CategoryViewPager
) {
	Column(modifier = modifier) {
		Text(
			text = item.name,
			color = if (isSelected) BluePrimary else ColorInActivePager,
			fontFamily = FontFamily(Font(R.font.raleway_bold)),
			fontSize = 16.sp
		)
		Spacer(modifier = modifier.padding(top = 6.dp))

		if (isSelected) {
			HorizontalDivider(
				modifier = modifier.width(20.dp), color = BluePrimary, thickness = 1.dp
			)
		}
	}

}

@Preview(showBackground = true)
@Composable
private fun ViewPagerItemPrev() {
	ViewPagerItem(isSelected = true, item = CategoryViewPager(name = "Test"))

}