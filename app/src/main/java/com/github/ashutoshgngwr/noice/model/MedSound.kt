package com.github.ashutoshgngwr.noice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.ashutoshgngwr.noice.R

/**
 *  A data class that holds reference to a sound effect's asset path, title
 *  resource id from android resources and whether or not is it looping.
 *  It also declares a static instance 'LIBRARY' that defines the complete
 *  sound library supported by Noice.
 *
 *  @param src relative file paths of the sound sources in the app assets
 *  @param titleResID display title
 *  @param displayGroupResID display category of the sound
 *  @param isLooping if the [MedSound] should loop when played
 */
class MedSound private constructor(
  val src: Array<String>,
  @StringRes val titleResID: Int,
  @StringRes val displayGroupResID: Int,
  @DrawableRes val iconID: Int,
  val isLooping: Boolean = true,
  val tags: Array<Tag> = emptyArray()
) {

  enum class Tag { Halka, Fulka, Dhamka, Pritam, Zaatwo }

  companion object {
    /**
     * Static sound library with various effects. All files in [src] array are looked up in the assets.
     */

    val MEDITATIONLIBRARY = mapOf(
      "2_Meditation_for_Stress_Relief_and_Building_Confidence_Mindful_Movement" to MedSound(
        src = arrayOf("2_Meditation_for_Stress_Relief_and_Building_Confidence_Mindful_Movement.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation,
        iconID = R.drawable.a,
        tags = arrayOf(Tag.Zaatwo)
      ),
      "airplane_seatbelt_beeps" to MedSound(
        src = arrayOf("airplane_seatbelt_beeps.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_1,
        iconID = R.drawable.b,
        tags = arrayOf(Tag.Zaatwo)
      ),
      "birds" to MedSound(
        src = arrayOf("birds_0.mp3", "birds_1.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_2,
        iconID = R.drawable.c,
        tags = arrayOf(Tag.Zaatwo)
      ),
      "bonfire" to MedSound(
        src = arrayOf("bonfire_0.mp3", "bonfire_1.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_3,
        iconID = R.drawable.d,
        tags = arrayOf(Tag.Fulka, Tag.Dhamka)
      ),
      "brownian_noise" to MedSound(
        src = arrayOf("brownian_noise.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_4,
        iconID = R.drawable.e,
        tags = arrayOf(Tag.Zaatwo)
      ),
      "coffee_shop" to MedSound(
        src = arrayOf("guided_meditation.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_5,
        iconID = R.drawable.f,
        tags = arrayOf(Tag.Halka)
      ),
      "creaking_ship" to MedSound(
        src = arrayOf("creaking_ship_0.mp3", "creaking_ship_1.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_6,
        iconID = R.drawable.g,
        tags = arrayOf(Tag.Zaatwo)
      ),
      "crickets" to MedSound(
        src = arrayOf("crickets.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_7,
        iconID = R.drawable.h,
        tags = arrayOf(Tag.Dhamka)
      ),
      "distant_thunder" to MedSound(
        src = arrayOf("distant_thunder.mp3"),
        titleResID = R.string.med,
        displayGroupResID = R.string.sound_group__meditation_8,
        iconID = R.drawable.i,
        tags = arrayOf(Tag.Zaatwo, Tag.Pritam)
      ),
    )

    /**
     * A helper function to keep it lean
     */
    fun get(key: String) = requireNotNull(MEDITATIONLIBRARY[key])

    /**
     * [filterLibraryByTag] returns the keys whose [MedSound] contain the given [tag]. If the given
     * [tag] is empty, it returns all keys from the library.
     */
    fun filterMeditationLibraryByTag(tag: Tag?): Collection<String> {
      tag ?: return MEDITATIONLIBRARY.keys
      return MEDITATIONLIBRARY.filter { it.value.tags.contains(tag) }.map { it.key }
    }
  }
}
