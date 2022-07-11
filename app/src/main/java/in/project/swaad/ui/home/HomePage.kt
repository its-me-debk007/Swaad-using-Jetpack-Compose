package `in`.project.swaad.ui.home

import `in`.project.swaad.R
import `in`.project.swaad.ui.PopularCurationsDataClass
import `in`.project.swaad.ui.theme.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
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

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun HomePage(navController: NavController? = null) {
	ConstraintLayout(Modifier
						 .fillMaxWidth()
						 .background(Color.White)
//						 .verticalScroll(rememberScrollState())
	) {
		val (icLocation, location,
			textField, popularCreationsTxt,
			popularCreationsLazy, recommendedTxt,
			recommendedLazy, morePopularCurations,
			moreRecommended) = createRefs()

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
				disabledLeadingIconColor = CustomBlack,
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

		Icon(painter = painterResource(id = R.drawable.ic_arrow),
			 contentDescription = "More Popular Curations",
			 modifier = Modifier.constrainAs(morePopularCurations) {
				 end.linkTo(parent.end, 27.dp)
				 top.linkTo(popularCreationsTxt.top)
				 bottom.linkTo(popularCreationsTxt.bottom)
			 })

		LazyRow(modifier = Modifier
			.constrainAs(popularCreationsLazy) {
				start.linkTo(parent.start)
				top.linkTo(popularCreationsTxt.bottom, 24.dp)
				end.linkTo(parent.end)
				width = Dimension.fillToConstraints
			}, contentPadding = PaddingValues(start = 19.dp, end = 14.dp)) {
			val lst = listOf(PopularCurationsDataClass(R.drawable.ic_italian, "Italian"),
							 PopularCurationsDataClass(R.drawable.ic_chicken, "Chicken"),
							 PopularCurationsDataClass(R.drawable.ic_noodles, "Noodles"),
							 PopularCurationsDataClass(R.drawable.ic_drinks, "Drinks"),
							 PopularCurationsDataClass(R.drawable.ic_chicken, "Chicken"))
			items(5) {
				PopularCurationsItem(popularCurationsDataClass = lst[it])
				Spacer(modifier = Modifier.padding(end = 16.dp))
			}
		}

		Text(text = "Recommended for you", fontFamily = Poppins, fontWeight = FontWeight.Medium,
			 fontSize = 16.sp,
			 modifier = Modifier.constrainAs(recommendedTxt) {
				 top.linkTo(popularCreationsLazy.bottom, margin = 32.dp)
				 start.linkTo(textField.start)
			 })

		Icon(painter = painterResource(id = R.drawable.ic_arrow),
			 contentDescription = "More Popular Curations",
			 modifier = Modifier.constrainAs(moreRecommended) {
				 end.linkTo(parent.end, 27.dp)
				 top.linkTo(recommendedTxt.top)
				 bottom.linkTo(recommendedTxt.bottom)
			 })

		LazyVerticalGrid(cells = GridCells.Fixed(2),
						 modifier = Modifier
							 .constrainAs(recommendedLazy) {
								 top.linkTo(recommendedTxt.bottom, 16.dp)
								 start.linkTo(parent.start)
								 end.linkTo(parent.end)
							 }, contentPadding =
						 PaddingValues
							 (start = 16
							 .dp)) {
			items(6) {
				RecommendedItem()
			}
		}
	}
}

@Composable
private fun PopularCurationsItem(popularCurationsDataClass: PopularCurationsDataClass) {
	Column(verticalArrangement = Arrangement.Center,
		   horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
			.background(CustomLightOrange, RoundedCornerShape(14.dp))) {
		Icon(painter = painterResource(popularCurationsDataClass.image), contentDescription =
		popularCurationsDataClass.txt,
			 modifier = Modifier
				 .padding(bottom = 8.dp, top = 16.dp, start = 30.dp, end = 30.dp),
		tint = CustomOrange)

		Text(
			text = popularCurationsDataClass.txt,
			fontWeight = FontWeight.Medium,
			fontSize = 10.sp,
			fontFamily = Poppins,
			color = CustomOrange,
		modifier = Modifier.padding(bottom = 16.dp))
	}
}

@Composable
private fun RecommendedItem() {
	Card(shape = RoundedCornerShape(8.dp), elevation = 4.dp,
		 modifier = Modifier.padding(end = 8.dp, bottom = 16.dp, top = 8.dp)) {
		Column {
			Text(text = "Heaven’s Food", fontFamily = Poppins, fontWeight = FontWeight.Medium,
				 fontSize = 16.sp, color = CardRestaurantTxtColor, overflow = TextOverflow
					.Ellipsis, modifier = Modifier.padding(start = 24.dp, top = 24.dp))

			Text(text = "122 RDC,Ghaziabad", fontFamily = Poppins, modifier = Modifier.padding
				(top = 2.dp, start = 24.dp),
				 fontSize = 12.sp, color = CustomGrey, overflow = TextOverflow.Ellipsis)

			Row(modifier = Modifier.padding(start = 24.dp, top = 4.dp)) {
				Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = null,
					 modifier = Modifier.padding(end = 4.dp))

				Text(text = "4.5", fontFamily = Poppins, fontWeight = FontWeight.Medium,
					 fontSize = 16.sp)
			}

			Image(painter = painterResource(id = R.drawable.dish),
				  contentDescription = null,
				  contentScale = ContentScale.Crop,
				  modifier = Modifier
					  .width(175.dp)
					  .height(170.dp))
		}
	}
}