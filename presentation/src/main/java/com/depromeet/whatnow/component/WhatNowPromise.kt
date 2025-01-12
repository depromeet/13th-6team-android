package com.depromeet.whatnow.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.depromeet.whatnow.domain.model.GetPromisesUsersStatus
import com.depromeet.whatnow.ui.R
import com.depromeet.whatnow.ui.theme.WhatNowTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

@Composable
fun WhatNowPromise(modifier: Modifier, promisesUsersStatusItem: GetPromisesUsersStatus) {

    var date = ""

    var today = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"))

    val promiseMonth = promisesUsersStatusItem.endTime.substring(5, 7)
    val promiseDay = promisesUsersStatusItem.endTime.substring(8, 10)
    val promiseDate = promisesUsersStatusItem.endTime.substring(0, 10) + " 00:00:00"
    var sf =
        SimpleDateFormat("yyyy-MM-dd 00:00:00") //단순히 날짜만 확인하기위해 시간을 00:00:00으로 셋팅함.

//    2023-07-07T14:57:x18.474Z
    val calculationDate =
        (today.time.time - sf.parse(promiseDate)!!.time) / (60 * 60 * 24 * 1000)

    date = if (calculationDate > 7) {
        "${promiseMonth.toInt()}/$promiseDay"

    } else {
        if (calculationDate == 0L) {
            "오늘"
        } else {
            "D-${
                calculationDate
            }"
        }
    }

    Card(
        shape = RoundedCornerShape(
            topEnd = 16.dp,
            topStart = 16.dp,
            bottomEnd = 16.dp,
            bottomStart = 16.dp
        ),
        modifier = Modifier
            .padding(bottom = 8.dp)

    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 23.dp)

            ) {
                Card(
                    shape = RoundedCornerShape(
                        topEnd = 18.dp,
                        topStart = 18.dp,
                        bottomEnd = 18.dp,
                        bottomStart = 18.dp
                    ),
                    modifier = Modifier
                        .border(
                            BorderStroke(width = 0.dp, color = WhatNowTheme.colors.gray100),
                            shape = RoundedCornerShape(18.dp)
                        )


                ) {
                    Box(
                        modifier = Modifier
                            .width(72.dp)
                            .height(48.dp)
                            .background(WhatNowTheme.colors.gray100),
                        contentAlignment = Alignment.Center

                    ) {

                        Text(
                            text = date,
                            style = WhatNowTheme.typography.body2.copy(
                                fontSize = 16.sp, color = WhatNowTheme.colors.whatNowPurple
                            )
                        )
                    }
                }

                Column(
                    modifier = modifier.padding(start = 16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = promisesUsersStatusItem.title,
                        style = WhatNowTheme.typography.body1.copy(
                            fontSize = 18.sp, color = WhatNowTheme.colors.whatNowBlack
                        )
                    )
                    Row(
                        modifier = modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = promisesUsersStatusItem.address,
                            style = WhatNowTheme.typography.caption2.copy(
                                fontSize = 14.sp, color = WhatNowTheme.colors.gray700
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}