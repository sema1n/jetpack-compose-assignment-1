package com.example.jetpackcomposeassignment1.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeassignment1.data.Course
import com.example.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

@Composable
fun CourseCard(course: Course) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .clickable { isExpanded = !isExpanded }
            .animateContentSize(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(24.dp)) {

            Text(
                text = course.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = course.code,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "${course.creditHours} Credits",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null
                )
            }

            if (isExpanded) {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "Description: ${course.description}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Prerequisites: ${course.prerequisites}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCourseCardLight() {
    JetpackComposeAssignment1Theme(darkTheme = false) {
        val course = Course(
            title = "Mobile App Development",
            code = "CS301",
            creditHours = 3,
            description = "Learn to build Android apps using Kotlin and Jetpack Compose.",
            prerequisites = "CS201 - Object-Oriented Programming"
        )
        CourseCard(course = course)
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewCourseCardDark() {
    JetpackComposeAssignment1Theme(darkTheme = true) {
        val course = Course(
            title = "Mobile App Development",
            code = "CS301",
            creditHours = 3,
            description = "Learn to build Android apps using Kotlin and Jetpack Compose.",
            prerequisites = "CS201 - Object-Oriented Programming"
        )
        CourseCard(course = course)
    }
}

