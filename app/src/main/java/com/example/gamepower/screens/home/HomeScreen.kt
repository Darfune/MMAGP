package com.example.gamepower.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.gamepower.components.giveaway.GiveawayCard
import com.example.network.KtorClient
import com.example.network.model.domain.giveaway.Giveaway
import kotlinx.coroutines.delay

private val ktorClient = KtorClient()

@Composable
fun HomeScreen(onGiveawayClicked: (String) -> Unit) {
    var giveaway by remember {
        mutableStateOf<Giveaway?>(null)
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(500)
        ktorClient
            .getGiveawayById(525)
            .onSuccess {
                giveaway = it
            }
            .onFailure { exception ->
                exception.message?.let { Log.e("HomeScreen: ", it) }
            }
    })
    Column (modifier = Modifier.fillMaxSize()){
        giveaway?.let { it -> GiveawayCard(giveaway = it) {onGiveawayClicked(it)} }
//        giveaway?.let { GiveawayCard(giveaway = it) { onGiveawayClicked } }
    }

//    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(all = 16.dp)) {
//        item {
//            GiveawayCard()
//        }
//    }
}