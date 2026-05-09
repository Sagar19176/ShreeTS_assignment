package com.oceanentp.shreets_assignment.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
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
import com.oceanentp.shreets_assignment.ui.theme.DarkText
import com.oceanentp.shreets_assignment.ui.theme.LightTealBackground
import com.oceanentp.shreets_assignment.ui.theme.PrimaryTeal
import com.oceanentp.shreets_assignment.ui.theme.White

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WelcomeScreen(innerPadding: PaddingValues, onNavigateNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightTealBackground)
            .padding(innerPadding)
            .padding(horizontal = 24.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Robot Image
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.65f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.starterpage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(radius = 20.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                    .alpha(0.7f),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.starterpage),
                contentDescription = "Robot",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }


        // Dots
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(PrimaryTeal)
            )
            Box(
                modifier = Modifier
                    .size(width = 10.dp, height = 10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(PrimaryTeal.copy(alpha = 0.3f))
            )
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

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WelcomePrev() {
    WelcomeScreen(innerPadding = PaddingValues(0.dp), onNavigateNext = {})
}
