package `in`.project.swaad.ui.fragment.home

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.Poppins
import `in`.project.swaad.ui.theme.ProfileDividerColor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Account() {
	val lst = listOf("My Orders", "Manage Addresses", "Help & Support", "About Swaad",
					 "FAQs", "Terms & Conditions", "Logout")

	Column(Modifier.fillMaxSize()) {
		ProfileHeader(name = "Manish Yadav", image = R.drawable.dish, phoneNo = "82********",
					  email = "manish@gmail.com")

		lst.forEach { menu ->
			Box(modifier = Modifier
				.fillMaxWidth()
				.clickable { openPage() }) {
				Text(text = menu, fontFamily = Poppins, fontSize = 15.sp,
					 modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp))
			}

			Spacer(modifier = Modifier
				.fillMaxWidth()
				.height(1.dp)
				.background(ProfileDividerColor))
		}
	}
}

fun openPage() {
//	when (menu) {
//		"My Orders" ->
//
//	}
}

@Composable
private fun ProfileHeader(name: String, @DrawableRes image: Int, phoneNo: String, email: String) {
	Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
		.padding(top = 40.dp, bottom = 16.dp)) {

		Image(painter = painterResource(id = image), contentDescription = null,
			  contentScale = ContentScale.Crop, modifier = Modifier
				.padding(horizontal = 16.dp)
				.clip(RoundedCornerShape(50)))

		Column {
			Text(text = "Hi $name", overflow = TextOverflow.Ellipsis, fontSize = 18.sp,
				 fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 4.dp),
				 fontFamily = Poppins)

			Text(text = phoneNo, overflow = TextOverflow.Ellipsis, fontSize = 12.sp,
				 fontWeight = FontWeight.Medium, fontFamily = Poppins)

			Text(text = email, overflow = TextOverflow.Ellipsis, fontSize = 12.sp,
				 fontWeight = FontWeight.Medium, fontFamily = Poppins)
		}
	}
}