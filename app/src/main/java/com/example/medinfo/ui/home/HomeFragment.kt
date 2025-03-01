package com.example.medinfo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medinfo.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML Layout එක Inflate කරනවා
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}

//package com.example.medinfo.ui.home
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.ComposeView
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import com.example.medinfo.R
//import com.example.medinfo.ui.theme.MedInfoTheme
//
//class HomeFragment : Fragment() {
//
//    private lateinit var homeViewModel: HomeViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//
//        return ComposeView(requireContext()).apply {
//            setContent {
//                MedInfoTheme {
//                    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFE3F2FD)) {
//                        FullScreenLayout()
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun FullScreenLayout() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFE3F2FD))
//            .padding(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TopBar()
//        GreetingSection()
//        ActionButtons()
//        RemindersSection()
//        HealthTipsSection()
//        BottomNavigationBar()
//    }
//}
//
//@Composable
//fun TopBar() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(painter = painterResource(id = R.drawable.fi_rs_menu_burger), contentDescription = "Menu", Modifier.size(24.dp))
//        }
//        Image(
//            painter = painterResource(id = R.drawable.bb),
//            contentDescription = "MedInfo Logo",
//            modifier = Modifier.size(80.dp)
//        )
//    }
//}
//
//@Composable
//fun GreetingSection() {
//    Text(
//        text = "HELLO, Sandy",
//        fontSize = 24.sp,
//        fontWeight = FontWeight.Bold,
//        color = Color(0xFF4CAF50)
//    )
//}
//
//@Composable
//fun ActionButtons() {
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            ActionButton(icon = R.drawable.li_search, text = "Search Medicine")
//            ActionButton(icon = R.drawable.li_clock, text = "Set Reminders")
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            ActionButton(icon = R.drawable.li_user, text = "User Profile")
//            ActionButton(icon = R.drawable.ic_notifications_black_24dp, text = "Search History")
//        }
//    }
//}
//
//@Composable
//fun ActionButton(icon: Int, text: String) {
//    Column(
//        modifier = Modifier
//            .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(10.dp))
//            .padding(12.dp)
//            .size(120.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Icon(painter = painterResource(id = icon), contentDescription = text, modifier = Modifier.size(36.dp))
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Normal)
//    }
//}
//
//@Composable
//fun RemindersSection() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(10.dp))
//            .padding(12.dp)
//    ) {
//        Text(
//            text = "Today's Reminders",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFF4CAF50)
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "At 1.30 p.m.", fontSize = 14.sp)
//        Text(text = "At 9.30 p.m.", fontSize = 14.sp)
//    }
//}
//
//@Composable
//fun HealthTipsSection() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(10.dp))
//            .padding(12.dp)
//    ) {
//        Text(
//            text = "Latest Health Tips",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFF4CAF50)
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "Stay Hydrated", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
//        Spacer(modifier = Modifier.height(2.dp))
//        Text(text = "Drink at least 8 glasses of water daily...", fontSize = 14.sp)
//    }
//}
//
//@Composable
//fun BottomNavigationBar() {
//    BottomNavigation(
//        backgroundColor = Color.White,
//        contentColor = Color(0xFF4CAF50),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 8.dp)
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(painter = painterResource(id = R.drawable.li_home), contentDescription = "Home") },
//            label = { Text("Home", fontSize = 12.sp, fontWeight = FontWeight.Normal) },
//            selected = true,
//            onClick = { /*TODO*/ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painter = painterResource(id = R.drawable.li_search), contentDescription = "Search") },
//            label = { Text("Search", fontSize = 12.sp, fontWeight = FontWeight.Normal) },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painter = painterResource(id = R.drawable.li_clock), contentDescription = "Reminder") },
//            label = { Text("Reminder", fontSize = 12.sp, fontWeight = FontWeight.Normal) },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painter = painterResource(id = R.drawable.li_user), contentDescription = "Profile") },
//            label = { Text("Profile", fontSize = 12.sp, fontWeight = FontWeight.Normal) },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//    }
//}
