package com.example.medinfo.utils

import kotlin.random.Random

object HealthTips {
    private val tips = listOf(
        "Stay hydrated by drinking at least 8 glasses of water a day.",
        "Eat a balanced diet rich in fruits and vegetables.",
        "Exercise regularly to maintain a healthy weight.",
        "Get enough sleep to help your body recover.",
        "Practice mindfulness or meditation to reduce stress.",
        "Limit your intake of processed foods and sugars.",
        "Take breaks during work to improve productivity.",
        "Avoid smoking and excessive alcohol consumption.",
        "Wash your hands frequently to prevent illness.",
        "Stay active by incorporating physical activity into your daily routine.",
        "Maintain a healthy work-life balance.",
        "Regularly check your blood pressure and cholesterol levels.",
        "Stay connected with friends and family for emotional support.",
        "Limit screen time to reduce eye strain.",
        "Practice good posture to avoid back pain.",
        "Incorporate more whole grains into your diet.",
        "Consider taking a multivitamin if your diet lacks certain nutrients.",
        "Stay informed about health topics that interest you.",
        "Volunteer or help others to boost your mood.",
        "Keep a journal to track your health and wellness goals.",
        "Seek professional help if you're feeling overwhelmed."
    )

    fun getRandomTip(): String {
        return tips[Random.nextInt(tips.size)]
    }
}