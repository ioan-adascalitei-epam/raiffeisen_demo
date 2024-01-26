package com.raiffeisen.app.presentation.users.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.raiffeisen.app.R
import com.raiffeisen.app.presentation.ui.theme.RaiffeisenDemoTheme
import com.raiffeisen.app.presentation.users.UserState

@Composable
fun HeaderItem(
    modifier: Modifier = Modifier,
    title: String = "",
    onSearchClick: () -> Unit = {},
    onHamburgerMenuClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp)
            .padding(12.dp)
    ) {
        Icon(
            Icons.Default.Menu,
            contentDescription = stringResource(id = R.string.menu_description),
            modifier = Modifier.clickable { onHamburgerMenuClick() })
        Text(
            text = title,
            modifier = Modifier
                .weight(2f)
                .padding(start = 16.dp)
        )
        Icon(
            Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search_description),
            modifier = Modifier.clickable { onSearchClick() }
        )
    }
}

@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    userState: UserState = UserState(),
    onStarClicked: () -> Unit = {}
) {
    Column(modifier = modifier.padding(8.dp)) {
        Row(modifier = modifier.padding(8.dp)) {
            Image(
//                painter = rememberAsyncImagePainter(userState.pictureUrl),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .weight(1f)

            )
            Column(
                modifier = modifier
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Text(text = userState.username)
                Text(text = userState.userInfo)
            }
            if (userState.hasAttachment) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_attach_file),
                    contentDescription = stringResource(id = R.string.attachment_info),
                    modifier = modifier
                        .padding(8.dp)
                )
            }
            Column(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = userState.sentTime)
                Spacer(modifier = modifier.size(24.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = stringResource(id = R.string.star_info),
                    modifier = modifier.clickable { onStarClicked() }
                )
            }
        }
        Divider(color = Color.Gray, thickness = 1.dp)
    }
}

@Composable
fun AddUserItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        modifier = modifier.clip(CircleShape),
        onClick = { onClick() },
    ) {
        Icon(
            Icons.Filled.Edit,
            contentDescription = stringResource(id = R.string.add_user_btn)
        )
    }
}

@Preview
@Composable
fun HeaderItemPreview() {
    RaiffeisenDemoTheme {
        HeaderItem()
    }
}

@Preview
@Composable
fun UserItemPreview() {
    RaiffeisenDemoTheme {
        UserItem()
    }
}

@Preview
@Composable
fun AddUserItemPreview() {
    RaiffeisenDemoTheme {
        AddUserItem()
    }
}