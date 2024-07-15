package com.example.e_commerce_watch_store_ui.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e_commerce_watch_store_ui.R
import com.example.e_commerce_watch_store_ui.model.Watch
import com.example.e_commerce_watch_store_ui.ui.theme.BluePrimary
import com.example.e_commerce_watch_store_ui.ui.theme.Grey

@Composable
fun WatchCard(
	modifier: Modifier = Modifier,
	watch: Watch,
	onClick: () -> Unit
) {
	Surface(
		modifier = modifier
			.wrapContentSize()
			.clickable { onClick() },
		tonalElevation = 10.dp,
		shadowElevation = 8.75.dp,
		shape = RoundedCornerShape(14.dp),
		color = Color.White
	) {
		Column(modifier = modifier.padding(8.dp)) {
			Image(
				modifier = modifier
					.fillMaxWidth()
					.height(100.dp),
				painter = painterResource(id = watch.image),
				contentDescription = "Image watch"
			)
			Text(
				modifier = modifier.padding(top = 16.dp),
				text = watch.name,
				fontFamily = FontFamily(Font(R.font.raleway_semibold))
			)
			Text(
				modifier = modifier.padding(top = 8.dp),
				text = watch.type,
				fontFamily = FontFamily(Font(R.font.raleway_medium)),
				color = Grey
			)
			Text(
				modifier = modifier.padding(top = 10.dp),
				text = watch.price,
				fontFamily = FontFamily(Font(R.font.raleway_medium)), color = BluePrimary,
//				fontWeight = FontWeight.Bold
			)
		}
	}

}

@Preview(showBackground = true)
@Composable
private fun WatchCardPrev() {
	WatchCard(
		watch =
		Watch(
			name = "Image Watch",
			price = "200",
			type = "Electronic",
			image = R.drawable.img_watch_1,
			),
		onClick = {}
	)
}