package com.and.mindeaseapp.ui.theme

import androidx.lifecycle.ViewModel
import com.and.mindeaseapp.data.Doctor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DoctorViewModel : ViewModel() {
    private val _sampleDoctors = MutableStateFlow(
        listOf(
            Doctor("Dr. Anjali Mehra", "Clinical Psychologist", 7, 4.6),
            Doctor("Dr. Ravi Kumar", "Counseling Psychologist", 5, 4.3),
            Doctor("Dr. Sneha Roy", "Psychiatrist", 10, 4.8),
            Doctor("Dr. Aashish John", "Psychiatrist", 15, 4.6),
            Doctor("Dr. Priyanka Sunny", "Psychiatrist", 9, 4.3)
        )
    )
    val sampleDoctors: StateFlow<List<Doctor>> = _sampleDoctors
}