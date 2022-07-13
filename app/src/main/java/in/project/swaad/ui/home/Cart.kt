package `in`.project.swaad.ui.home

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.*
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Cart() {
	Column {
		Row(Modifier.padding(start = 16.dp, top = 16.dp)) {
			Icon(painter = painterResource(id = R.drawable.ic_back_arrow),
				 contentDescription = null, modifier = Modifier
					.size(24.dp)
					.padding(end = 1.5.dp))

			Text(text = "Checkout", fontFamily = Poppins, fontWeight = FontWeight.Medium,
				 fontSize = 18.sp)
		}

		Column(Modifier
				   .fillMaxWidth()
				   .padding(top = 16.dp)
				   .background(CartDeliveryBackground)
				   .padding(top = 11.dp, bottom = 8.dp)
		) {

			DeliveryDetails(icon = R.drawable.ic_location, prefixTxt = "Delivery at",
							txt = "Ajay Kumar Garg Engineering College")

			Spacer(Modifier.height(16.dp))

			DeliveryDetails(icon = R.drawable.ic_timer, prefixTxt = "Delivery in",
							txt = "25 min(s)")

		}

		Heading(txt = "Your Cart", fontSize = 20, icon = R.drawable.ic_shopping_bag)

		//		LazyColumn(modifier = Modifier.background(CartBackground)) {
//			val cartList = listOf(ItemDetail("Burger", 169f), ItemDetail("Pizza", 199f),
//								  ItemDetail("Waffle", 269f), ItemDetail("Hakka noodles", 1099f))
//			itemsIndexed(cartList) { index, item ->
//				CartItem(itemDetail = item)
//			}
//
//		}

		Heading(txt = "Discounts", icon = R.drawable.ic_discount)

		Column(Modifier
				   .fillMaxWidth()
				   .padding(top = 16.dp)
				   .background(CartBackground)
				   .padding(top = 20.dp, bottom = 20.dp, start = 16.dp)) {

			Row {
				Icon(painter = painterResource(id = R.drawable.ic_timer), contentDescription = null,
					 tint = ColorPrimary, modifier = Modifier.padding(end = 4.dp))

				Text(text = "40% OFF applied!", fontFamily = Poppins)

				Text(text = "-₹72.00", fontFamily = Poppins, fontWeight = FontWeight.Medium)
			}

			Row {
				Icon(painter = painterResource(id = R.drawable.ic_timer), contentDescription = null,
					 tint = ColorPrimary, modifier = Modifier.padding(end = 4.dp))

				Text(text = "Select a promo-code", fontFamily = Poppins)

				Text(text = "View Offers", fontFamily = Poppins, fontWeight = FontWeight.Medium,
					 color = ColorPrimary, fontSize = 12.sp)
			}
		}

		Column(Modifier
				   .fillMaxWidth()
				   .padding(top = 16.dp)
				   .background(CartDeliveryBackground)
				   .padding(top = 11.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)) {
			PriceDetails(txt = "Item Total", price = 2912f)

			Spacer(Modifier.height(8.dp))

			PriceDetails(txt = "Delivery Charge", price = 72f)

			Spacer(Modifier.height(8.dp))

			Canvas(Modifier
					   .fillMaxWidth()
					   .height(2.dp)) {
				drawLine(color = Color.Black,
						 start = Offset(0f, 0f),
						 end = Offset(size.width, 0f),
						 pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))
			}

			Row(Modifier.padding(top = 8.dp)) {
				Text(text = "Grand Total", fontFamily = Poppins, fontWeight = FontWeight.Medium,
					 fontSize = 18.sp)

				Text(text = "₹2984.00", fontFamily = Poppins, fontSize = 16.sp,
					 fontWeight = FontWeight.Bold)
			}
		}
	}
}

data class ItemDetail(
	val dish: String,
	val price: Float,
	val amount: UShort = 1u
)

@Composable
fun CartItem(itemDetail: ItemDetail) {
	var count = itemDetail.amount
	Row {
		Text(text = itemDetail.dish, fontSize = 16.sp, fontFamily = Poppins)

		Row(modifier = Modifier
			.border(1.dp, CustomYellow, shape = RoundedCornerShape(32.dp))
			.background(CartBtnBackground)
			.padding(vertical = 4.dp, horizontal = 8.dp)) {

			Icon(painter = painterResource(id = R.drawable.ic_minus),
				 contentDescription = "Remove one item", modifier = Modifier
					.clickable { if (count <= 100u) ++count }
					.size(16.dp, 18.dp), tint = CustomDarkYellow)

			Text(text = count.toString(), modifier = Modifier.padding(horizontal = 10.dp),
				 color = CustomDarkYellow, fontFamily = Poppins, fontWeight = FontWeight.Bold,
				 fontSize = 12.sp)

			Icon(imageVector = Icons.Filled.Add,
				 contentDescription = "Add one more item",
				 tint = CustomDarkYellow,
				 modifier = Modifier
					 .clickable { if (count >= 1u) --count }
					 .size(16.dp, 18.dp))
		}
	}
}

@Composable
fun DeliveryDetails(@DrawableRes icon: Int, prefixTxt: String, txt: String) {
	Row(Modifier.padding(start = 16.dp, end = 24.dp)) {
		Icon(painter = painterResource(id = icon), contentDescription = null,
			 modifier = Modifier
				 .padding(end = 2.5.dp)
				 .size(20.dp), tint = ColorPrimary)

		Text(buildAnnotatedString {
			withStyle(SpanStyle(fontFamily = Poppins, fontSize = 12.sp)) {
				append("$prefixTxt ")
			}

			withStyle(SpanStyle(
				fontFamily = Poppins, fontSize = 14.sp,
				fontWeight = FontWeight.Medium)) {
				append(txt)
			}
		}, overflow = TextOverflow.Ellipsis, maxLines = 1)
	}
}

@Composable
fun Heading(txt: String, fontSize: Int = 16, @DrawableRes icon: Int) {
	Row(Modifier.padding(start = 16.dp, top = 16.dp)) {
		Text(text = txt, fontWeight = FontWeight.Bold, fontFamily = Poppins, fontSize = fontSize.sp)

		Icon(painter = painterResource(id = icon),
			 contentDescription = null, modifier = Modifier.padding(start = 8.dp))
	}
}

@Composable
fun PriceDetails(txt: String, price: Float) {
	Row {
		Text(text = txt, fontFamily = Poppins, color = Color.Gray,
			 fontSize = 12.sp)

		Text(text = "₹$price", fontFamily = Poppins, color = Color.Gray)
	}
}
