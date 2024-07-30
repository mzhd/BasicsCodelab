package com.mzyl.basicscodelab

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Compact
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Expanded
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mzyl.basicscodelab.ui.theme.BasicsCodelabTheme

class BasicLayoutActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                val window_size = calculateWindowSizeClass(activity = this)
                MySootheApp(window_size)
            }
        }
    }
}

@Composable
fun searchbar(modifier: Modifier = Modifier) {
    TextField(value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        })
}

@Preview
@Composable
fun searchbar_preview() {
    searchbar()
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun AlignYourBodyElement_preview() {
    Surface(color = MaterialTheme.colorScheme.primary) {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ic_launcher_foreground,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(modifier = modifier.width(255.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = modifier.size(80.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = drawable),
                contentDescription = null
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun FavoriteCollectionCard_Preview() {
    BasicsCodelabTheme {
        FavoriteCollectionCard(
            drawable = R.drawable.fc2_nature_meditations, text = R.string.fc2_nature_meditations
        )
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int, @StringRes val text: Int
)

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) {
            AlignYourBodyElement(it.drawable, it.text)
        }

    }
}

@Preview
@Composable
fun AlignYourBodyRow_Preview() {
    BasicsCodelabTheme {
        AlignYourBodyRow()
    }
}

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(favoriteCollectionsData) {
            FavoriteCollectionCard(
                drawable = it.drawable,
                text = it.text,
                //modifier = modifier.height(80.dp)
            )
        }
    }
}

@Preview
@Composable
fun FavoriteCollectionsGrid_Preview() {
    BasicsCodelabTheme {
        FavoriteCollectionsGrid()
    }
}

@Composable
fun home_section(
    @StringRes title: Int, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun home_section_Preview() {
    BasicsCodelabTheme {
        home_section(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}

@Composable
fun home_screen(
    modifier: Modifier = Modifier,
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        searchbar(modifier = Modifier.padding(horizontal = 16.dp))
        home_section(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        home_section(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun home_screen_Preview() {
    BasicsCodelabTheme {
        home_screen()
    }
}

@Composable
fun bottom_navigation(
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier, containerColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Spa, contentDescription = null
            )
        }, label = {
            Text(text = stringResource(id = R.string.bottom_navigation_home))
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle, contentDescription = null
            )
        }, label = {
            Text(text = stringResource(id = R.string.bottom_navigation_profile))
        })
    }
}

@Preview(showBackground = false, backgroundColor = 0xFFF5F0EE)
@Composable
fun bottom_navigation_preview() {
    BasicsCodelabTheme {
        bottom_navigation()
    }
}

@Composable
fun SootheNavigationRail(
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NavigationRailItem(selected = true, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Default.Spa, contentDescription = null
                )
            }, label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            })
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            }, label = {
                Text(text = stringResource(id = R.string.bottom_navigation_profile))
            })
        }
    }
}

//纵向布局
@Composable
fun MySootheAppPortrait() {
    BasicsCodelabTheme {
        Scaffold(bottomBar = { bottom_navigation() }) { padding ->
            home_screen(modifier = Modifier.padding(padding))
        }
    }
}

//横向布局
@Composable
fun MySootheAppLandscape() {
    BasicsCodelabTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                home_screen()
            }
        }
    }
}

//横向布局
@Preview
@Composable
fun MySootheAppLandscapePreview() {
    MySootheAppLandscape()
}

@Preview
@Composable
fun MySootheAppPortraitPreview() {
    MySootheAppPortrait()
}

@Preview
@Composable
fun SootheNavigationRailPreview() {
    SootheNavigationRail()
}


@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        //竖屏
        Compact -> {
            MySootheAppPortrait()
        }
        //横屏
        Expanded -> {
            MySootheAppLandscape()
        }
    }
}
