package com.depromeet.whatnow.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.depromeet.whatnow.ui.promiseActivate.PromiseActivateTab
import com.depromeet.whatnow.ui.promiseActivate.PromiseActivateViewModel
import com.depromeet.whatnow.ui.theme.WhatNowTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WhatNowBottomSheetScaffold(
    viewModel: PromiseActivateViewModel,
    modifier: Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val contextForToast = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        modifier = modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetPeekHeight = 300.dp,
        sheetBackgroundColor = WhatNowTheme.colors.whatNowBlack,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetContent = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
            ) {
                WhatNowBottomSheetContent(modifier = modifier)

                WhatNowTab(
                    selected = uiState.selectedTab,
                    onTotalClicked = { viewModel.selectTab(PromiseActivateTab.All) },
                    onMeClicked = { viewModel.selectTab(PromiseActivateTab.My) },
                    onFriendClicked = { viewModel.selectTab(PromiseActivateTab.Other) },

                    )

                when (uiState.selectedTab) {
                    PromiseActivateTab.All -> {
                        WhatNowTabAllContent(
                            modifier = modifier,
                            promises = uiState.allProfile,
                            onCreate = {})
                    }

                    PromiseActivateTab.My -> {
                        WhatNowTabMyContent(
                            modifier = Modifier,
                            promises = uiState.myProfile,
                            viewModel = viewModel
                        )
                    }

                    PromiseActivateTab.Other -> {
                        WhatNowTabOtherContent(promises = uiState.otherProfile, onCreate = {})
                    }
                }
            }
        }) {
        // app UI
        WhatNowNaverMap(modifier = Modifier)

    }

}