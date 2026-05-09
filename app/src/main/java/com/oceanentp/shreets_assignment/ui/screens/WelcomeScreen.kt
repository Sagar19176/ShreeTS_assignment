package com.oceanentp.shreets_assignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oceanentp.shreets_assignment.R
import com.oceanentp.shreets_assignment.ui.theme.*

@Composable
fun WelcomeScreen(onNavigateNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightTealBackground)
            .padding(horizontal = 24.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Robot Image
        Image(
            painter = painterResource(id = R.drawable.starterpage),
            contentDescription = "Robot",
            modifier = Modifier.size(height = 400.dp, width = 300.dp),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        // Dots Indicator
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(PrimaryTeal))
            Box(modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(PrimaryTeal.copy(alpha = 0.3f)))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Styled Text
            Text(
                text = buildAnnotatedString {
                    append("Personal ")
                    withStyle(style = SpanStyle(color = PrimaryTeal)) {
                        append("AI\nAssistant")
                    }
                },
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText,
                textAlign = TextAlign.Center,
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Simplify file organization\nwith our intuitive file Manager.",
                fontSize = 16.sp,
                color = DarkText.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = onNavigateNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryTeal)
        ) {
            Text(text = "Get Started", fontSize = 22.sp, color = White)
        }
    }
}


@Preview
@Composable
private fun WelcomePrev() {
    WelcomeScreen {  }
}