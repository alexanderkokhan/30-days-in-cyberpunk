package com.example.cyberpunk30days


import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cyberpunk30days.data.cards
import com.example.cyberpunk30days.ui.theme.Cyberpunk30DaysTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import com.example.cyberpunk30days.data.CyberpunkCard
import com.example.cyberpunk30days.ui.theme.containerIdleLight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cyberpunk30DaysTheme {
                Surface() {
                    CyberpunkApp()
                }
            }
        }
    }
}

@Composable
fun CyberpunkApp() {
    var selectedCardDay by remember { mutableStateOf<Int?>(null) }
    Scaffold(
        topBar = {
            CyberpunkAppTopBar()
        }
    ) {
            it ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_medium))
        ) {
            items(cards) { card ->
                CyberpunkCardComposable(
                    card = card,
                    isSelected = card.day == selectedCardDay,
                    modifier = Modifier,
                    onCardClick = {
                        selectedCardDay = if (card.day == selectedCardDay) null else card.day
                    })
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(R.dimen.padding_medium)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "// ARASAKA SECURITY: ${Build.MANUFACTURER.uppercase()} DEVICE VERIFIED",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                    Text(
                        text = stringResource(R.string.copyright_note),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CyberpunkAppTopBar(modifier: Modifier = Modifier) {
    Box(modifier.background(MaterialTheme.colorScheme.background)) {
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.top_app_bar),
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.primary

                    )
                }
            }
        )
        HorizontalDivider(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )

    }
}
@Composable
fun CyberpunkCardComposable(
    card: CyberpunkCard,
    isSelected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier
) {
    val containerColor = if (isSelected) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        MaterialTheme.colorScheme.surface
    }
    val outlineColor = if (isSelected) {
        MaterialTheme.colorScheme.outlineVariant
    } else {
        MaterialTheme.colorScheme.outline
    }
    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.onSurfaceVariant
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Card(modifier = Modifier
            .clickable(onClick = onCardClick)
            .border(
                width = 2.dp,
                color = outlineColor,
                shape = MaterialTheme.shapes.medium
            ),
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            )
        ){
        Column(modifier = modifier){
            Text(
                modifier = modifier.padding(dimensionResource(R.dimen.padding_small)),
                text = stringResource(card.name),
                style = MaterialTheme.typography.displayMedium,
                color = contentColor
            )
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.small)
                    .padding(horizontal = dimensionResource(R.dimen.padding_small)),
                painter = painterResource(card.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop,

            )
            Text(
                modifier = modifier.padding(
                    start = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.space_medium),
                    top = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small)
                ),
                text = stringResource(card.description),
                style = MaterialTheme.typography.bodyLarge,
                color = contentColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CyberpunkAppPreview() {
    MaterialTheme {
        CyberpunkApp()
    }
}