package com.example.e_commerce_watch_store_ui.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_watch_store_ui.R

@Composable
fun SearchBarView(modifier: Modifier = Modifier) {
	Row(
		modifier = modifier.fillMaxWidth()
	) {
		Image(
			modifier = modifier.align(Alignment.CenterVertically),
			imageVector = Icons.Default.Menu, contentDescription = "Menu Icon"
		)
		OutlinedTextField(
			modifier = modifier
				.padding(start = 56.dp)
				.weight(1f)
				.height(48.dp),
			shape = RoundedCornerShape(32.dp),
			leadingIcon = {
				Icon(
					modifier = modifier.size(20.dp),
					imageVector = Icons.Default.Search,
					contentDescription = "Search Icon"
				)
			},
			placeholder = {
				Text(
					text = "Search Product",
					color = Color.Gray,
					fontSize = 12.sp,
					fontFamily = FontFamily(Font(R.font.raleway_light))
				)
			},
			value = "Search Product", onValueChange = {})
	}
}

@Preview(showBackground = true)
@Composable
private fun SearchBarViewPreview() {
	SearchBarView()

}