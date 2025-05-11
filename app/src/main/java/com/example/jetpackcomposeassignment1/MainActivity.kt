package com.example.jetpackcomposeassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.jetpackcomposeassignment1.data.Course
import com.example.jetpackcomposeassignment1.ui.CourseListScreen
import com.example.jetpackcomposeassignment1.ui.OnboardingScreen
import com.example.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAssignment1Theme {
                var showOnboarding by remember { mutableStateOf(true) }
                val courses = listOf(
                    Course(
                        title = "Mobile App Development",
                        code = "CS301",
                        creditHours = 3,
                        description = "This course teaches students how to design and develop modern Android applications using Kotlin and Jetpack Compose. Topics include UI components, state management, navigation, REST API integration, and testing techniques. By the end of the course, students will be able to build fully functional mobile apps ready for deployment.",
                        prerequisites = "CS201 - Object-Oriented Programming"
                    ),
                    Course(
                        title = "Artificial Intelligence",
                        code = "CS401",
                        creditHours = 4,
                        description = "An in-depth introduction to artificial intelligence concepts such as search algorithms, logic programming, machine learning fundamentals, and neural networks. Students will work on hands-on labs to implement AI models and understand their real-world applications including natural language processing and computer vision.",
                        prerequisites = "CS301 - Mobile App Development"
                    ),
                    Course(
                        title = "Web Development",
                        code = "CS305",
                        creditHours = 3,
                        description = "This course provides a comprehensive understanding of full-stack web development. It begins with HTML, CSS, and JavaScript for frontend development and progresses into backend technologies such as Node.js, Express, and MongoDB. Students will complete a final project where they build and deploy a fully functional dynamic website.",
                        prerequisites = "None"
                    ),
                    Course(
                        title = "Data Structures and Algorithms",
                        code = "CS210",
                        creditHours = 4,
                        description = "This course covers fundamental data structures such as arrays, linked lists, stacks, queues, trees, and graphs. Algorithm analysis and complexity theory are also introduced, focusing on sorting, searching, recursion, and optimization strategies. Students will solve algorithmic problems using real coding challenges and performance benchmarks.",
                        prerequisites = "CS101 - Introduction to Computer Science"
                    ),
                    Course(
                        title = "Operating Systems",
                        code = "CS310",
                        creditHours = 3,
                        description = "This course explores the core principles of operating systems including process scheduling, memory management, file systems, concurrency, and system security. Case studies of popular OS platforms like Linux and Windows will be used to demonstrate how theoretical concepts apply in practice. Labs involve writing low-level system programs and analyzing OS behavior.",
                        prerequisites = "CS210 - Data Structures and Algorithms"
                    ),
                    Course(
                            title = "Computer Networks",
                    code = "CS306",
                    creditHours = 3,
                    description = "This course explores the core principles of computer networks including process scheduling, memory management, file systems, concurrency, and system security. Case studies of popular OS platforms like Linux and Windows will be used to demonstrate how theoretical concepts apply in practice. Labs involve writing low-level system programs and analyzing OS behavior.",
                    prerequisites = "CS210 - Data Structures and Algorithms"
                ),
                    Course(
                        title = "Human-Computer Interaction",
                        code = "CS309",
                        creditHours = 2,
                        description = "This course explores the core principle of how computers and humans interact using UI.",
                        prerequisites = "CS210 - Data Structures and Algorithms"
                    )

                )

                if (showOnboarding) {
                    OnboardingScreen(onContinueClicked = { showOnboarding = false })
                } else {
                    CourseListScreen(courseList = courses)
                }
            }
        }
    }
}