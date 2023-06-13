package com.depromeet.whatnow.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.depromeet.whatnow.ui.R
import com.depromeet.whatnow.ui.theme.WhatNowTheme

@Composable
fun WhatNowPromiseItem(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)

        ) {
            Card(
                shape = RoundedCornerShape(
                    topEnd = 10.dp,
                    topStart = 10.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                ),
                modifier = Modifier
                    .border(
                        BorderStroke(width = 1.dp, color = Color.Black),
                        shape = RoundedCornerShape(12.dp)
                    )

            ) {
                Box(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .background(Color.White),
                ) {

                }
            }
            Column() {
                Row(
                ) {

                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        verticalArrangement= Arrangement.Center,
                    ) {
                        Text(
                            text = "먹쨩이 되고싶은 모임",
                            color = Color.Black
//                            style = WhatNowTheme.typography.medium.copy(
//                                fontSize = 16.sp,
//                                color = WhatNowTheme.colors.gray100
//                            )
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "서울시 종로구",
                                color = Color.Black

//                            style = WhatNowTheme.typography.regular.copy(
//                                fontSize = 16.sp,
//                                color = Color(0xFF818284)
//                            )
                            )
                        }

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)

                    ) {
                        Surface(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .width(24.dp)
                                .height(24.dp)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null,
                                    onClick = { }
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.chevron_right),
                                contentDescription = null,
                            )
                        }
                    }
                }


            }

        }
        Box(
            modifier = Modifier
                .padding(all = 16.dp)
                .background(WhatNowTheme.colors.gray400)
                .height(1.dp)
                .fillMaxWidth()

        ) {}

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    WhatNowTheme {
        WhatNowPromiseItem(Modifier)
    }
}
