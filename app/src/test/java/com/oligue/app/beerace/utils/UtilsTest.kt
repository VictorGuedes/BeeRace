package com.oligue.app.beerace.utils

import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest {

    @Test
    fun `when convert seconds to milliseconds`() {

        // Given
        val milisseconds = 10000L

        // When
        val result = convertToMilliseconds(10)

        // Then
        assertEquals(milisseconds, result)
    }

}

