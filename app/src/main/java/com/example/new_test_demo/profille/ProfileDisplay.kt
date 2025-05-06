package com.example.new_test_demo.profille

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

// Thành phần hiển thị nội dung chính
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileDisplayContent(profile: User, onEditClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF1F1F1)
            ),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${profile.firstName} ${profile.lastName}",
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(onClick = onEditClick) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Chỉnh sửa")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text("📍 Nơi ở: ${profile.location}")
                Text("👤 Giới tính: ${profile.gender}")
                Text("🎓 Trình độ học vấn: ${profile.education}")
                Text("💼 Kinh nghiệm: ${profile.experience}")

                profile.birthDate?.let {
                    val dateStr = "${it.dayOfMonth}/${it.monthValue}/${it.year}"
                    Text("🎂 Ngày sinh: $dateStr")
                }
            }
        }
    }
}

// Preview để xem giao diện
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ProfileDisplayPreview() {
    val sampleUser = User(
        firstName = "Nguyễn",
        lastName = "Văn A",
        location = "TP. HCM",
        gender = "Nam",
        education = "Đại học CNTT",
        experience = "2 năm làm Android",
        birthDate = LocalDate.of(1998, 8, 15)
    )

    ProfileDisplayContent(profile = sampleUser)
}
