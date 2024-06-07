package org.d3if3011.resepi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3011.resepiadmin.R
import org.d3if3011.resepiadmin.navigation.Screen
import org.d3if3011.resepiadmin.ui.theme.ResepiAdminTheme

@Composable
fun AdminDashboardScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            AdminDashboardTopbar(navController = navController)
        }
    ) {
        AdminDashboardContent(navController,modifier = Modifier.padding(it))
    }


}

@Composable
fun AdminDashboardContent(navController: NavHostController, modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 14.dp, bottom = 20.dp)
                .clickable { navController.navigate(Screen.TambahResepPage.route) }
        ){
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.tambah_menu),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }

        AdminDashboardListItem(navController = navController)


    }

}

@Composable
fun AdminDashboardListItem(navController: NavHostController) {
    Column (
        modifier = Modifier.clickable {
            navController.navigate(Screen.DetailResepPage.route)
        }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(end = 10.dp)
                    .weight(1.0f)
            ) {
                Text(
                    text = stringResource(id = R.string.alat_masak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )

                Text(
                    text = stringResource(id = R.string.tambah_menu),
                    color = Color.DarkGray
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = stringResource(R.string.waktu_memasak),
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = stringResource(id = R.string.bahan_masakan),
                        color = Color.DarkGray
                    )
                }
            }

            Image(
                modifier = Modifier
                    .weight(0.4f),
                painter = painterResource(id = R.drawable.ic_upload),
                contentDescription = stringResource(R.string.gambar_makanan),
            )
        }
        Divider(
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardTopbar(navController: NavHostController) {

    var searchText by remember {
        mutableStateOf("")
    }

    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        actions = {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        unfocusedLeadingIconColor = Color.Gray
                    ),
                    value = searchText,
                    onValueChange = { searchText = it },

                    placeholder = { Text(stringResource(R.string.cari_resep_kamu), color = Color.DarkGray) },
                    leadingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.DarkGray,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    },
                    )

        }
    )
}

//@Preview
//@Composable
//fun AdminTopbarPreview() {
//    ResepiAdminTheme {
//        AdminDashboardTopbar(navController = rememberNavController())
//    }
//}

@Preview
@Composable
fun AdminDashboardPreview() {
    ResepiAdminTheme {
        AdminDashboardScreen(rememberNavController())
    }
}