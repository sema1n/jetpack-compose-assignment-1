
package com.example.jetpackcomposeassignment1.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import com.example.jetpackcomposeassignment1.data.Course

@Composable
fun CourseListScreen(courseList: List<Course>) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 40.dp,
            bottom = 16.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        items(courseList) { course ->
            CourseCard(course = course)
        }
    }
}

