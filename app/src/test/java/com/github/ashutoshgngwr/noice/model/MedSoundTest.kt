package com.github.ashutoshgngwr.noice.model

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MedSoundTest {

  @Test
  fun testMedSoundSources() {
    // this is to validate whether the source files provided in the sound library exist.
    // main goal here is to avoid typos in one of the sound samples since it's hard to notice
    // if all samples of a sound are playing when played simultaneously.
    val files = ApplicationProvider.getApplicationContext<Context>().assets.list("")
    requireNotNull(files).toSet()

    MedSound.MEDITATIONLIBRARY.forEach { (_, sound) ->
      sound.src.forEach {
        assertTrue("'$it' not found in assets", files.contains(it))
      }
    }
  }

  @Test
  fun testFilterMeditationLibraryByTag() {
    assertEquals(
      "should contain all keys when tag is null",
      MedSound.MEDITATIONLIBRARY.size,
      MedSound.filterMeditationLibraryByTag(null).size
    )

    for (tag in MedSound.Tag.values()) {
      MedSound.filterMeditationLibraryByTag(tag).forEach {
        assertTrue(
          "should only contain keys of sounds that have the given tag",
          MedSound.get(it).tags.contains(tag)
        )
      }
    }
  }
}
