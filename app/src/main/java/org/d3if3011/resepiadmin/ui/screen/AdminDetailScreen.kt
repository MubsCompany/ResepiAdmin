package org.d3if3011.resepiadmin.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3011.resepiadmin.R
import org.d3if3011.resepiadmin.ui.theme.ResepiAdminTheme

@Composable
fun AdminDetailScreen(navController: NavHostController, idResep: String) {
    Scaffold (
        containerColor = Color(0xFFF8E6D5),
        topBar = { AdminDetailTopBar(navController) },
    ) {paddingValues ->
        AdminDetailScreenContent(modifier = Modifier.padding(paddingValues), idResep)
    }
}

@Composable
fun AdminDetailScreenContent(modifier: Modifier = Modifier, idResep: String) {

        Column (
            modifier = modifier
                .verticalScroll(rememberScrollState()),
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img_hamburger),
                contentDescription = stringResource(id = R.string.gambar_makanan),
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.waktu_memasak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
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

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF8E6D5))
                    .padding(20.dp),
            ) {
                Text(
                    text = stringResource(R.string.bahan_masakan),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                    Text(
                        text = stringResource(id = R.string.alat_masak)
                    )
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.alat_masak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                    Text(
                        text = stringResource(id = R.string.tambah_menu)
                    )

            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF8E6D5))
                    .padding(20.dp),
            ) {
                Text(
                    text = stringResource(R.string.cara_memasak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                    Text(
                        text = stringResource(id = R.string.cari_resep)
                    )

            }

        }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDetailTopBar(navController: NavHostController) {

    var showDeleteDialog by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(text = "Burger vegetarian")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.kembali),
                    tint = Color.Black
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    showDeleteDialog = true
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                if (showDeleteDialog) {
                    DeleteDialog(onDismissRequest = { showDeleteDialog = false }, onDelete = { showDeleteDialog = false })
                }
            }
        }
    )
}



@Composable
fun DeleteDialog(
    onDismissRequest: () -> Unit,
    onDelete: () -> Unit
){
    Dialog(onDismissRequest = { onDismissRequest() },) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(text = "Anda yakin untuk menghapus menu masakan?")
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = { onDelete() },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text(
                            text = "Yakin",
                            color = Color.Red
                        )
                    }
                    OutlinedButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(end = 5.dp)
                    ) {
                        Text(text = "Tidak")
                    }

                }
            }
        }
    }
}



@Preview
@Composable
fun AdminDetailScreenPreview() {
    ResepiAdminTheme {
        AdminDetailScreen(rememberNavController(), idResep = "")
    }
}
