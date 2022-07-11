package `in`.project.swaad.ui.home

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.CartBtnBackground
import `in`.project.swaad.ui.theme.CustomDarkYellow
import `in`.project.swaad.ui.theme.CustomYellow
import `in`.project.swaad.ui.theme.Poppins
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Cart() {
	Row(Modifier.padding(start = 16.dp, top = 16.dp)) {
		Icon(painter = painterResource(id = R.drawable.ic_back_arrow),
			 contentDescription = null, modifier = Modifier.padding(end = 1.5.dp))

		Text(text = "Checkout", fontFamily = Poppins, fontWeight = FontWeight.Medium,
			 fontSize = 16.sp)
	}
//		LazyColumn(modifier = Modifier.background(CartBackground)) {
//			val cartList = listOf(ItemDetail("Burger", 169f), ItemDetail("Pizza", 199f),
//								  ItemDetail("Waffle", 269f), ItemDetail("Hakka noodles", 1099f))
//			itemsIndexed(cartList) { index, item ->
//				CartItem(itemDetail = item)
//			}
//
//		}
}

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

data class ItemDetail(
	val dish: String,
	val price: Float,
	val amount: UShort = 1u
)