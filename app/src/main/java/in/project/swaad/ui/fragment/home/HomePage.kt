package `in`.project.swaad.ui.fragment.home

import `in`.project.swaad.R
import `in`.project.swaad.ui.PopularCurationsDataClass
import `in`.project.swaad.ui.theme.Black
import `in`.project.swaad.ui.theme.CardTextColor
import `in`.project.swaad.ui.theme.Mulish
import `in`.project.swaad.ui.theme.Poppins
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun HomePage(navController: NavController? = null) {
	ConstraintLayout(Modifier
						 .fillMaxWidth()
						 .background(Color.White)
						 .verticalScroll(rememberScrollState())) {
		val (icLocation, location,
			textField, popularCreationsTxt,
			popularCreationsLazy, recommendedTxt,
		recommendedLazy) = createRefs()

		Icon(painter = painterResource(id = R.drawable.ic_location), contentDescription = null,
			 modifier = Modifier.constrainAs(icLocation) {
				 start.linkTo(parent.start, margin = 21.dp)
				 top.linkTo(parent.top, margin = 16.dp)
			 }, tint = Color(0xFFF56416))

		Text(text = "Indrapuram, Ghaziabad, Uttar Pradesh", fontFamily = Poppins,
			 fontSize = 14.sp, overflow = TextOverflow.Ellipsis,
			 color = Color(0xFFA39D9A),
			 modifier = Modifier.constrainAs(location) {
				 start.linkTo(icLocation.end, margin = 6.dp)
				 top.linkTo(icLocation.top)
				 bottom.linkTo(icLocation.bottom)
				 end.linkTo(parent.end, margin = 16.dp)
				 width = Dimension.fillToConstraints
			 })

		OutlinedTextField(value = "Search for restaurant, item or more", onValueChange = {},
						  leadingIcon = {
							  Icon(painter = painterResource(id = R.drawable.ic_search),
								   contentDescription = null)
						  }, colors = TextFieldDefaults.outlinedTextFieldColors(
				disabledLeadingIconColor = Black,
				disabledBorderColor = Color(0xFFE7E6E8),
				disabledTextColor = Color(0xFF6E6775)
			), shape = RoundedCornerShape(4.dp), modifier = Modifier.constrainAs(textField) {
				width = Dimension.fillToConstraints
				start.linkTo(icLocation.start)
				end.linkTo(parent.end, margin = 16.dp)
				top.linkTo(location.bottom, margin = 27.dp)
			}, enabled = false, textStyle = TextStyle(fontFamily = Mulish, fontSize = 14.sp))

		Text(text = "Popular Curations", fontFamily = Poppins, fontWeight = FontWeight.Medium,
			 fontSize = 16.sp,
			 modifier = Modifier.constrainAs(popularCreationsTxt) {
				 top.linkTo(textField.bottom, margin = 32.dp)
				 start.linkTo(textField.start)
			 })

		LazyRow(modifier = Modifier
			.constrainAs(popularCreationsLazy) {
				start.linkTo(parent.start)
				top.linkTo(popularCreationsTxt.bottom, 24.dp)
				end.linkTo(parent.end)
				width = Dimension.fillToConstraints
			}, contentPadding = PaddingValues(start = 19.dp, end = 14.dp)) {
			val lst = listOf(PopularCurationsDataClass(R.drawable.sweets, "Sweets"),
							 PopularCurationsDataClass(R.drawable.chinese, "Chinese"),
							 PopularCurationsDataClass(R.drawable.burger, "Burgers"),
							 PopularCurationsDataClass(R.drawable.sweets, "Dosa"),
							 PopularCurationsDataClass(R.drawable.chinese, "Desserts"))
			items(5) {
				PopularCurationsItem(popularCurationsDataClass = lst[it])
				Spacer(modifier = Modifier.padding(end = 24.dp))
			}
		}

		Text(text = "Recommended for you", fontFamily = Poppins, fontWeight = FontWeight.Medium,
			 fontSize = 16.sp,
			 modifier = Modifier.constrainAs(recommendedTxt) {
				 top.linkTo(popularCreationsLazy.bottom, margin = 16.dp)
				 start.linkTo(textField.start)
			 })

	}
}

@Composable
private fun PopularCurationsItem(popularCurationsDataClass: PopularCurationsDataClass) {
	Column(verticalArrangement = Arrangement.Center,
		   horizontalAlignment = Alignment.CenterHorizontally) {
		Image(painter = painterResource(popularCurationsDataClass.image), contentDescription =
		popularCurationsDataClass.txt,
			  modifier = Modifier
				  .padding(bottom = 5.dp)
				  .size(112.dp), contentScale = ContentScale.Crop)
		Text(
			text = popularCurationsDataClass.txt,
			fontWeight = FontWeight.Medium,
			fontSize = 12.sp,
			fontFamily = Poppins,
			color = Color(0xFF8C8581))
	}
}

@Composable
private fun RecommendedItem() {
	Card(shape = RoundedCornerShape(8.dp)) {
		Text(text = "Heaven’s Food", fontFamily = Poppins, fontWeight = FontWeight.Medium,
		fontSize = 16.sp, color = CardTextColor, overflow = TextOverflow.Ellipsis)
	}
}