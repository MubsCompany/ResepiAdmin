package org.d3if3011.resepi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
fun AdminTambahResepScreen(navController: NavHostController) {
    Scaffold (
        topBar = {AdminTambahResepTopBar(navController = navController)}
    ) {
        AdminTambahForm(modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminTambahForm(modifier: Modifier = Modifier) {

    var namaResep by remember {
        mutableStateOf("")
    }

    Column (
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color(0xFFF8E6D5))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // NAMA RESEP
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(18.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.nama_resep),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                TextField(
                    value = namaResep,
                    onValueChange = {namaResep = it},
                    placeholder = { Text(stringResource(R.string.masukkan_isian), color = Color.DarkGray) },
                    colors = OutlinedTextFieldDefaults.colors(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }

        // WAKTU PEMBUATAN RESEP
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(24.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.waktu_pembuatan_resep),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                TextField(
                    value = namaResep,
                    onValueChange = {namaResep = it},
                    placeholder = { Text(stringResource(R.string.masukkan_isian), color = Color.DarkGray) },
                    colors = OutlinedTextFieldDefaults.colors(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }

        // BAHAN MASAKAN
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(24.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.bahan_masakan),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                TextField(
                    value = namaResep,
                    onValueChange = {namaResep = it},
                    placeholder = { Text(stringResource(R.string.masukkan_isian), color = Color.DarkGray) },
                    colors = OutlinedTextFieldDefaults.colors(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }

        // MASUKKAN ALAT MEMASAK
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(24.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.masukkan_alat_memasak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                TextField(
                    value = namaResep,
                    onValueChange = {namaResep = it},
                    placeholder = { Text(stringResource(R.string.masukkan_isian), color = Color.DarkGray) },
                    colors = OutlinedTextFieldDefaults.colors(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }

        // MASUKKAN CARA MEMASAK
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(24.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.masukkan_cara_memasak),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                TextField(
                    value = namaResep,
                    onValueChange = {namaResep = it},
                    placeholder = { Text(stringResource(R.string.masukkan_isian), color = Color.DarkGray) },
                    colors = OutlinedTextFieldDefaults.colors(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }

        // MASUKKAN GAMBAR RESEP
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF9F9))
                .border(1.5.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .padding(24.dp),
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.masukkan_gambar_resep),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                OutlinedButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_upload), contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.tambahkan_file))
                }
            }

        }
        
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF57C00)
            )
        ) {
            Text(
                text = stringResource(R.string.kirim),
                fontSize = 18.sp,
                color = Color.White
            )
        }



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminTambahResepTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(
            text = stringResource(id = R.string.tambah_resep),
            color = Color.Black
        ) },
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
    )
}


@Preview
@Composable
fun AdminTambahFormPreview() {
    ResepiAdminTheme {
        AdminTambahResepScreen(navController = rememberNavController())
    }
}
